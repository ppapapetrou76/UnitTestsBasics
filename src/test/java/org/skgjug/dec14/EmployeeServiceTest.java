package org.skgjug.dec14;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest {

    private final List<Employee> allEmployees = new ArrayList<>();
    private EmployeeService employeeService;
    private EmployeeDao employeeDao;

    @Before
    public void init() {
        employeeDao = new EmployeeDaoTestable();    
    }

    @Test
    public void should_get_all_employees() {
        employeeService = new EmployeeService(employeeDao);
        
        assertThat(employeeService.getAll()).
                isEqualTo(allEmployees);
    }

    @Test
    public void should_get_all_employees_using_mocks() {
        
        employeeDao = Mockito.mock(EmployeeDao.class);
        Mockito.when(employeeDao.getAll()).
                thenReturn(allEmployees);

        employeeService = new EmployeeService(employeeDao);
        assertThat(employeeService.getAll()).
                isEqualTo(allEmployees);
    }

    @Test
    public void get_all_employees_should_invoke_dao_get_all_method() {
        
        employeeDao = Mockito.mock(EmployeeDao.class);
        Mockito.when(employeeDao.getAll()).thenReturn(allEmployees);

        employeeService = new EmployeeService(employeeDao);
        employeeService.getAll();
        Mockito.verify(employeeDao, Mockito.times(1)).getAll();
    }

    class EmployeeDaoTestable extends EmployeeDao {

        public EmployeeDaoTestable() {
        }

        @Override
        public List<Employee> getAll() {
            return allEmployees;
        }

    }

}
