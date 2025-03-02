public class A extends B{
    static {
        y += 5;
    }
    String x = "Sesiune ";
    public A (String x) {
        super(x);
        y += 8;
    }
    public String method() {
        return x + "Restanta ";
    }
}
