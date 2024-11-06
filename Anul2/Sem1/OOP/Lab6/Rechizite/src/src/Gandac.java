public class Gandac extends Insecta{
    private int k = printInit("Gindac.k initializat");
    public Gandac()
    {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("static Gindac.x2 initializat");
    public static void main(String[] args)
    {
        System.out.println("Gindac constructor");
        Gandac b = new Gandac();
    }

}
