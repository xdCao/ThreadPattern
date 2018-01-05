package ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * created by xdCao on 2018/1/3
 */

public class LockData {

    private final char[] bufffer;

    private final ReadWriteLock lock=new ReentrantReadWriteLock(true);

    private final Lock readLock=lock.readLock();

    private final Lock writerLock=lock.writeLock();

    public LockData(int size) {
        this.bufffer=new char[size];
        for (int i = 0; i < bufffer.length; i++) {
            bufffer[i]='*';
        }
    }

    public char[] read() throws InterruptedException {
        readLock.lock();
        try {
            return doRead();
        } finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException {
        writerLock.lock();
        try {
            doWrite(c);
        }finally {
            writerLock.unlock();
        }
    }

    private void doWrite(char c) throws InterruptedException {
        for (int i = 0; i < bufffer.length; i++) {
            bufffer[i]=c;
        }
        Thread.sleep(60);
    }

    private char[] doRead() throws InterruptedException {
        char[] newBuf=new char[bufffer.length];
        System.arraycopy(bufffer,0,newBuf,0,bufffer.length);
        Thread.sleep(60);
        return newBuf;
    }

}
