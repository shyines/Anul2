public class B extends A{
    String x = "2";
    public B() {
        x += "22";
        c++;
    }
    public int myMethod(int t) {
        x += t;
        return 555;
    }
}
