package org.skgjug.dec14;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private final List<Employee> employees;

    public EmployeeDao() {
        employees = new ArrayList<>();
        employees.add(new Employee(true, "Al Pacino", 10000));
        employees.add(new Employee(false, "Bruce Willis", 20000));
        employees.add(new Employee(true, "Robert De Niro", 20000));
        employees.add(new Employee(true, "Jack Norris", 50000));
    }

    public List<Employee> getAll() {
        return employees;
    }

    public List<Employee> getActiveWithHighSalary() {
        return getEmployeesByChecker(new CheckActiveWithHighSalaryEmployee());
    }

    private List<Employee> getEmployeesByChecker(CheckEmployee checker){
        List<Employee> filteredList = new ArrayList<>();
        for (Employee employee : employees) {
            if (checker.test(employee)) {
                filteredList.add(employee);
            }
        } 
        return filteredList;
    }
    
    private interface CheckEmployee {
        boolean test(Employee employee);
    }

    private class CheckActiveWithHighSalaryEmployee implements CheckEmployee {

        @Override
        public boolean test(Employee employee) {
            return employee.isActive() && employee.getSalary() > 40000;
        }
    }
}
