//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FacebookAccount Matei = new FacebookAccount("Matei",
                20,
                "Cluj-Napoca, Romania");
        FacebookAccount Andrei = new FacebookAccount("Andrei",
                20,
                "Bucuresti, Romania");
        FacebookAccount Tudor = new FacebookAccount("Tudor",
                20,
                "Bucuresti, Romania");

        Matei.adaugaPrieten(Andrei);
        Matei.adaugaPrieten(Tudor);

        Matei.afisListaDePrieteni();

        Matei.stergePrieten(Tudor);

        Matei.afisListaDePrieteni();
    }
}