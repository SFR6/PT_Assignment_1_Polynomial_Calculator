package Assignment1;

import Assignment1.models.Polynomial;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest
{
    @Test
    public void xIntegratedShouldEqualZeroPointFiveXSquared()
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

        assertEquals("0.5x^2", (f.integratePolynomial()).printPolynomial());
    }

    @Test
    public void twoXIntegratedShouldEqualXSquared()
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

        assertEquals("x^2", (f.integratePolynomial()).printPolynomial());
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

        assertEquals("0.01x^101+1.12x^5+x", (f.integratePolynomial()).printPolynomial());
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

        assertEquals("-0.25x^4-0.33x^3-0.5x^2", (f.integratePolynomial()).printPolynomial());
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

        assertEquals("0.25x^4-0.67x^3+3x^2-5x", (f.integratePolynomial()).printPolynomial());
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

        assertEquals("0.33x^3-x", (f.integratePolynomial()).printPolynomial());
    }

    @Test
    public void thirtyPointTwoIntegratedShouldEqualThirtyPointTwoX()
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

        assertEquals("30.2x", (f.integratePolynomial()).printPolynomial());
    }

    @Test
    public void ZeroIntegratedShouldEqualZero()
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

        assertEquals("0", (f.integratePolynomial()).printPolynomial());
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

        assertEquals("-x^4", (f.integratePolynomial()).printPolynomial());
    }
}