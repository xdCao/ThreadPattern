package TwoPhaseTermination;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * created by xdCao on 2018/1/5
 */

public class BarrierTask implements Runnable {

    private static final int PHASE=5;

    private final CyclicBarrier phaseBarrier;

    private final CountDownLatch latch;

    private final int context;

    private final static Random random=new Random(314159);

    public BarrierTask(CyclicBarrier phaseBarrier, CountDownLatch latch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.latch = latch;
        this.context = context;
    }

    public void run() {

        try {
            for(int phase=0;phase<PHASE;phase++){
                doPhase(phase);
                phaseBarrier.await();
            }
        }catch (Exception e){

        }finally {
            latch.countDown();
        }

    }

    private void doPhase(int phase) {
        String name=Thread.currentThread().getName();
        System.out.println(name+":MyTask:begin:context="+context+",phase="+phase);
        try {
            Thread.sleep(random.nextInt(3000));
        }catch (Exception e){

        }finally {
            System.out.println(name+":MyTask:end:context="+context+",phase="+phase);
        }
    }
}
