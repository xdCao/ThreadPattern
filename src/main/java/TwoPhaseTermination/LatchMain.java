package TwoPhaseTermination;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by xdCao on 2018/1/5
 */

public class LatchMain {

    private static final int TASKS=10;

    public static void main(String[] args) {
        System.out.println("begin");
        ExecutorService service= Executors.newFixedThreadPool(5);
        CountDownLatch latch=new CountDownLatch(TASKS);
        try {
            for (int i = 0; i < TASKS; i++) {
                service.execute(new MyTask(latch,i));
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
