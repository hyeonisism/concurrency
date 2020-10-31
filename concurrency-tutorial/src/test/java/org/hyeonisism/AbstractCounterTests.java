package org.hyeonisism;

import org.hyeonisism.common.Counter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hyeonisism
 */
public abstract class AbstractCounterTests {

    private final int iteration = 20000;

    protected void shouldNotThreadSafe(final Counter counter) throws InterruptedException {
        // when
        increase(counter);

        // then
        assertThat(counter.getCount()).isNotEqualTo(iteration);
    }

    protected void shouldThreadSafe(final Counter counter) throws InterruptedException {
        // when
        increase(counter);

        // then
        assertThat(counter.getCount()).isEqualTo(iteration);
    }

    private void increase(final Counter counter) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < iteration / 2; j++) {
                counter.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < iteration / 2; j++) {
                counter.increase();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
