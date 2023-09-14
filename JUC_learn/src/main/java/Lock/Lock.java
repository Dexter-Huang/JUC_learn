package Lock;

import java.util.concurrent.locks.ReentrantLock;

public interface Lock {
    public void lock();
    public void unlock();
}
