package ThreadLocal;

import jdk.nashorn.internal.runtime.ECMAErrors;

/**
 * created by xdCao on 2018/1/5
 */

public class ClientThread extends Thread{

    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName()+" begin");
        for (int i = 0; i < 10; i++) {
            Log.println("i= "+i);
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
        Log.close();
        System.out.println(getName()+" end");

    }
}
