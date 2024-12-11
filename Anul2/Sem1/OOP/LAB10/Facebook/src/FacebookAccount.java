import java.util.ArrayList;

public class FacebookAccount {
    private String nume;
    private int varsta;
    private String locatiaCurenta;
    private ArrayList<FacebookAccount> listDePrieteni;

    public FacebookAccount(String nume, int varsta, String locatiaCurenta) {
        this.nume = nume;
        this.varsta = varsta;
        this.locatiaCurenta = locatiaCurenta;
        listDePrieteni = new ArrayList<>();
    }

    public void adaugaPrieten(FacebookAccount prieten) {
        listDePrieteni.add(prieten);
    }

    public void stergePrieten(FacebookAccount persoana) {
        boolean ok = false;
        for (int i = 0;i < listDePrieteni.size();i++) {
            if(listDePrieteni.get(i).nume.equals(persoana.nume) && listDePrieteni.get(i).varsta == persoana.varsta &&
                    listDePrieteni.get(i).locatiaCurenta.equals(persoana.locatiaCurenta)) {
                ok = true;
                listDePrieteni.remove(listDePrieteni.get(i));
                break;
            }
        }
        if(!ok) {
            System.out.println("Nu exista prietenul!");
        }
    }

    public String toString() {
        return this.nume + " cu varsta " + this.varsta + " aflat in locatia " + this.locatiaCurenta;
    }

    void afisListaDePrieteni() {
        for(FacebookAccount prieten : listDePrieteni) {
            System.out.println(prieten);
        }
    }
}
