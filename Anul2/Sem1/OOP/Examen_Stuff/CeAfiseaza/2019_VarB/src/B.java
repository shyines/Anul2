public class B {
    String x = "POO ";
    static int y = 10;
    public B(String x) {
        y -= 2;
        x = "Examen ";
    }
    boolean equals(B obj) {
        return x.equals(obj.x);
    }
    public String method() {
        return x + "Iarna ";
    }
}
