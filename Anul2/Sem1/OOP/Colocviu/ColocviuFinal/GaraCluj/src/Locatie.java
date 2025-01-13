public class Locatie {
    private String nume;
    private int distantaInKm;

    public Locatie(String nume, int distantaInKm) {
        this.nume = nume;
        this.distantaInKm = distantaInKm;
    }

    public int getDistantaInKm() {
        return distantaInKm;
    }

    public String getNume() {
        return nume;
    }

}
