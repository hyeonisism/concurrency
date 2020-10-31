package org.hyeonisism.lock;

import org.hyeonisism.common.Counter;

/**
 * @author hyeonisism
 */
public class LockCounter implements Counter {

    private int count = 0;

    private Lock lock = new Lock();

    @Override
    public void increase() {
        lock.lock();
        count++;
        lock.unlock();
    }

    @Override
    public int getCount() {
        return count;
    }
}
