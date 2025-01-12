import java.util.ArrayList;

public class racheteApolo extends Aeronava{
    private int nrPlanete;
    private ArrayList<String>planeteDestinatie;

    racheteApolo(String nume, String culoare, int numarMaximKm, int anulFabricatiei, int nrPlanete) {
        super(nume, numarMaximKm, culoare, anulFabricatiei);
        this.nrPlanete = nrPlanete;
    }

    void addPlaneta(String planeta) {
        if(planeteDestinatie.size() < nrPlanete) {
            planeteDestinatie.add(planeta);
        }else {
            return;
        }
    }

    public void setNrPlanete(int nrPlanete) {
        this.nrPlanete = nrPlanete;
    }

    public int getNrPlanete() {
        return this.nrPlanete;
    }

    public String toString() {
        return "Racheta " + super.toString();
    }
}
