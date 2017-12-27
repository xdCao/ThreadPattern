package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by xdCao on 2017/12/27
 */

public class RequestQueue {

    private final Queue<Request> queue=new LinkedList<Request>();

    public synchronized Request getRequest(){
        while (queue.peek()==null){
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }


}
