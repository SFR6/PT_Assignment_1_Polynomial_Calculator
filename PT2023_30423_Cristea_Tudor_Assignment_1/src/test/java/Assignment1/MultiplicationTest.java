package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest
{
    @Test
    public void xTimes2xShouldEqual2xSquared()
    {
        String s1 = "x";
        String s2 = "2x";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("2x^2", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void Test1()
    {
        String s1 = "x^100+5.6x^4+1";
        String s2 = "-x^3-x^2-x";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("-x^103-x^102-x^101-5.6x^7-5.6x^6-5.6x^5-x^3-x^2-x", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void Test2()
    {
        String s1 = "x^3-2x^2+6x-5";
        String s2 = "x^2-1";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("x^5-2x^4+5x^3-3x^2-6x+5", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void thirtyPointTwoTimesTwelveShouldEqualThreeSixtyTwoPointFour()
    {
        String s1 = "30.2";
        String s2 = "12";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("362.4", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void Test3()
    {
        String s1 = "0";
        String s2 = "-4x^3";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("0", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void zeroTimesZeroShouldEqualZero()
    {
        String s1 = "0";
        String s2 = "0";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("0", (f.multiplyPolynomials(g)).printPolynomial());
    }

    @Test
    public void Test4()
    {
        String s1 = "x^2-x";
        String s2 = "x^2+x";
        Polynomial f = new Polynomial();
        Polynomial g = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            g.readPolynomial(s2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("x^4-x^2", (f.multiplyPolynomials(g)).printPolynomial());
    }
}