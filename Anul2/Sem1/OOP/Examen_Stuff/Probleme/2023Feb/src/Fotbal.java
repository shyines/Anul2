import java.util.Date;

public class Fotbal extends Meci{
    private int scorPauzaE1;
    private int scorPauzaE2;

    Fotbal(Echipa e1, Echipa e2, Date dataMeciului, int scorE1, int scorE2) {
        super(e1, e2, dataMeciului, scorE1, scorE2);
        this.scorPauzaE1 = scorE1;
        this.scorPauzaE2 = scorE2;
    }

    public void setScorPauzaE1(int scorPauzaE1) {
        this.scorPauzaE1 = scorPauzaE1;
    }

    public void setScorPauzaE2(int scorPauzaE2) {
        this.scorPauzaE2 = scorPauzaE2;
    }

    public int getScorPauzaE1() {
        return scorPauzaE1;
    }

    public int getScorPauzaE2() {
        return scorPauzaE2;
    }
}
