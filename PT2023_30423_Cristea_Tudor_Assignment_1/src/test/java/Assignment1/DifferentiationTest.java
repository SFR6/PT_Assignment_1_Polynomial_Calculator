package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifferentiationTest
{
    @Test
    public void xDifferentiatedShouldEqualOne()
    {
        String s1 = "x";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("1", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void twoXDifferentiatedShouldEqualTwo()
    {
        String s1 = "2x";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("2", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void Test1()
    {
        String s1 = "x^100+5.6x^4+1";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("100x^99+22.4x^3", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void Test2()
    {
        String s1 = "-x^3-x^2-x";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("-3x^2-2x-1", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void Test3()
    {
        String s1 = "x^3-2x^2+6x-5";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("3x^2-4x+6", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void Test4()
    {
        String s1 = "x^2-1";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("2x", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void thirtyPointTwoDifferentiatedShouldEqualZero()
    {
        String s1 = "30.2";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("0", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void ZeroDifferentiatedShouldEqualZero()
    {
        String s1 = "0";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("0", (f.differentiatePolynomial()).printPolynomial());
    }

    @Test
    public void Test5()
    {
        String s1 = "-4x^3";
        Polynomial f = new Polynomial();
        try
        {
            f.readPolynomial(s1);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        assertEquals("-12x^2", (f.differentiatePolynomial()).printPolynomial());
    }
}