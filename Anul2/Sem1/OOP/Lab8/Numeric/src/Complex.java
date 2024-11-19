public class Complex implements Numeric{
    double imaginar;
    double real;

    public Complex(double imaginar, double real) {
        this.imaginar = imaginar;
        this.real = real;
    }

    @Override
    public Numeric adunare(Numeric a) {
        Complex result = new Complex(0, 0);
        if(a instanceof Complex) {
            Complex c = (Complex)a;
            result.real = c.real + this.real;
            result.imaginar = c.imaginar + this.imaginar;
        }else {
            Fractie f = (Fractie)a;
            result.real = f.num + this.real;
            result.imaginar = this.imaginar;
        }

        return result;
    }
/*
    public Numeric scadere(Numeric a) {

        if(a instanceof Complex) {
            Complex c = (Complex)a;
            this.real -= c.real;
            this.imaginar -= c.imaginar;
        }else {
            Fractie f = (Fractie)a;
            this.real -= f.num;
        }
    }

    public Numeric inmultire(Numeric a) {
        if(a instanceof Complex) {
            Complex c = (Complex)a;
            this.real = this.real * c.real - this.imaginar * c.imaginar;
            this.imaginar = this.real * c.imaginar + c.real * this.imaginar ;
        } else {
            Fractie f = (Fractie)a;
            this.real = this.real * f.num;
        }
    }
    */
    public String toString() {
        if(this.imaginar < 0) {
            return "Numarul complex este " + this.real + " - " + this.imaginar * (-1) + "i";
        }
        return "Numarul complex este " + this.real + " + " + this.imaginar + "i";
    }
}
