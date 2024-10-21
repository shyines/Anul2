import java.awt.*;

public class Autovehicul {
    ///variabile
    private String marca;
    private Color color;
    private int viteza;
    private int treaptaViteza;
    private int vitezaMaxima;
    private static final int NR_TREPTE = 6;


    public Autovehicul (String marca, Color color, int viteza, int treaptaViteza,
                        int vitezaMaxima) {
        this.marca = marca;
        this.color = color;
        this.viteza = viteza;
        this.treaptaViteza = treaptaViteza;
        this.vitezaMaxima = vitezaMaxima;
    }

    public Autovehicul () {
        this("Logan", Color.white, 0, 0, 200);
    }

    public String getMarca() {
        return marca;
    }

    public Color getColor() {
        return color;
    }

    public int getViteza() {
        return viteza;
    }

    public int getTreaptaViteza() {
        return treaptaViteza;
    }

    public int getVitezaMaxima() {
        return vitezaMaxima;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setViteza(int viteza) {
        this.viteza = viteza;
    }

    public void setTreaptaViteza(int treaptaViteza) {
        this.treaptaViteza = treaptaViteza;
    }

    public void setVitezaMaxima(int vitezaMaxima) {
        this.vitezaMaxima = vitezaMaxima;
    }


    public String toString() {
        return "Autovehiculul " + this.marca + " cu culoarea "
                + this.color + ", viteza curenta " + this.viteza + ", treapta curenta "
                + this.treaptaViteza + ", viteza maxima " + this.vitezaMaxima
                + ", trepte maxime " + NR_TREPTE + "\n";
    }

    public void accel() {
        if(this.viteza < this.vitezaMaxima) {
            this.viteza += 20;
        }
        if(this.viteza < NR_TREPTE) {
            this.treaptaViteza++;
        }
    }

    public void decelerate() {
        if(this.viteza > 0) {
            this.viteza -= 20;
        }
        if(this.treaptaViteza > 0) {
            this.treaptaViteza--;
        }
    }

    public void oprire () {
        this.viteza = 0;
        this.treaptaViteza = 0;
    }


}
