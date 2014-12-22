
package org.skgjug.dec14;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao;
    
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    public List<Employee> getAll(){
        return employeeDao.getAll();
    }
}
