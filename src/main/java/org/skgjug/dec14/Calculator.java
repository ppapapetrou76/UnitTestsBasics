package org.skgjug.dec14;

public class Calculator {

    public double divide(double divisable, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor can not be 0");
        }
        return divisable / divisor;
    }

    public int powerOf(int number, int power) {
        if (number < 0) {
            throw new ArithmeticException("Negative numbers are not supported");
        }
        switch (number) {
            case 0:
                if (power > 0) {
                    return 0;
                } else if (power < 0) {
                    throw new ArithmeticException("Undefined");
                } else {
                    return 1;
                }
            case 1:
                return number;
            default:
                int powerSum = number;
                for (int i = 0; i < power; i++) {
                    powerSum = powerSum * power;
                }
                return powerSum;
        }
    }
}
