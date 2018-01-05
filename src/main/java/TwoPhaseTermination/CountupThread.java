package TwoPhaseTermination;

/**
 * created by xdCao on 2018/1/4
 */

public class CountupThread extends Thread{

    private long counter=0;

    private volatile boolean shutdownRequested=false;

    public void shutdownRequest(){
        shutdownRequested=true;
        interrupt();
    }

    public boolean isShutdownRequested(){
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()){
                doWork();
            }
        }catch (Exception e){

        }finally {
            doShutDown();
        }
    }

    private void doShutDown() {

        System.out.println("doShutdown:counter="+counter);

    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork:counter="+counter);
        Thread.sleep(500);
    }



}
