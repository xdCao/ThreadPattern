package GuardedSuspension;

/**
 * created by xdCao on 2017/12/27
 */

public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ Request "+name+" ]";
    }

    public String getName() {
        return name;
    }
}
