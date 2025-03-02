import java.sql.Date;
import java.util.Scanner;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SistemManagement SistemulMeciurilor = new SistemManagement();

        Echipa e1 = new Echipa();
        Echipa e2 = new Echipa();
        Echipa e3 = new Echipa();
        Echipa e4 = new Echipa();
        Echipa e5 = new Echipa();

        SistemulMeciurilor.addEchipa(e1);
        SistemulMeciurilor.addEchipa(e2);
        SistemulMeciurilor.addEchipa(e3);
        SistemulMeciurilor.addEchipa(e4);
        SistemulMeciurilor.addEchipa(e5);

        try {
            SistemulMeciurilor.addMeci(new MeciBaschet(new int[] {12,18,30,25}, new int[] {15,15,15,5}, e4, e5, new Date(121, 7, 6), 85, 80);
        } catch (Exception e)
        {
            System.out.println("Exception : " + e);
        }
    }
}