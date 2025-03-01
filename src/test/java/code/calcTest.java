package code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class calcTest {


    @Test
    void testSquareRoot() {
        assertEquals(2.0, Math.sqrt(4), 0.0001);
    }

    @Test
    void testFactorial() {

        assertEquals(120, calc.factorial(5));
    }


    @Test
    void testNaturalLogarithm() {
        assertEquals(0.0, Math.log(1), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(16.0, Math.pow(4, 2), 0.0001);

    }
}