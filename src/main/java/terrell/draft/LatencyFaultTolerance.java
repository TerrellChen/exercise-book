package terrell.draft;

public interface LatencyFaultTolerance<T> {
    void updateFaultItem(final T name, final long currentLatency, final long notAvailableDuration);

    boolean isAvailable(final T name);

    void remove(final T name);

    T pickOneAtLeast();
}
