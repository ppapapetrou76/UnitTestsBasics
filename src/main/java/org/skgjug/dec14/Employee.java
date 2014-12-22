
package org.skgjug.dec14;

public class Employee {

    private boolean active;
    private String name;
    private double salary;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(boolean active, String name) {
        this(active, name, Defaults.getEmployeeDefaultSalary());
    }

    public Employee(boolean active, String name, double salary) {
        this.active = active;
        this.name = name;
        this.salary = salary;
    }
    
}
