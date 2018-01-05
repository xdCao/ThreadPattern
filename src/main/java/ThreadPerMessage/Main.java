package ThreadPerMessage;

/**
 * created by xdCao on 2018/1/3
 */

public class Main {

    public static void main(String[] args) {
        Host host=new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');

    }

}
