
package org.skgjug.dec14;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

public class EmployeeDaoTest {

    private static EmployeeDao employeeDao;
    private static final int ALL_EMPLOYEES_COUNT = 4;
    private final String MYNAME = "Patroklos Papapetrou";
    private final String NAME_ATTRIBUTE = "name";
    private final List<String> expectedNames = 
            Arrays.asList("Al Pacino", "Bruce Willis", "Robert De Niro", "Jack Norris");
    
    @BeforeClass
    public static void initDao(){
        employeeDao = new EmployeeDao();
    }
    
    @Test
    public void should_get_all_employees() {
        
        List<Employee> expectedEmployees = employeeDao.getAll();
        MatcherAssert.assertThat(expectedEmployees.size(), equalTo(ALL_EMPLOYEES_COUNT));
        
        for ( Employee employee : expectedEmployees){
            Assert.assertTrue(expectedNames.contains(employee.getName()));
        }

        Assert.assertFalse(expectedNames.contains(MYNAME));
    }
    
    @Test
    public void should_get_all_employees_assertj() {
        
        List<Employee> expectedEmployees = employeeDao.getAll();
        
        Assertions.assertThat(expectedEmployees).
                hasSize(4).
                extracting(NAME_ATTRIBUTE).
                containsAll(expectedNames).
                doesNotContain(MYNAME);
    }
    
}
