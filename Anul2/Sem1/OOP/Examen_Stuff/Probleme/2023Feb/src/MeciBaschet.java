import java.util.Date;

public class MeciBaschet extends Meci{
    int [] scoruriE1 = new int [2];
    int [] scoruriE2 = new int [2];

    MeciBaschet(int [] scoruriE1, int [] scoruriE2, Echipa e1, Echipa e2, Date dataMeciului, int scorE1, int scorE2){
        super(e1, e2, dataMeciului, scorE1, scorE2);
        this.scoruriE1 = scoruriE1;
        this.scoruriE2 = scoruriE2;
    }


}
