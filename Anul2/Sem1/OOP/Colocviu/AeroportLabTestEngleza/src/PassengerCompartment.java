import java.util.ArrayList;

public class PassengerCompartment extends Compartment{
    private final int maxNumOfPassengers = 100;
    ArrayList<Cariable>passengers;

    PassengerCompartment(String UUID) {
        super(UUID);
        passengers = new ArrayList<>();
    }

    @Override
    public void addCariable(Cariable passenger) {
        if(this.passengers.size() < 100) {
            this.passengers.add(passenger);
        }else {
            System.out.println("Nu se mai pot urca pasageri in avion, este plin!");
        }
    }

    @Override
    public int computeProfit() {
        return 100 * passengers.size();
    }
}
