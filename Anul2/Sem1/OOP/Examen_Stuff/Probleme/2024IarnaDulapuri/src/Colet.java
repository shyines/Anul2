public class Colet extends Obiect{
    int lungime;
    int inaltime;
    int latime;
    int greutate;

    public Colet(String numeExpeditor, String numeDestinatar, int valoareaAchitata, int latime, int lungime, int inaltime, int greutate){
        super(numeExpeditor, numeDestinatar, valoareaAchitata);
        this.latime = latime;
        this.lungime = lungime;
        this.inaltime = inaltime;
        this.greutate = greutate;
    }

    public int getInaltime() {
        return inaltime;
    }
    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getLungime() {
        return lungime;
    }
    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public int getLatime() {
        return latime;
    }
    public void setLatime(int latime) {
        this.latime = latime;
    }

    public int getGreutate() {
        return greutate;
    }
    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public String toString(){
        return super.getValoareaAchitata() + " "
                + super.getNumeDestinatar() + " "
                + super.getNumeExpeditor() + " "
                + "\n Greutate: " + greutate
                + "\n Lungime: " + lungime
                + "\n Inaltime: " + inaltime
                + "\n Latime: " + latime;
    }
}
