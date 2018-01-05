package ThreadLocal;

/**
 * created by xdCao on 2018/1/5
 */

public class Log {

    private static final ThreadLocal<TSLog> tsLogCollection=new ThreadLocal<TSLog>();

    public static void println(String s){
        getTSLog().println(s);
    }

    public static TSLog getTSLog() {

        TSLog tsLog=tsLogCollection.get();
        if (tsLog==null){
            tsLog=new TSLog(Thread.currentThread().getName()+"-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }

    public static void close(){
        getTSLog().close();
    }

}
