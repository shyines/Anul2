public abstract class Preparate {
    protected String eticheta;
    public abstract String getName();

    Preparate(String eticheta) {
        this.eticheta = eticheta;
    }

    Preparate() {
        eticheta = "";
    }
}
