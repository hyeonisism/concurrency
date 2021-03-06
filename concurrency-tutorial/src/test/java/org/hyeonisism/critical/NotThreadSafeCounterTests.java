package org.hyeonisism.critical;

import org.hyeonisism.AbstractCounterTests;
import org.junit.jupiter.api.Test;

/**
 * @author hyeonisism
 */
class NotThreadSafeCounterTests extends AbstractCounterTests {

    @Test
    void shouldNotThreadSafe() throws InterruptedException {
        // expect
        shouldNotThreadSafe(new NotThreadSafeCounter());
    }
}
