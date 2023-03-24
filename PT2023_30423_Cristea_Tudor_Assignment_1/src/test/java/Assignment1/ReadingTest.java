package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadingTest
{
    @Test
    public void Test1()
    {
        String s = "2x";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(1, 2.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test2()
    {
        String s = "X^100+5.6X^4+1";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(100, 1.0);
        res.put(4, 5.6);
        res.put(0, 1.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test3()
    {
        String s = "- x^3 -x ^2-x ";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(3, -1.0);
        res.put(2, -1.0);
        res.put(1, -1.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test4()
    {
        String s = "30.2";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(0, 30.2);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test5()
    {
        String s = "0";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(0, 0.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test6()
    {
        String s = "x^2+x^2";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(2, 2.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test7()
    {
        String s = "x^2-x^2";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(0, 0.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test8()
    {
        String s = "x";
        Polynomial f = new Polynomial();
        Map<Integer, Double> res = new HashMap<>();
        res.put(1, 1.0);
        try
        {
            f.readPolynomial(s);
        }
        catch (Exception ignored)
        {

        }

        assertEquals(res, f.getMonomialMap());
    }

    @Test
    public void Test9()
    {
        String s = "";
        Polynomial f = new Polynomial();

        assertThrows(Exception.class, () -> f.readPolynomial(s));
    }

    @Test
    public void Test10()
    {
        String s = "a^2-b";
        Polynomial f = new Polynomial();

        assertThrows(Exception.class, () -> f.readPolynomial(s));
    }

    @Test
    public void Test11()
    {
        String s = "-4x^-3";
        Polynomial f = new Polynomial();

        assertThrows(Exception.class, () -> f.readPolynomial(s));
    }


    @Test
    public void Test12()
    {
        String s = "5x^3-2x+78x^0";
        Polynomial f = new Polynomial();

        assertThrows(Exception.class, () -> f.readPolynomial(s));
    }
}