import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Restaurant r;

        int nrPreparate = 0;
        Scanner sc = new Scanner(System.in);
        nrPreparate = sc.nextInt();

        System.out.println(nrPreparate);
        r = new Restaurant(nrPreparate);

        r.addDesert("Tiramisu");
        r.addDesert("CheesCake");
        r.addPizza("Papanasi");


        r.addPizza("Prosciuto");
        r.addPizza("Cannibale");

        r.addBauturaRacoritoare("Limonada");
        r.addBauturaRacoritoare("Fanta");

        r.arataPreparatele();
    }
}