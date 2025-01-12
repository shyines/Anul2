public class Pilot {
    private String nume;
    private String prenume;
    private int varsta;
    private String grad;

    Pilot (String nume, String prenume, int varsta, String grad) {
        this.grad = grad;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public String getGrad() {
        return this.grad;
    }

    public void setGrad (String grad) {
        this.grad = grad;
    }

    public String getNumeComplet () {
        return this.nume + " " + this.prenume;
    }

    public void setVarsta (int varsta) {
        this.varsta = varsta;
    }

    public int getVarsta () {
        return this.varsta;
    }
}

