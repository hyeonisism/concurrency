package critical;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hyeonisism
 */
class ThreadSafeCounterTests {

    @Test
    void shouldReturnCorrect() throws InterruptedException {
        // given
        final ThreadSafeCounter counter = new ThreadSafeCounter();

        // when
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                counter.add(1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                counter.add(1);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // then
        assertThat(counter.getCount()).isEqualTo(20000);
    }
}
