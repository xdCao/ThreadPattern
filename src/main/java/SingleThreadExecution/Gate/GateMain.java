package SingleThreadExecution.Gate;

/**
 * created by xdCao on 2017/12/27
 */

public class GateMain {


    public static void main(String[] args) {
        System.out.println("Testing gate................");
        Gate gate=new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Boston").start();
        new UserThread(gate,"Cris","China").start();
    }


}
