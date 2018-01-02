package ProducerConsumer;

/**
 * created by xdCao on 2017/12/28
 */

public class Table {

    private final String[] buffer;
    private int tail;
    private int head;
    private int count;


    public Table(int count) {
        this.buffer=new String[count];
        this.head=0;
        this.count = 0;
        this.tail=0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" puts "+cake);
        while (count>=buffer.length){
            wait();
        }
        buffer[tail]=cake;
        tail=(tail+1)%buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count<=0){
            wait();
        }
        String cake=buffer[head];
        head=(head+1)%buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName()+" takes "+cake);
        return cake;
    }


}
