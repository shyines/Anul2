import java.math.BigDecimal;
import java.util.Scanner;
import java.math.BigDecimal;

public class Vocala {

    private String expresie;

    public Vocala(String expresie) {
        this.expresie = expresie;
    }

    public int getNumarVocale(String expresie) {
        int nr = 0;
        for(int i = 0;i < this.expresie.length(); i++) {
              if(expresie.charAt(i) == 'a' ||
                 expresie.charAt(i) == 'e' ||
                 expresie.charAt(i) == 'i' ||
                 expresie.charAt(i) == 'o' ||
                 expresie.charAt(i) == 'u'
                ) {
                  nr++;
              }
        }
        return nr;
    }

    public int getVocalPos(String expresie, char c) {
        for(int i = 0;i < expresie.length(); i++) {
            if(expresie.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Loto L;


        String contineVocale = "abc edf io";
        char c = 'i';
        Scanner in = new Scanner(System.in);

        Vocala vocala = new Vocala(contineVocale);
        System.out.println("Numarul de vocale este " + vocala.getNumarVocale(contineVocale));
        System.out.println("Vocala " + c + " se afla la pos " + vocala.getVocalPos(contineVocale, c));

        System.out.println(L.calculateCombinations(5, 5));
    }
}
