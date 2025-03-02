import java.util.Comparator;
import java.util.Date;

public abstract class Meci implements Comparable<Meci> {
    private Echipa e1;
    private Echipa e2;
    private Date dataMeciului;
    private int scorFinalE1;
    private int scorFinalE2;


    Meci(Echipa e1, Echipa e2, Date dataMeciului, int scorE1, int scorE2) throws Exception{
        this.e1 = e1;
        this.e2 = e2;
        this.dataMeciului = dataMeciului;
        this.scorFinalE1 = scorE1;
        this.scorFinalE2 = scorE2;
    }

    @Override
    public int compareTo(Meci o) {
        return this.dataMeciului.compareTo(o.dataMeciului);
    }
}
