package TwoPhaseTermination;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by xdCao on 2018/1/5
 */

public class BarrierMain {

    private static final int THREADS=3;

    public static void main(String[] args) {
        System.out.println("begin");
        ExecutorService service= Executors.newFixedThreadPool(THREADS);
        Runnable barrierAction=new Runnable() {
            public void run() {
                System.out.println("Barrier action!");
            }
        };
        CyclicBarrier phaseBarrier=new CyclicBarrier(THREADS,barrierAction);
        CountDownLatch latch=new CountDownLatch(THREADS);
        try {
            for (int i = 0; i < THREADS; i++) {
                service.execute(new BarrierTask(phaseBarrier,latch,i));
            }
            System.out.println("await");
            latch.await();
        }catch (Exception e){

        }finally {
            service.shutdown();
            System.out.println("end");
        }
    }

}
