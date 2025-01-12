import java.time.LocalDate;

public abstract class Animal {
    private String ID;
    private int dataDeNastere;
    private boolean hranaLaDispozitie = false;

    Animal(String ID, int dataDeNastere) {
        this.dataDeNastere = dataDeNastere;
        this.ID = ID;
    }

    public abstract void mancareZilnica() throws MancareException;
    public abstract void manancaMancare(double mancare) throws MancareException;
    public String getID() {
        return ID;
    }

    public int getDataDeNastere() {
        return dataDeNastere;
    }
}
