//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            CalendarLucru c1 = new CalendarLucru();
            Lucrator l1 = new Lucrator("Gigel", c1);

            l1.lucreaza("Luni");
            l1.lucreaza("Sambata");
        }catch(ExceptieZiNelucratoare e) {
            System.out.println(e.getMessage());
        }

        try {
            Zi ziuaTest = null;
            ziuaTest.getNume();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Zi[]ziuaTest2 = new Zi[5];


        try {
            System.out.println(ziuaTest2[100].getNume());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new Exception("EL presedinte");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Merge obligatoriu");
        }
    }
}