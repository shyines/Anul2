public class Persoana implements Comparable {
    private String name;
    private String prenume;
    private int varsta;

    public Persoana(String name, String prenume, int varsta) {
        this.name = name;
        this.prenume = prenume;
        this.varsta = varsta;
    }

    public int compareTo(Object a) {
        Persoana newPers = (Persoana) a;
        return this.varsta - newPers.varsta;
    }


    public String toString() {
        return "Persoana " + name + " " + prenume + " " + varsta;
    }
}
