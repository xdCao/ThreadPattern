package SingleThreadExecution.Semaphore;

/**
 * created by xdCao on 2017/12/27
 */

public class Log {

    public static void println(String s){
        System.out.println(Thread.currentThread().getName()+":"+s);
    }

}
