public class Echipament {
    private String nume;
    private double bonus;

    Echipament(String nume, double bonus) {
        this.bonus = bonus;
        this.nume = nume;
    }

    public double getBonus() {
        return bonus;
    }

    public String getNume() {
        return nume;
    }
}
