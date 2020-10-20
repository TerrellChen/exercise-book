package terrell.draft;

import java.util.Map;

public class FaultStrategy<T> {
//    private final static Logger logger = LoggerFactory.getLogger(FaultStrategy.class);

    private final LatencyFaultTolerance<String> latencyFaultTolerance = new LatencyFaultToleranceImpl();

    private boolean latencyFaultEnable = false;

    // 从开始请求到当前到时间
    private long[] latencyMax = {50L, 100L, 550L, 1000L, 2000L, 3000L, 15000L};
    // 每个级别对应的不可用时间预计
    private long[] notAvailableDuration = {0L, 0L, 30000L, 60000L, 120000L, 180000L, 600000L};

    public LatencyFaultTolerance<String> getLatencyFaultTolerance() {
        return latencyFaultTolerance;
    }

    public boolean isLatencyFaultEnable() {
        return latencyFaultEnable;
    }

    public void setLatencyFaultEnable(boolean latencyFaultEnable) {
        this.latencyFaultEnable = latencyFaultEnable;
    }

    public long[] getLatencyMax() {
        return latencyMax;
    }

    public void setLatencyMax(long[] latencyMax) {
        this.latencyMax = latencyMax;
    }

    public long[] getNotAvailableDuration() {
        return notAvailableDuration;
    }

    public void setNotAvailableDuration(long[] notAvailableDuration) {
        this.notAvailableDuration = notAvailableDuration;
    }

    public T selectOne(final Map<String, T> candidates, final String preferedName, final String lastName) {
        if (this.latencyFaultEnable) {
            try {
                if (latencyFaultTolerance.isAvailable(preferedName)) {
                    if (candidates.containsKey(preferedName)) {
                        return candidates.get(preferedName);
                    }
                }

                final String notBest = latencyFaultTolerance.pickOneAtLeast();
                if (candidates.containsKey(notBest)) {
                    return candidates.get(notBest);
                } else {
                    latencyFaultTolerance.remove(notBest);
                }
            } catch (Exception e) {
                // TODO log
            }
        }
        return candidates.get(lastName);
    }

    public void updateFaultItem(final String name, final long currentLatency, boolean isolation) {
        if (this.latencyFaultEnable) {
            long duration = computeNotAvaliableDuration(isolation ? 30000 : currentLatency);
            this.latencyFaultTolerance.updateFaultItem(name, currentLatency, duration);
        }
    }

    private long computeNotAvaliableDuration(final long currentLatency) {
        for (int i = latencyMax.length - 1; i >= 0; i--) {
            if (currentLatency >= latencyMax[i]) {
                return this.notAvailableDuration[i];
            }
        }
        return 0;
    }
}
