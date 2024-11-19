//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex (1, 2);
        Complex c2 = new Complex (3, 4);
        Fractie f1 = new Fractie(0.25f);
        Fractie f2 = new Fractie(0.35f);

        Numeric result = c1.adunare(c2);
        Numeric result2 = c1.adunare(f1);
        Numeric result3 = f1.adunare(f2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}