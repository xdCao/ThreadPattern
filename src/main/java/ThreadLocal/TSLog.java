package ThreadLocal;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * created by xdCao on 2018/1/5
 */

public class TSLog {

    private PrintWriter writer=null;

    public TSLog(String filename) {
        try {
            writer=new PrintWriter(new FileWriter(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void println(String s){
        writer.println(s);
    }

    public void close(){
        writer.println("===end of log===");
        writer.close();
    }

}
