import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persoana pers1 = new Persoana("A", "C", 20);
        Persoana pers2 = new Persoana("B", "M", 19);
        Persoana pers3 = new Persoana("D", "E", 25);

        Persoana[] persoane = new Persoana[] {pers1, pers2, pers3};
        Arrays.sort(persoane);

        for(Persoana p: persoane) {
            System.out.println(p);
        }

        //Ca si tema problema 3.5 daca apuc

    }
}