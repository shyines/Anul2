public class Robot implements Angajat{
    String nume;
    private boolean lucreaza = true;

    Robot(int editie) {
        this.nume = "Lmaolol" + editie;
    }

    public String lucreaza() {
        return this.nume + " lucreaza pana cineva il opreste";
    }

    public String esteOprit() {
        this.lucreaza = false;
        return this.nume + " oprit indefinit";
    }

    public String porneste() {
        this.lucreaza = true;
        return this.nume + " a pornit";
    }
}
