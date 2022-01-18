import Controller.Permissions;
import Model.Operations;
import Model.Polynomial;
import junit.framework.TestCase;

import static junit.framework.Assert.assertEquals;

public class Test extends TestCase{
    Polynomial polynomial1;
    Polynomial polynomial2;
    Polynomial polynomial3;
    Polynomial result;
    Operations operations;

    public void setUp() throws Exception {
        polynomial1 = new Polynomial();
        polynomial1.split("-x^2+2x+3");
        polynomial2 = new Polynomial();
        polynomial2.split("x^3+x^2-x-2");
        polynomial3 = new Polynomial();
        polynomial3.split("1+x");
        result = new Polynomial();
        operations = new Operations();
    }

    public void test1() {
        result = operations.add(polynomial1,polynomial2);
        assertEquals(Permissions.printPolynomial(result),"x^3+x+1");
    }

    public void test2() {
        result = operations.subtract(polynomial1,polynomial2);
        assertEquals(Permissions.printPolynomial(result),"-x^3-2.0x^2+3.0x+5.0");
    }

    public void test3() {
        result = operations.multiplication(polynomial1,polynomial3);
        assertEquals(Permissions.printPolynomial(result),"-x^3+x^2+5.0x+3.0");
    }

    public void test4() {
        result = operations.integrate(polynomial3);
        assertEquals(Permissions.printPolynomial(result),"0.5x^2+x");
    }

    public void test5() {
        result = operations.derivate(polynomial3);
        assertEquals(Permissions.printPolynomial(result),"1");
    }

    public void test6() {
        Polynomial reminder = new Polynomial();
        result = operations.divide(polynomial2,polynomial1)[0];
        reminder = operations.divide(polynomial2,polynomial1)[1];
        assertEquals(Permissions.printPolynomial(result),"-x-3.0");
        assertEquals(Permissions.printPolynomial(reminder),"8.0x+7.0");
    }

    public void tearDown() throws Exception {
        polynomial3 = null;
        polynomial2 = null;
        polynomial1 = null;
        operations = null;
    }
}

