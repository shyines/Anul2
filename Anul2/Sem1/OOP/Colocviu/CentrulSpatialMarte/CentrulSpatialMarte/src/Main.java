import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CentrulSpatial Marte = new CentrulSpatial();

        Pilot Pilot1 = new Pilot("Chira", "Matei", 40, "Pilot de control");
        Pilot Pilot2 = new Pilot("Nick", "Nick", 35, "Pilot de control");
        Pilot Pilot3 = new Pilot("Tinu", "Florian", 40, "Pilot de control");
        Pilot Pilot4 = new Pilot("Alex", "Stoica", 35, "Pilot de control");

        Robot robot1 = new Robot(1);
        Robot robot2 = new Robot(2);
        Om om1 = new Om("Andrei");
        Om om2 = new Om("Bladee");

        AvioaneBoeing Lmao11 = new AvioaneBoeing("Lmao11", 100000000, "Albastru", 2025, Pilot1, 20);
        AvioaneBoeing Lmao12 = new AvioaneBoeing("Lmao12", 100000000, "Albastru", 2024, Pilot2, 20);
        AvioaneBoeing Lmao13 = new AvioaneBoeing("Lmao13", 100000000, "Albastru", 2025, Pilot3, 20);
        AvioaneBoeing Lmao14 = new AvioaneBoeing("Lmao14", 100000000, "Albastru", 2024, Pilot4, 20);

        racheteApolo lmao21 = new racheteApolo("Lmao21", "Negru", 250000000, 2020, 5);
        racheteApolo lmao22 = new racheteApolo("Lmao22", "Violet", 250000000, 2021, 10);
        racheteApolo lmao23 = new racheteApolo("Lmao23", "Verde", 250000000, 2022, 12);

        Marte.addAeronava(Lmao11);
        Marte.addAeronava(Lmao12);
        Marte.addAeronava(Lmao13);
        Marte.addAeronava(Lmao14);

        Marte.addAeronava(lmao21);
        Marte.addAeronava(lmao22);
        Marte.addAeronava(lmao23);

        Marte.adaugaSosire(LocalDate.of(2025, 12, 25), Lmao11);
        Marte.adaugaPlecare(LocalDate.of(2025, 12, 25), Lmao11);
        Marte.adaugaSosire(LocalDate.of(2025, 1, 6), lmao21);
        Marte.adaugaPlecare(LocalDate.of(2025, 1, 6), lmao21);
        Marte.adaugaPlecare(LocalDate.of(2025, 1, 7), lmao22);
        Marte.adaugaPlecare(LocalDate.of(2025, 1, 8), lmao23);

        Marte.afiseazaSosiriDupaData(LocalDate.of(2025, 1, 6));
        Marte.afiseazaToateAeronavele();
    }
}