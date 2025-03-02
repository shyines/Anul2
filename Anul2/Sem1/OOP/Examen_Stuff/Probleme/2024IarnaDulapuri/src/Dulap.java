public class Dulap {
    private int coloane;
    private int randuri;

    Obiect [][] dulap;

    Dulap (int coloane, int randuri) {
        this.coloane = coloane;
        this.randuri = randuri;
        dulap = new Obiect[randuri][coloane];
    }

    public int getColoane () {
        return coloane;
    }
    public int getRanduri () {
        return randuri;
    }

    public void addObiect (Obiect obiect, int rand, int coloana) throws NoSpace {
        if(dulap[rand][coloana] == null) {
            dulap[rand][coloana] = obiect;
        }else {
            throw new NoSpace("Deja exista un obiect");
        }
    }

    public int getObiectNum (int greutate) {
        int contor = 0;
        for(int i = 0;i < randuri;i++) {
            for(int j = 0;j < coloane;j++) {
                if(dulap[i][j] instanceof Colet) {
                    if(((Colet) dulap[i][j]).getGreutate() == greutate) {
                        contor++;
                    }
                }
            }
        }
        return contor;
    }

    public void showObjects () {
        for(int i = 0;i < randuri;i++) {
            for(int j = 0;j < coloane;j++) {
                if(dulap[i][j] instanceof Colet) {
                    System.out.println(((Colet) dulap[i][j]).toString()
                            + "\n randul: " + i
                            + "\n coloana: " + j);
                }
            }
        }
    }
}
