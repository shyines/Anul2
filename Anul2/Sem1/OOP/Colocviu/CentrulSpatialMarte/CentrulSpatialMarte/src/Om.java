public class Om implements Angajat{
    String nume;
    private boolean lucreaza;
    private boolean mananca;
    private boolean doarme;
    private boolean facePauza;


    Om(String nume) {
        this.nume = nume;
    }

    public String lucreaza() {
        lucreaza = true;
        mananca = false;
        doarme = false;
        facePauza = false;
        return this.nume + " lucreaza";
    }

    public String mananca() {
        lucreaza = false;
        mananca = true;
        doarme = false;
        facePauza = false;
        return this.nume + " mananca";
    }

    public String doarme() {
        lucreaza = false;
        mananca = false;
        doarme = true;
        facePauza = false;
        return this.nume + " doarme";
    }

    public String facePauza() {
        lucreaza = false;
        mananca = false;
        doarme = false;
        facePauza = true;
        return this.nume + " face pauza";
    }

    public String getNume() {
        return this.nume;
    }
}
