//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends A{
    static {
        x = init(2);
    }

    public Main () {
        super("2020");
        y += "3";
    }

    public String info() {
        return "ABC";
    }


    public static void main(String[] args) {
        System.out.println(A.x);

        A a = new Main();
        System.out.println(a.y);
        System.out.println(a.info());
        System.out.println(a.operatie(22));

        A r = new A("Examen");
        A s = new A("Examen");
        System.out.println(r.equals(s));
        A[][][] t = new A[4][5][6];
        System.out.println(t.length);

    }
}