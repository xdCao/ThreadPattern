package Balking;

import javax.sql.DataSource;
import java.util.Random;

/**
 * created by xdCao on 2017/12/28
 */

public class ChangerThread extends Thread {

    private final Data data;
    private final Random random=new Random();

    public ChangerThread(String name,Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No."+i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        }catch (Exception e){}
    }
}
