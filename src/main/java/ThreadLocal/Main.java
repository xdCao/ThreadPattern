package ThreadLocal;

/**
 * created by xdCao on 2018/1/5
 */

public class Main {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }

}