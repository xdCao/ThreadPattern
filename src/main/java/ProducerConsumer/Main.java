package ProducerConsumer;

/**
 * created by xdCao on 2018/1/2
 */

public class Main {

    public static void main(String[] args) {
        Table table=new Table(3);
        new MakerThread("MakerThread-1", 31415, table).start();
        new MakerThread("MakerThread-2", 92653, table).start();
        new MakerThread("MakerThread-3", 58979, table).start();
        new EaterThread("EaterThread-1",table,32384).start();
        new EaterThread("EaterThread-2",table,62643).start();
        new EaterThread("EaterThread-3",table,38327).start();
    }

}
