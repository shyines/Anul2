public class Restaurant extends Preparate{

    private int nrPreparate;
    private Preparate [] arr;
    private int index;

    public String getName() {
        return "implementez asta sa mearga afisarea lmao";
    }

    Restaurant(int nrTipuriPreparate) {
        index = 0;
        arr = new Preparate[nrTipuriPreparate];
    }

    public void addDesert(String eticheta) {
        if(index > arr.length) {
            System.out.println("nu se mai pot adauga preparate");
            return;
        }

        arr[index] = new Desert(eticheta);
        index++;
    }

    public void addPizza (String eticheta) {
        if(index > arr.length) {
            System.out.println("nu se mai pot adauga preparate");
            return;
        }

        arr[index] = new Pizza(eticheta);
        index++;
    }

    public void addBauturaRacoritoare(String eticheta) {
        if(index > arr.length) {
            System.out.println("nu se mai pot adauga preparate");
            return;
        }

        arr[index] = new BauturaRacoritoare(eticheta);
        index++;
    }

    public void arataPreparatele() {
        for(Preparate p: arr) {
            System.out.println(p.getName());
        }
    }
}