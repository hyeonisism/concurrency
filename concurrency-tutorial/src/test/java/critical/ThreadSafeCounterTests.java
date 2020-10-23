package critical;

import org.junit.jupiter.api.Test;

/**
 * @author hyeonisism
 */
class ThreadSafeCounterTests extends AbstractCounterTests {

    @Test
    void shouldReturnCorrect() throws InterruptedException {
        // expect
        shouldThreadSafe(new ThreadSafeCounter());
    }
}
