public class Rezervor {
    private int capacitateMaxima;
    private int nivelCurent;

    public Rezervor(int capacitateMaxima, int nivelCurent) {
        this.capacitateMaxima = capacitateMaxima;
        this.nivelCurent = nivelCurent;
    }
    public Rezervor() {
        this(0, 0);
    }

    public int GetCapacitateMaxima() {
        return capacitateMaxima;
    }
    public int GetNivelCurent() {
        return nivelCurent;
    }
    public void SetCapacitateMaxima(int capacitateMaxima) {
        this.capacitateMaxima = capacitateMaxima;
    }
    public void SetNivelCurent(int nivelCurent) {
        this.nivelCurent = nivelCurent;
    }

    public void umplere(int cantitate) {
        if(nivelCurent + cantitate < capacitateMaxima) {
            nivelCurent += cantitate;
        }
    }

    public void golire(int cantitate) {
        if(nivelCurent - cantitate > 0) {
            nivelCurent -= cantitate;
        }
    }

    public void umplere(int level, int aditionalLevel) {
        int sum = level + aditionalLevel;
        if(sum < capacitateMaxima && sum >= nivelCurent) {
            nivelCurent = sum;
        } else {
            nivelCurent = capacitateMaxima;
        }
    }
}
