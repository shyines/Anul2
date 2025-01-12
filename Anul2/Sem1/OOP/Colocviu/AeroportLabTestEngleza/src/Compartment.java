import java.util.ArrayList;

public abstract class Compartment {
    private String UUID;

    Compartment(String UUID) {
        this.UUID = UUID;
    }

    public abstract int computeProfit();
    public abstract void addCariable(Cariable cariable);
}
