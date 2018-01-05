package WorkerThread;

import jdk.nashorn.internal.runtime.ECMAErrors;

/**
 * created by xdCao on 2018/1/4
 */

public class Channel {

    private static final int MAX_REQUEST=100;
    private final Request[] requestQueue;
    private int tail;
    private int head;
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threads){
        this.requestQueue=new Request[MAX_REQUEST];
        this.head=0;
        this.tail=0;
        this.count=0;
        threadPool=new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i]=new WorkerThread("Worker-"+i,this);
        }
    }

    public void startWorkers(){
        for (int i = 0; i < threadPool.length;i++){
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Request request){
        while (count>=requestQueue.length){
            try {
                wait();
            }catch (Exception e){}
        }
        requestQueue[tail]=request;
        tail=(tail+1)%requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while (count<=0){
            try {
                wait();
            }catch (Exception e){}
        }
        Request request=requestQueue[head];
        head=(head+1)%requestQueue.length;
        count--;
        notifyAll();
        return request;
    }

}
