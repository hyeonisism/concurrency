package org.hyeonisism.critical;

import org.hyeonisism.common.Counter;

/**
 * @author hyeonisism
 */
public class NotThreadSafeCounter implements Counter {

    private int count = 0;

    @Override
    public void increase() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
