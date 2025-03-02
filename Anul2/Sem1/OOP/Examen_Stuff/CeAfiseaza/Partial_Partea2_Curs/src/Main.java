//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        A obj = new B();
        System.out.println(obj instanceof A);
        System.out.println(obj instanceof B);
        System.out.println(obj.getClass().getSuperclass().getName());
        obj.display();
        ((A)obj).display();
        System.out.println(obj.getPlusX());
        System.out.println(((A)obj).getPlusX());
        System.out.println(((B)obj).getY());
        System.out.println(obj.x);
        System.out.println(((B)obj).x);
    }
}