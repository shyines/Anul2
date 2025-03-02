public class Obiect {
    protected String numeExpeditor;
    protected String numeDestinatar;
    protected int valoareaAchitata;

    public Obiect(String numeExpeditor, String numeDestinatar, int valoareaAchitata) {
        this.numeExpeditor = numeExpeditor;
        this.numeDestinatar = numeDestinatar;
        this.valoareaAchitata = valoareaAchitata;
    }

    public int getValoareaAchitata() {
        return valoareaAchitata;
    }

    public void setValoareaAchitata(int valoareaAchitata) {
        this.valoareaAchitata = valoareaAchitata;
    }

    public String getNumeExpeditor() {
        return numeExpeditor;
    }

    public void setNumeExpeditor(String numeExpeditor) {
        this.numeExpeditor = numeExpeditor;
    }

    public String getNumeDestinatar() {
        return numeDestinatar;
    }

    public void setNumeDestinatar(String numeDestinatar) {
        this.numeDestinatar = numeDestinatar;
    }
}
