package dataModel;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    int idEmployee;

    public Employee(String name, int idEmployee) {
        this.name = name;
        this.idEmployee = idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "ID: " + idEmployee + " Name: " + name;
    }
}
