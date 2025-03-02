//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(A.y == 10);
        B b = new A("OK");
        System.out.println(A.y);
        A a = new A("OK");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.x);
        System.out.println(b.x);
        System.out.println(a.method());
        System.out.println(b.method());
        B obj = new B("OK");
        System.out.println(obj instanceof A);
        System.out.println(b.getClass().getName());
    }
}