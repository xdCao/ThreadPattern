package TwoPhaseTermination;

/**
 * created by xdCao on 2018/1/4
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("main:begin");
        try {
            CountupThread thread=new CountupThread();
            thread.start();
            Thread.sleep(10000);
            System.out.println("main:shutdownRequest");
            thread.shutdownRequest();
            System.out.println("main:join");
            thread.join();
        }catch (Exception e){

        }
        System.out.println("main:end");
    }

}
