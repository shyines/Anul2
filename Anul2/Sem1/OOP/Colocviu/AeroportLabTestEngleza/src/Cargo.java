import java.util.ArrayList;

public class Cargo extends Compartment implements Cariable  {
    final private int profit;
    final private String name;
    ArrayList<Cariable>cariables;

    Cargo(String UUID, int profit, String name) {
        super(UUID);
        this.profit = profit;
        this.name = name;
    }

    @Override
    public void addCariable(Cariable cariable) {
        this.cariables.add(cariable);
    }

    @Override
    public int computeProfit() {
        return this.profit * cariables.size();
    }
}

