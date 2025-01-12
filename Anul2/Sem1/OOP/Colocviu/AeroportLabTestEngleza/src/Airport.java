import java.util.*;

public class Airport {
    private Set<Plane>planes;
    private Set<Plane>planesInAirport;
    private Set<Plane>planesNotInAirport;

    Airport() {
        planes = new HashSet<>();
        planesInAirport = new HashSet<>();
        planesNotInAirport = new HashSet<>();
    }

    public void addPlane(Plane plane) {
        if(!planes.contains(plane)) {
            this.planes.add(plane);
            this.planesInAirport.add(plane);
        }
    }

    public void departPlane(Plane plane) {
        if(planes.contains(plane) && planesInAirport.contains(plane)) {
            planesInAirport.remove(plane);
            planesNotInAirport.add(plane);
        }
        else {
            System.out.println("Error, plane can not depart");
        }
    }

    public void landPlane(Plane plane) {
        if(planes.contains(plane) && planesNotInAirport.contains(plane)) {
            planesInAirport.add(plane);
            planesNotInAirport.remove(plane);
        }
        else {
            System.out.println("Error");
        }
    }

    public void showPlanesInOrder() {
        List<Plane> sortedPlanes = new ArrayList<>(planesInAirport);

        Collections.sort(sortedPlanes);

        for (Plane it: sortedPlanes) {
            System.out.println(it.toString());
        }
    }
}
