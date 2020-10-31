package org.hyeonisism.lock;

import org.hyeonisism.AbstractCounterTests;
import org.junit.jupiter.api.Test;

/**
 * @author hyeonisism
 */
class LockCounterTests extends AbstractCounterTests {

    @Test
    void shouldThreadSafe() throws InterruptedException {
        // given
        LockCounter counter = new LockCounter();

        // expect
        shouldThreadSafe(counter);
    }
}
