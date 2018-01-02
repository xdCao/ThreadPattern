package ProducerConsumer;

import java.util.Random;

/**
 * created by xdCao on 2018/1/2
 */

public class MakerThread extends Thread {

    private final Random random;
    private final Table table;
    private static int id=0;

    public MakerThread(String name,long seed, Table table) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(random.nextInt(1000));
                String cake="[ Cake No."+nextId()+" by "+getName()+" ]";
                table.put(cake);
            }
        }catch (Exception e){

        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
