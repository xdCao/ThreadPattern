package Future;

/**
 * created by xdCao on 2018/1/4
 */

public class RealData implements Data {

    private final String content;

    public RealData(int count,char c){
        System.out.println("    making RealData ("+count+", "+c+") begin");
        char[] buffer=new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i]=c;
            try {
                Thread.sleep(100);
            }catch (Exception e){}
        }
        System.out.println("    making RealData("+count+", "+c+") end");
        this.content=new String(buffer);
    }

    public String getContent() {
        return content;
    }
}
