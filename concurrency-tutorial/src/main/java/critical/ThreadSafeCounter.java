package critical;

/**
 * @author hyeonisism
 */
public class ThreadSafeCounter {

    private volatile long count = 0;

    public synchronized void add(long value) {
        count += value;
    }

    public long getCount() {
        return count;
    }
}
