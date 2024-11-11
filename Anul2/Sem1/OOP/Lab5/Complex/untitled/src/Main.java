//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(1, -5);
        Complex b = new Complex(1, 5);
        System.out.println(a.toString());
        System.out.println(b.toString());

        a.adunare(b);
        System.out.println(a.toString());

        b.inmultire(a);
        System.out.println(b.toString());

        b.inmultireCuScalar(2);
        System.out.println(b.toString());

        b.scadere(a);
        System.out.println(b.toString());

        Complex[] array = new Complex[] {a, b};

        for(int i = 0;i < array.length; i++) {
            System.out.println(array[i]);
        }

        for(Complex v: array) {
            System.out.println(v);
        }

        Matrice matrice = new Matrice(8 ,8);
    }
}