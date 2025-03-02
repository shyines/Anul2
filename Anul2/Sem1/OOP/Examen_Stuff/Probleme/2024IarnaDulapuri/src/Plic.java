public class Plic extends Obiect{
    private String format;

    public Plic(String numeExpeditor, String numeDestinatar, int valoareaAchitata, String format){
        super(numeExpeditor, numeDestinatar, valoareaAchitata);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String toString(){
        return super.getValoareaAchitata() + " "
                + super.getNumeDestinatar() + " "
                + super.getNumeExpeditor() + " "
                + "\n Format: " + this.format;
    }
}
