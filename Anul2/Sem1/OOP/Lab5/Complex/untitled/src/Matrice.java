import java.util.Random;

public class Matrice {
    private Complex[][] matrix;

    public Matrice (int nrLinii, int nrColoane) {
        this.matrix = new Complex[nrLinii][nrColoane];
        for(int i = 0;i < nrLinii; i++) {
            for(int j = 0;j < nrColoane; j++) {
                this.matrix[i][j] = new Complex (new Random().nextInt(10),
                                                 new Random().nextInt(10));
            }
        }
    }

    public void afisMatrice() {
        for(int i = 0;i < this.matrix.length; i++) {
            for(int j = 0;j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Complex getComplex (int i, int j) {
        return this.matrix[i][j];
    }

    public void adunareMatrice(Matrice matrice) {
        for(int i = 0;i < this.matrix.length; i++) {
            for(int j = 0;j < this.matrix[i].length; j++) {
                this.matrix[i][j].adunare(matrice.matrix[i][j]);
            }
        }
    }

    public void scadereMatrice(Matrice matrice) {
        for(int i = 0;i < this.matrix.length; i++) {
            for(int j = 0;j < this.matrix[i].length; j++) {
                this.matrix[i][j].scadere(matrice.matrix[i][j]);
            }
        }
    }

    public void inmultireMatrice(Matrice matrice) {
        Matrice rez = new Matrice(this.matrix.length, this.matrix[0].length);

        for(int i = 0;i < rez.matrix.length; i++) {
            for(int j = 0;j < rez.matrix[i].length; j++) {
                rez.matrix[i][j] = new Complex(0, 0);
            }
        }
    }
}
