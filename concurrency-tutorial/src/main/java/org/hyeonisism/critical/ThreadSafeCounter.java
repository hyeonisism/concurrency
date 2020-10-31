package org.hyeonisism.critical;

import org.hyeonisism.common.Counter;

/**
 * @author hyeonisism
 */
public class ThreadSafeCounter implements Counter {

    private volatile int count = 0;

    @Override
    public synchronized void increase() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
