//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getX());
        A b1 = new B();
        B b2 = (B) b1;
        new B();
        System.out.println(b1.x);
        System.out.println(b2.myMethod("8"));
        System.out.println(b2.myMethod(9));
        System.out.println(b2.x);
        System.out.println(b2.getX());
        System.out.println(b1 == b2);
        System.out.println(a.equals(b1));
        System.out.println(a.getClass().getSuperclass().getName());
        System.out.println(A.c);
    }
}