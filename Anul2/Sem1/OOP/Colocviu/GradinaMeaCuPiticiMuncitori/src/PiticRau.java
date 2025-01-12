public class PiticRau extends PiticMuncitor{
    PiticRau(double inaltime, String nume) {
        super(inaltime, nume);
    }

    PiticRau() {
        super();
        super.nume = "Pitic rau" + instanceNum;
    }

    @Override
    public double calculeazaBonus() {
        double bonus = 0;
        if(this.aptDeMunca()) {
            for(Echipament it: this.getEchipamente()) {
                bonus += it.getBonus() * this.getInaltime();
            }

            return bonus * 2;
        }

        return 0;
    }

    public double calculeazaVenitTotal() {
        return this.calculeazaBonus() + this.calculeazaVenit();
    }
}
