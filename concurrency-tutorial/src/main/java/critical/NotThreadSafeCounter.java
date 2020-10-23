package critical;

/**
 * @author hyeonisism
 */
public class NotThreadSafeCounter {

    private long count = 0;

    public void increase() {
        count++;
    }

    public long getCount() {
        return count;
    }
}
