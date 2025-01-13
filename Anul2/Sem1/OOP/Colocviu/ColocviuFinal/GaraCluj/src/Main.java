import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Tren> Gara;

        Locatie locatie1 = new Locatie("Bucuresti", 500);
        Locatie locatie2 = new Locatie("Timisoara", 350);
        Locatie locatie3 = new Locatie("Craiova", 520);
        Locatie locatie4 = new Locatie("Cluj", 0);

        Marfa marfa1 = new Marfa("Mancare", 100);
        Marfa marfa2 = new Marfa("Mancare", 200);
        Marfa marfa3 = new Marfa("Tigari de contrabanda", 600);
        Marfa marfa4 = new Marfa("Pantaloni din Turcia", 500);

        TrenMarfar tren1 = new TrenMarfar("Tren Marfar 1", 1000, 1990, 50, locatie1, locatie4);
        TrenPasager tren2 = new TrenPasager("Tren Pasager 2", 200, 1990, 50, 50, 150, locatie4, locatie3);
        TrenMarfar tren3 = new TrenMarfar("Tren Marfar 3", 500, 1990, 50, locatie2, locatie3);
        TrenPasager tren4 = new TrenPasager("Tren pasager 4", 250, 1990, 9, 20, 230, locatie1, locatie3);

        tren1.addMarfa(marfa1);
        tren1.addMarfa(marfa2);

        tren3.addMarfa(marfa3);
        tren3.addMarfa(marfa4);

        Gara = new ArrayList<>();
        Gara.add(tren1);
        Gara.add(tren2);
        Gara.add(tren3);
        Gara.add(tren4);

        System.out.println("Toate trenurile: ");

        for(Tren it: Gara) {
            System.out.println(it);
        }

        System.out.println("Toate trenurile sortate: ");


        for(Tren it: Gara) {
            System.out.println(it);
        }

        for(Tren it: Gara) {
            try {
                System.out.println(it.getTimpParcurgereRuta() + " Ore");
            } catch (VitezaMicaTrenDefect v) {
                System.out.println("Error: " + v.getMessage());
            }
        }
    }
}