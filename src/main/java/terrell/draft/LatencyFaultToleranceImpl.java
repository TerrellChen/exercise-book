package terrell.draft;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LatencyFaultToleranceImpl implements LatencyFaultTolerance<String> {
    private final ConcurrentHashMap<String, FaultItem> faultItemTable = new ConcurrentHashMap<String, FaultItem>();
    private final ThreadLocalIndex whichItemWorst = new ThreadLocalIndex();

    @Override
    public void updateFaultItem(final String name, final long currentLatency, final long notAvailableDuration) {
        FaultItem old = this.faultItemTable.get(name);
        if (null == old) {
            final FaultItem faultItem = new FaultItem(name);
            faultItem.setCurrentLatency(currentLatency);
            faultItem.setRecoverTimestamp(System.currentTimeMillis() + notAvailableDuration);

            old = this.faultItemTable.putIfAbsent(name, faultItem);
            if (old != null) {
                old.setCurrentLatency(currentLatency);
                old.setRecoverTimestamp(System.currentTimeMillis() + notAvailableDuration);
            }
        } else {
            old.setCurrentLatency(currentLatency);
            old.setRecoverTimestamp(System.currentTimeMillis() + notAvailableDuration);
        }

    }

    @Override
    public boolean isAvailable(final String name) {
        final FaultItem faultItem = this.faultItemTable.get(name);
        if (faultItem != null) {
            return faultItem.isAvailable();
        }
        return true;
    }

    @Override
    public void remove(final String name) {
        this.faultItemTable.remove(name);
    }

    @Override
    public String pickOneAtLeast() {
        final Enumeration<FaultItem> elements = this.faultItemTable.elements();
        List<FaultItem> tmpList = new LinkedList<>();
        while (elements.hasMoreElements()) {
            final FaultItem faultItem = elements.nextElement();
            tmpList.add(faultItem);
        }
        if (!tmpList.isEmpty()) {
            Collections.shuffle(tmpList);
            Collections.sort(tmpList);

            final int half = tmpList.size() / 2;
            if (half <= 0) {
                return tmpList.get(0).getName();
            } else {
                final int i = this.whichItemWorst.getAndIncrement() % half;
                return tmpList.get(i).getName();
            }

        }

        return null;
    }

    class ThreadLocalIndex {
        private final ThreadLocal<Integer> threadLocalIndex = new ThreadLocal<>();
        private final Random random = new Random();

        public int getAndIncrement() {
            Integer index = this.threadLocalIndex.get();
            if (null == index) {
                index = Math.abs(random.nextInt());
                if (index < 0) {
                    index = 0;
                }
                this.threadLocalIndex.set(index);
            }

            index = Math.abs(index + 1);
            if (index < 0) {
                index = 0;
            }
            this.threadLocalIndex.set(index);
            return index;
        }

        @Override
        public String toString() {
            return "ThreadLocalIndex{" +
                    "threadLocalIndex=" + threadLocalIndex +
                    '}';
        }
    }

    class FaultItem implements Comparable<FaultItem> {
        private final String name;
        private volatile long currentLatency;
        private volatile long recoverTimestamp;

        public FaultItem(final String name) {
            this.name = name;
        }

        @Override
        public int compareTo(FaultItem o) {
            if (this.isAvailable() != o.isAvailable()) {
                if (this.isAvailable())
                    return -1;

                if (o.isAvailable())
                    return 1;
            }

            if (this.currentLatency < o.currentLatency)
                return -1;
            else if (this.currentLatency > o.currentLatency) {
                return 1;
            }

            if (this.recoverTimestamp < o.recoverTimestamp)
                return -1;
            else if (this.recoverTimestamp > o.recoverTimestamp) {
                return 1;
            }

            return 0;
        }

        public boolean isAvailable() {
            return (System.currentTimeMillis() - recoverTimestamp) >= 0;
        }

        @Override
        public int hashCode() {
            int result = getName() != null ? getName().hashCode() : 0;
            result = 31 * result + (int) (getCurrentLatency() ^ (getCurrentLatency() >>> 32));
            result = 31 * result + (int) (getRecoverTimestamp() ^ (getRecoverTimestamp() >>> 32));
            return result;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (!(o instanceof FaultItem))
                return false;

            final FaultItem faultItem = (FaultItem) o;

            if (getCurrentLatency() != faultItem.getCurrentLatency())
                return false;
            if (getRecoverTimestamp() != faultItem.getRecoverTimestamp())
                return false;
            return getName() != null ? getName().equals(faultItem.getName()) : faultItem.getName() == null;

        }

        @Override
        public String toString() {
            return "FaultItem{" +
                    "name='" + name + '\'' +
                    ", currentLatency=" + currentLatency +
                    ", recoverTimestamp=" + recoverTimestamp +
                    '}';
        }

        public String getName() {
            return name;
        }

        public long getCurrentLatency() {
            return currentLatency;
        }

        public void setCurrentLatency(final long currentLatency) {
            this.currentLatency = currentLatency;
        }

        public long getRecoverTimestamp() {
            return recoverTimestamp;
        }

        public void setRecoverTimestamp(final long recoverTimestamp) {
            this.recoverTimestamp = recoverTimestamp;
        }


    }
}
