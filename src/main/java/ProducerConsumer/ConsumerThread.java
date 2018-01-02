package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * created by xdCao on 2018/1/2
 */

public class ConsumerThread extends Thread {

    private final Exchanger<char[]> exchanger;

    private char[] buffer=null;

    private final Random random;

    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.random=new Random(seed);
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true){

                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName()+" : ->"+buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }

                System.out.println(Thread.currentThread().getName()+" : before exchange");
                buffer=exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+" : after exchange");
            }

        }catch (Exception e){}
    }
}
