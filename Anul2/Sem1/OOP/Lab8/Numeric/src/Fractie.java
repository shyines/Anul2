public class Fractie implements Numeric{
    double num;

    public Fractie(double num) {
        this.num = num;
    }

    public Numeric adunare (Numeric a) {

        if(a instanceof Fractie) {
            Fractie result = new Fractie(0);
            result.num = ((Fractie)a).num + this.num;
            return result;
        }
        else {
            Complex result = new Complex(0, 0);
            result.real = this.num + ((Complex)a).real;
            return result;
        }
    }

    public String toString() {
        return "Fractia este " + num;
    }
}
