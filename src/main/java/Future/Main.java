package Future;

import jdk.nashorn.internal.runtime.ECMAErrors;

/**
 * created by xdCao on 2018/1/4
 */

public class Main {

    public static void main(String[] args) {
        Host host=new Host();
        Data data1=host.request(10,'A');
        Data data2=host.request(20,'B');
        Data data3=host.request(30,'C');
        System.out.println("main other job begin");
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println("main other job end");
        System.out.println("data1 = "+data1.getContent());
        System.out.println("data2 = "+data2.getContent());
        System.out.println("data3 = "+data3.getContent());
        System.out.println("main end");

    }

}
