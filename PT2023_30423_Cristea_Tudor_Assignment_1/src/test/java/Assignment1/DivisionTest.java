package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest
{
    @Test
    public void xDividedBy2xShouldEqualQuotientZeroPointFiveRemainderZero()
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

        try
        {
            assertEquals("0.5", (f.dividePolynomials(g))[0].printPolynomial());
            assertEquals("0", (f.dividePolynomials(g))[1].printPolynomial());
        }
        catch (Exception ignored)
        {

        }
    }

    @Test
    public void Test2()
    {
        String s1 = "x^2-1";
        String s2 = "x^3-2x^2+6x-5";
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

        try
        {
            assertEquals("x-2", (f.dividePolynomials(g))[0].printPolynomial());
            assertEquals("7x-7", (f.dividePolynomials(g))[1].printPolynomial());
        }
        catch (Exception ignored)
        {

        }
    }

    @Test
    public void thirtyPointTwoDividedByTwelveShouldEqualQuotientTwoPointFiveTwoRemainderZero()
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

        try
        {
            assertEquals("2.52", (f.dividePolynomials(g))[0].printPolynomial());
            assertEquals("0", (f.dividePolynomials(g))[1].printPolynomial());
        }
        catch (Exception ignored)
        {

        }
    }

    @Test
    public void Test3ShouldThrowException()
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

        assertThrows(Exception.class,() -> f.dividePolynomials(g));
    }

    @Test
    public void zeroDividedByZeroShouldThrowException()
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

        assertThrows(Exception.class,() -> f.dividePolynomials(g));
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

        try
        {
            assertEquals("1", (f.dividePolynomials(g))[0].printPolynomial());
            assertEquals("-2x", (f.dividePolynomials(g))[1].printPolynomial());
        }
        catch (Exception ignored)
        {

        }
    }
}