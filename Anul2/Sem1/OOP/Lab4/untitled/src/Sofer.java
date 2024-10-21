public class Sofer {
    private String name;
    private int age;
    private int driverId;

    public Sofer(String name, int age, int driverId) {
        this.name = name;
        this.age = age;
        this.driverId = driverId;
    }

    public Sofer() {
        this("Popescu", -1, -1);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
