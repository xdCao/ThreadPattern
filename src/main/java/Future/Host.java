package Future;

/**
 * created by xdCao on 2018/1/4
 */

public class Host {

    public Data request(final int count, final char c){
        System.out.println("    request("+count+", "+c+") begin");
        final FutureData futureData=new FutureData();
        new Thread(){
            @Override
            public void run() {
                RealData realData=new RealData(count,c);
                futureData.setRealData(realData);
            }
        }.start();
        System.out.println("    request("+count+", "+c+") end");
        return futureData;
    }

}
