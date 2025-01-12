import java.awt.*;

public abstract class Aeronava implements Comparable<Aeronava>{
    private String nume;
    private int numarMaximKm;
    private String culoare;
    private int anulFabricatiei;

    Aeronava(String nume, int numarMaximKm, String culoare, int anulFabricatiei) {
        this.nume = nume;
        this.numarMaximKm = numarMaximKm;
        this.anulFabricatiei = anulFabricatiei;
        this.culoare = culoare;
    }
    /*
    Aeronava() {
        this.nume = "";
        this.numarMaximKm = 0;
        this.culoare = "";
        this.anulFabricatiei = 0;
    }
    */
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNumarMaximKm(int numarMaximKm) {
        this.numarMaximKm = numarMaximKm;
    }

    public int getNumarMaximKm() {
        return numarMaximKm;
    }

    public void setCuloare(String color) {
        this.culoare = color;
    }

    public String getCuloare() {
        return this.culoare;
    }

    public void setAnulFabricatiei(int anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }

    public String toString() {
        return this.nume + " avand anul fabricatiei: " + this.anulFabricatiei + " si culoarea: " + this.culoare + " cu numarul maxim de km " + this.numarMaximKm;
    };

    public int compareTo(Aeronava altaAeronava) {
        return this.nume.compareTo(altaAeronava.nume);
    }
}
