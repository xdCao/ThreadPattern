package SingleThreadExecution.Semaphore;

/**
 * created by xdCao on 2017/12/27
 */

public class Main {

    public static void main(String[] args) {
        BoundedResource resource=new BoundedResource(3);
        for (int i=0;i<10;i++){
            new UseThread(resource).start();
        }
    }

}
