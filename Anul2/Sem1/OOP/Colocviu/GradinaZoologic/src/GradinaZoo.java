import java.util.ArrayList;

public class GradinaZoo {
    ArrayList<Animal>animale;
    static final int numarMaximAnimale = 1000;

    GradinaZoo() {
        animale = new ArrayList<>();
    }

    void adaugaAnimal(Animal animal) {
        if(animale.size() < 1000) {
            animale.add(animal);
        }

    }

    void arataAnimalele() {
        for(Animal it: animale) {
            System.out.println(it.toString());
        }
    }
}
