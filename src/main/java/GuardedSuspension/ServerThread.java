package GuardedSuspension;

import java.util.Random;

/**
 * created by xdCao on 2017/12/28
 */

public class ServerThread extends Thread{

    private final Random random;
    private final RequestQueue requestQueue;


    public ServerThread(String name,long seed,RequestQueue requestQueue) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            Request request=requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName()+" handles "+request);
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (Exception e){}
        }

    }
}
