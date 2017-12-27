package SingleThreadExecution.Gate;

/**
 * created by xdCao on 2017/12/27
 */

public class Gate {

    private int counter=0;

    private String name="nobody";

    private String address="nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public synchronized String toString() {
        return "No."+counter+":"+name+", "+address;
    }

    private void check() {
        if (name.charAt(0)!=address.charAt(0)){
            System.out.println("***********BROKEN**********"+toString());
        }
    }


}
