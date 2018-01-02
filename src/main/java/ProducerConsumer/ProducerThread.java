package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * created by xdCao on 2018/1/2
 */

public class ProducerThread extends Thread {

    private final Exchanger<char[]> exchanger;

    private char[] buffer=null;

    private char index=0;

    private final Random random;

    public ProducerThread(Exchanger<char[]> exchanger, char[] buffer,long seed) {
        super("ProducerThread");
        this.random=new Random(seed);
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true){
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]=nextChar();
                    System.out.println(Thread.currentThread().getName()+" : "+buffer[i]+" -> ");
                }
                System.out.println(Thread.currentThread().getName()+": BEFORE EXCHANGE");
                buffer=exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+": after exchange");
            }
        }catch (Exception e){}
    }

    private char nextChar() throws InterruptedException {
        char c=(char)('a'+index%26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
