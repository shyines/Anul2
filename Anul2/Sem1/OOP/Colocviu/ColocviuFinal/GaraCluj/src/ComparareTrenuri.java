import java.util.Comparator;

public class ComparareTrenuri implements Comparator<Tren> {

    @Override
    public int compare(Tren o1, Tren o2) {
        if(o1.getVitezaMaxima() > o2.getVitezaMaxima())
            return 1;
        else if (o1.getVitezaMaxima() < o2.getVitezaMaxima())
            return -1;

        return 0;
    }
}
