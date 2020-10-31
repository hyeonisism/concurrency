package org.hyeonisism.lock;

/**
 * @author hyeonisism
 */
public class Lock {

    private boolean isLocked = false;
    private Thread lockingThread;

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException();
        }
        isLocked = false;
        lockingThread = null;
        notifyAll();
    }
}
