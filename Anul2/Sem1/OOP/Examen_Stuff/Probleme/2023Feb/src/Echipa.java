import java.util.Scanner;

public class Echipa implements Comparable<Echipa>{
    private String nume;
    private int anulInfintarii;

    Echipa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numele echipei");
        this.nume = sc.nextLine();
        System.out.println("Introduce anul infintarii echipei");
        this.anulInfintarii = sc.nextInt();
    }

    int getAnulInfintarii() {
        return anulInfintarii;
    }

    String getNume() {
        return nume;
    }

    public void setAnulInfintarii(int anulInfintarii) {
        this.anulInfintarii = anulInfintarii;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public int compareTo(Echipa o) {
        return this.nume.compareTo(o.getNume());
    }

    @Override
    public String toString() {
        return nume + " " + anulInfintarii;
    }
}
