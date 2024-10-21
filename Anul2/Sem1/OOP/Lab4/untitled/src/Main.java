import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Autovehicul dacia = new Autovehicul();
        Autovehicul doi = new Autovehicul("Bmw", Color.black, 0,
                            0, 230);
        Autovehicul trei = new Autovehicul("Mazda", Color.black, 0,
                                0, 200);

        System.out.println(dacia.toString());
        System.out.println(doi);
        System.out.println(trei);

        dacia.accel();
        dacia.accel();
        dacia.accel();
        System.out.println(dacia);
        dacia.decelerate();
        System.out.println(dacia);
        dacia.decelerate();
        System.out.println(dacia);

        dacia.oprire();
    }
}