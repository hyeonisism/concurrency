package org.hyeonisism.basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author hyeonisism
 */
class ThreadRunTests {

    @Test
    void shouldThreadRun() {
        // given
        int threadActiveCount = Thread.activeCount();

        final Thread thread = new BasicThread();

        // when
        thread.start();

        // then
        assertThat(Thread.activeCount()).isEqualTo(threadActiveCount + 1);
    }

    @Test
    void shouldRunnableRun() {
        // given
        int threadActiveCount = Thread.activeCount();

        final Runnable runnable = new BasicRunnable();

        // when
        new Thread(runnable).start();

        // then
        assertThat(Thread.activeCount()).isEqualTo(threadActiveCount + 1);
    }

    @Test
    void shouldReturnThreadName() {
        // given
        final String threadName = "name";
        final Runnable basicRunnable = new BasicRunnable();
        final Thread runThread = new Thread(basicRunnable, threadName);

        // when
        runThread.start();

        // then
        assertThat(runThread.getName()).isEqualTo(threadName);
    }
}
