import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Plane implements Comparable<Plane>{
    String name;
    LinkedHashSet<Compartment>compartments;

    Plane(String name) {
        this.name = name;
        compartments = new LinkedHashSet<>();
    }

    public int getNumOfCompartments() {
        return compartments.size();
    }

    public String getPlaneName() {
        return this.name;
    }

    public int getProfit() {
        int profit = 0;
        for(Compartment it: compartments) {
            profit += it.computeProfit();
        }

        return profit;
    }

    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Plane plane = (Plane) obj;
        return this.name.equals(plane.name);
    }

    @Override
    public int compareTo(Plane other) {
        return this.name.compareTo(other.name); // Compare planes by name
    }

    @Override
    public String toString() {
        return this.name + " with num of compartments " + this.compartments.size();
    }
}
