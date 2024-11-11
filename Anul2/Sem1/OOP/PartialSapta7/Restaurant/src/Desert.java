public class Desert extends Preparate{
    private int pret = 20;

    Desert(String eticheta) {
        super(eticheta);
    }

    public String getName() {
        return super.eticheta + " Desert";
    }
}
