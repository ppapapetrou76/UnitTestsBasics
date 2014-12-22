package org.skgjug.dec14;

import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int HUNDRED = 100;
    private static final int FIFTY = 50;
    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {HUNDRED, ONE, HUNDRED}, {HUNDRED, HUNDRED, ONE}, {HUNDRED, TWO, FIFTY}, {HUNDRED, 4, 25}, 
        });
    }

    @Parameter
    public double divisable;

    @Parameter(value = 1)
    public double divisor;

    @Parameter(value = 2)
    public double expectedResult;

    @Test
    public void should_divide_by_random() {
        double result = calculator.divide(divisable, divisor);
        Assert.assertEquals(expectedResult, result);
    }

}
