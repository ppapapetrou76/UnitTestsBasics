package org.skgjug.dec14;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Defaults.class)
public class EmployeeTest {
    
    private static final double DEFAULT_SALARY = 1100;

    @Before
    public void init(){
        PowerMockito.mockStatic(Defaults.class);
        Mockito.when(Defaults.getEmployeeDefaultSalary()).thenReturn(DEFAULT_SALARY);
    }
    
    @Test
    public void should_create_employee_with_default_salary() {
        Employee newEmployee = new Employee(true, "Al Pacino");
        assertThat(newEmployee.getSalary()).isEqualTo(DEFAULT_SALARY);
        
    }
    
}
