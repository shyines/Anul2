public class Lucrator {
    private String nume;
    private CalendarLucru c1;

    public Lucrator(String nume, CalendarLucru c1) {
        this.nume = nume;
        this.c1 = c1;
    }

    public void lucreaza(String zi) throws ExceptieZiNelucratoare {
            Zi ziuaDeLucru = c1.getZi(zi);
            if(ziuaDeLucru.getLucratoare() == true) {
                System.out.println("Lucratorul " + nume + " lucreaza in ziua de " + ziuaDeLucru.getNume());
            }
            else {
                throw new ExceptieZiNelucratoare("Zi nelucratoare " + zi);
            }
    }
}
