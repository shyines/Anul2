import javax.lang.model.type.ArrayType;
import java.time.LocalDate;
import java.util.*;

public class CentrulSpatial {
    private Map<LocalDate, ArrayList<Aeronava>>sosiriAeronave;
    private Map<LocalDate, ArrayList<Aeronava>> plecariAeronave;
    private ArrayList<Aeronava> toateAeronavele;


    CentrulSpatial () {
        toateAeronavele = new ArrayList<Aeronava>();
        plecariAeronave = new TreeMap<>();
        sosiriAeronave = new TreeMap<>();
    }

    void addAeronava(Aeronava aeronava) {
        toateAeronavele.add(aeronava);
    }

    public void adaugaSosire(LocalDate date, Aeronava aeronava) {
        if(!sosiriAeronave.containsKey(date)) {
            sosiriAeronave.put(date, new ArrayList<>());
            sosiriAeronave.get(date).add(aeronava);
        }
        else {
            sosiriAeronave.get(date).add(aeronava);
        }
    }

    public void adaugaPlecare(LocalDate date, Aeronava aeronava) {
        if(!plecariAeronave.containsKey(date)) {
            plecariAeronave.put(date, new ArrayList<>());
            plecariAeronave.get(date).add(aeronava);
        }
        else {
            plecariAeronave.get(date).add(aeronava);
        }
    }

    public void afiseazaSosiriData(LocalDate date) {
        if(!sosiriAeronave.containsKey(date)) {
            System.out.println("Nu exista data");
        } else {
            for(Aeronava a: sosiriAeronave.get(date)) {
                System.out.println(a);
            }
        }
    }

    public void afiseazaSosiriDupaData(LocalDate date) {
        for(Map.Entry<LocalDate, ArrayList<Aeronava>> entry: plecariAeronave.entrySet()) {
            if(entry.getKey().isAfter(date)) {
                for(Aeronava aeronava: entry.getValue()) {
                    if(aeronava instanceof racheteApolo) {
                        System.out.println(aeronava);
                    }
                }
            }
        }
    }

    public void afiseazaToateAeronavele() {
        System.out.println("Amestec aeronavele");
        System.out.println("Aeronavele amestecate: ");
        Collections.shuffle(toateAeronavele);
        for(Aeronava aeronava: toateAeronavele) {
            System.out.println(aeronava + " ");
        }

        System.out.println("Sortez aeronavele alfabetic");
        Collections.sort(toateAeronavele);
        System.out.println("Aeronavele sortate: ");
        for(Aeronava aeronava: toateAeronavele) {
            System.out.println(aeronava + " ");
        }
    }
}
