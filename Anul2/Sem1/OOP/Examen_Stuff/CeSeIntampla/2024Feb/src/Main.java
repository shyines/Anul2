//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements A{
    @Override
    public int method() throws Exception {
        return 10;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        try {
            System.out.println(obj.method());
        }catch (Throwable e) {};
    }
}