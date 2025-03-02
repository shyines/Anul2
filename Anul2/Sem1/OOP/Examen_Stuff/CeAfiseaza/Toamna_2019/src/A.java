public class A {
    static int c;
    String x = "1";
    public A() {
        x += "11";
        c++;
    }
    public String myMethod(String t) {
        x += t;
        return x;
    }
    public String getX() {
        return x;
    }
}
