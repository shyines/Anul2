public class Main {
    public static void main(String[] args) {
        GradinaZoo gradinaZoo = new GradinaZoo();

        Leu leul1 = new Leu("Lion2342", 2010, 250);
        Caine caine1 = new Caine("Dog6531", 2014, "Fox Terrier");
        Pisica pisica1 = new Pisica("Cat7889", 2013, "Alb");

        gradinaZoo.adaugaAnimal(leul1);
        gradinaZoo.adaugaAnimal(caine1);
        gradinaZoo.adaugaAnimal(pisica1);

        gradinaZoo.arataAnimalele();

        try {
            leul1.mancareZilnica();
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            pisica1.mancareZilnica();
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            caine1.mancareZilnica();
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            leul1.manancaMancare(1.0d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            caine1.primesteMancareDeLaCopil(0.1d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            caine1.manancaMancare(0.3d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            pisica1.primesteMancareDeLaCopil(0.05d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            leul1.mancareZilnica();
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            caine1.manancaMancare(0.8d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            caine1.primesteMancareDeLaCopil(0.1d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            leul1.manancaMancare(1.1d);
        } catch (MancareException e) {
            System.out.println("Error: " + e.getMessage());
        }

        gradinaZoo.arataAnimalele();
    }
}