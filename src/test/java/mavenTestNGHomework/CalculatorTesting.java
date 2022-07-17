package mavenTestNGHomework;

import homeworkNineCalculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CalculatorTesting {

    Calculator calculator;

    @BeforeClass
    public void pirmsKlases() {
        System.out.println("Tiks pārbaudīta kalkulatora darbība");
    }

    @BeforeMethod
    public void pirmsTests() {
        System.out.println("Sākās tests");
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        System.out.println("Saskaitīšana");
        int actualResult = calculator.add(5,25);
        int expectedResult = 30;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSub() {
        System.out.println("Atņemšana");
        int actualResult = calculator.substract(12,8);
        int expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiply() {
        System.out.println("Reizināšana");
        int actualResult = calculator.multiply(6,3);
        int expectedResult = 18;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testDivide() {
        System.out.println("Dalīšana");
        float actualResult = calculator.divide(20,4);
        float expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }

}
