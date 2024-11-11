public class Pizza extends Preparate{
    private int pret = 40;

    Pizza(String eticheta) {
        super(eticheta);
    }

    public String getName() {
        return super.eticheta + " Pizza";
    }
}
