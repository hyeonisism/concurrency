package critical;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hyeonisism
 */
class NotThreadSafeCounterTests {

    @Test
    void shouldNotThreadSafe() throws InterruptedException {
        // given
        final NotThreadSafeCounter counter = new NotThreadSafeCounter();

        // when
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j <= 10000; j++) {
                counter.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j <= 10000; j++) {
                counter.increase();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // then
        assertThat(counter.getCount()).isNotEqualTo(20000);
    }
}
