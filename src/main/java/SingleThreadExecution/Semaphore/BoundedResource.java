package SingleThreadExecution.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * created by xdCao on 2017/12/27
 */

public class BoundedResource {

    private final Semaphore semaphore;

    private final int permits;

    private final static Random random=new Random(314159);

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException{
        semaphore.acquire();
        try {
            doUse();
        }finally {
            semaphore.release();
        }
    }

    private void doUse() throws InterruptedException {
        Log.println("BEGIN: used="+(permits-semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used="+(permits-semaphore.availablePermits()));
    }

}
