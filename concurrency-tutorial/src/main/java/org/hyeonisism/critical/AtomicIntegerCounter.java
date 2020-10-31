package org.hyeonisism.critical;

import org.hyeonisism.common.Counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hyeonisism
 */
public class AtomicIntegerCounter implements Counter {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increase() {
        count.incrementAndGet();
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
