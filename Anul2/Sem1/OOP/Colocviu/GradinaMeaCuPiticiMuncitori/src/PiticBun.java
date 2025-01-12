public class PiticBun extends PiticMuncitor{

    public PiticBun(double inaltime, String nume) {
        super(inaltime, nume);
    }

    public PiticBun() {
        super();
        super.inaltime = 0.75;
        super.nume = "Pitic bun" + instanceNum;
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

    @Override
    public double calculeazaVenitTotal() {
        return this.calculeazaBonus() + this.calculeazaVenit();
    }
}
