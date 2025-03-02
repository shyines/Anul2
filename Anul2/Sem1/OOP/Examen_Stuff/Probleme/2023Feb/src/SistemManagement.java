import java.util.*;

public class SistemManagement {
    private TreeSet<Echipa> echipe;
    private ArrayList<Meci> meciuri;

    HashMap<Echipa, Integer> scoruri;

    void addEchipa(Echipa e) {
        echipe.add(e);
    }

    void addMeci(Meci m) {
        meciuri.add(m);
    }


    public SistemManagement() {
        echipe = new TreeSet<>();
        meciuri = new ArrayList<>();
        scoruri = new HashMap<>();

    }

    void showMatches() {
        Collections.sort(meciuri);

    }

    void showEchipe() {
        for(Echipa e : echipe) {
            System.out.println(e);
        }
    }
}
