public class BauturaRacoritoare extends Preparate{
    private int Pret = 10;
    BauturaRacoritoare(String eticheta) {
        super(eticheta);
    }

    @Override
    public String getName() {
        return super.eticheta + " bautura racoritoare";
    }
}
