package Balking;

/**
 * created by xdCao on 2017/12/28
 */

public class Main {

    public static void main(String[] args) {
        Data data=new Data("data.txt","(empty)");
        new ChangerThread("ChangerThread",data).start();
        new SaverThread("SaverThread",data).start();
    }

}
