public class Zi {
    private String nume;
    private boolean isLucratoare;

    public Zi(String nume, boolean isLucratoare) {
        this.nume = nume;
        this.isLucratoare = isLucratoare;
    }

    public void setLucratoare(boolean isLucratoare) {
        this.isLucratoare = isLucratoare;
    }

    public boolean getLucratoare() {
        return isLucratoare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
