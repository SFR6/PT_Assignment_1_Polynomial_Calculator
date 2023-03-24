package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintingTest
{
    @Test
    public void Test1()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(1, 2.0);
        f.setMonomialMap(monomialMap);

        assertEquals("2x", f.printPolynomial());
    }

    @Test
    public void Test2()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(100, 1.0);
        monomialMap.put(4, 5.6);
        monomialMap.put(0, 1.0);
        f.setMonomialMap(monomialMap);

        assertEquals("x^100+5.6x^4+1", f.printPolynomial());
    }

    @Test
    public void Test3()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(3, -1.0);
        monomialMap.put(2, -1.0);
        monomialMap.put(1, -1.0);
        f.setMonomialMap(monomialMap);

        assertEquals("-x^3-x^2-x", f.printPolynomial());
    }

    @Test
    public void Test4()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(0, 30.2);
        f.setMonomialMap(monomialMap);

        assertEquals("30.2", f.printPolynomial());
    }

    @Test
    public void Test5()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(0, 0.0);
        f.setMonomialMap(monomialMap);

        assertEquals("0", f.printPolynomial());
    }

    @Test
    public void Test6()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(0, -1.0);
        f.setMonomialMap(monomialMap);

        assertEquals("-1", f.printPolynomial());
    }

    @Test
    public void Test7()
    {
        Polynomial f = new Polynomial();
        Map<Integer, Double> monomialMap = new HashMap<>();
        monomialMap.put(1, 1.0);
        f.setMonomialMap(monomialMap);

        assertEquals("x", f.printPolynomial());
    }
}