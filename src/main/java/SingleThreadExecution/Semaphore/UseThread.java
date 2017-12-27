package SingleThreadExecution.Semaphore;

import java.util.Random;

/**
 * created by xdCao on 2017/12/27
 */

public class UseThread extends Thread {

    private final static Random random=new Random(26535);
    private final BoundedResource resource;

    public UseThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        try {
            while (true){
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        }catch (Exception e){}
    }

}
