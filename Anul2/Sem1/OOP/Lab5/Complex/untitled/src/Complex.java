public class Complex {
    private int real;
    private int imaginar;

    public Complex () {
        this.real = 0;
        this.imaginar = 0;
    }

    public Complex (int real, int imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }

    public String toString() {
        if(imaginar < 0) {
            String s = real + "-" + (-1) * imaginar + "i";
            return s;
        }
        String s = real + "+" + imaginar + "i";
        return s;
    }

    public void adunare (Complex a) {
        this.real += a.real;
        this.imaginar += a.imaginar;
    }

    public void scadere (Complex a) {
        this.real -= a.real;
        this.imaginar -= a.imaginar;
    }

    public void inmultireCuScalar (int a) {
        this.real *= a;
        this.imaginar *= a;
    }

    public void inmultire (Complex a) {
        this.real = (this.real * a.real) + this.imaginar * (-1) * a.imaginar;
        this.imaginar = this.real * a.imaginar + this.imaginar * a.real;
    }
}
