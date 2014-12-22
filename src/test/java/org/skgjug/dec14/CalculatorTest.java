
package org.skgjug.dec14;

import junit.framework.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int HUNDRED = 100;
    private static final int FIFTY = 50;
    private Calculator calculator;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init(){
        calculator = new Calculator();
    }
    
    @Test(expected = ArithmeticException.class)
    public void divide_by_zero_should_throw_exception(){
        calculator.divide(HUNDRED, ZERO);
    }
    
    @Test
    public void should_divide_by_one(){
        double expectedReult = HUNDRED;
        double result = calculator.divide(HUNDRED, ONE);
        
        Assert.assertEquals (expectedReult, result);
    }
    
    @Test
    public void should_divide_by_same(){
        double expectedReult = ONE;
        double result = calculator.divide(HUNDRED, HUNDRED);
        
        Assert.assertEquals (expectedReult, result);
    }

    @Test
    public void should_divide_by_random(){
        double expectedReult = FIFTY;
        double result = calculator.divide(HUNDRED, TWO);
        
        Assert.assertEquals (expectedReult, result);
    }

    @Test
    public void positive_power_of_zero_should_be_zero() {
        int result = calculator.powerOf(ZERO, ONE);
        int expectedResult = ZERO;
        Assert.assertEquals("Positive power of zero should be zero!", expectedResult, result);
    }
    
    @Test
    public void divide_by_zero_should_throw_exception_junit_rule(){
        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("Divisor can not be 0");
        
        calculator.divide(HUNDRED, ZERO);
    }

    
    @Test
    public void divide_by_zero_should_throw_exception_assertJ(){
        try {
            calculator.divide(HUNDRED, ZERO);
            failBecauseExceptionWasNotThrown(ArithmeticException.class);
        } catch ( ArithmeticException ex){
            assertThat(ex).hasMessage("Divisor can not be 0");
        }
    }
    


}
