package GuardedSuspension;

/**
 * created by xdCao on 2017/12/28
 */

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue=new RequestQueue();
        new ClientThread("Alice",3141592,requestQueue).start();
        new ServerThread("Bobby",6535897,requestQueue).start();
    }

}
