package ReadWriteLock;

/**
 * created by xdCao on 2018/1/2
 */

public class ReaderThread extends Thread{

    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] readBuf=data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf));
            }
        }catch (Exception e){}
    }
}
