public class AvioaneBoeing extends Aeronava{
    Pilot pilot;
    int nrPasageri;

    AvioaneBoeing(String nume, int numarMaxKm, String culoare, int anulFabricatiei, Pilot pilot, int nrPasageri) {
        super(nume, numarMaxKm, culoare, anulFabricatiei);
        this.pilot = pilot;
        this.nrPasageri = nrPasageri;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public void setNrPasageri(int nrPasageri) {
        this.nrPasageri = nrPasageri;
    }

    public int getNrPasageri() {
        return nrPasageri;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public String toString() {
        return "Avion " + super.toString();
    }
}
