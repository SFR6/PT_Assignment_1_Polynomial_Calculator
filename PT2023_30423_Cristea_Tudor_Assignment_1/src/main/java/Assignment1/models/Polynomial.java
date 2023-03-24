package Assignment1.models;

import java.text.DecimalFormat;
import java.util.*;

public class Polynomial
{
    private Map<Integer, Double> monomialMap;

    public Polynomial()
    {
        this.monomialMap = new HashMap<>();
    }

    public Map<Integer, Double> getMonomialMap()
    {
        return monomialMap;
    }

    public void setMonomialMap(Map<Integer, Double> monomialMap)
    {
        this.monomialMap = monomialMap;
    }

    public void readPolynomial(String string) throws Exception
    {
        if (!string.equals(""))
        {
            string = string.replace(" ", ""); // removing spaces
            String polynomialRegex = "^([+-]?\\d*(\\.\\d+)?[xX]?(\\^([2-9]|[1-9]\\d+))?)+$";
            if (string.matches(polynomialRegex))
            {
                String[] monomials = string.split("(?=[+-])");
                for (String monomial: monomials)
                {
                    if (!monomial.equals(""))
                    {
                        String[] numbers = monomial.split("[xX]");
                        if (numbers.length == 0)
                        {
                            monomialMap.put(1, 1.0);
                        }
                        else
                        {
                            double coeff;
                            if (numbers[0].equals("") || numbers[0].equals("+"))
                            {
                                coeff = 1;
                            }
                            else if (numbers[0].equals("-"))
                            {
                                coeff = -1;
                            }
                            else
                            {
                                coeff = Double.parseDouble(numbers[0]);
                            }

                            int degree = 0; // default case
                            if (numbers.length == 1)
                            {
                                if (monomial.contains("x") || monomial.contains("X"))
                                {
                                    degree = 1;
                                }
                            }
                            else if (numbers.length == 2)
                            {
                                numbers[1] = numbers[1].substring(1);
                                degree = Integer.parseInt(numbers[1]);
                            }

                            if (coeff != 0)
                            {
                                if (monomialMap.containsKey(degree))
                                {
                                    double newCoeff = coeff + monomialMap.get(degree);
                                    if (newCoeff != 0)
                                    {
                                        monomialMap.put(degree, newCoeff);
                                    }
                                    else
                                    {
                                        monomialMap.remove(degree);
                                    }
                                }
                                else
                                {
                                    monomialMap.put(degree, coeff);
                                }
                            }
                        }
                    }
                }
                if (monomialMap.isEmpty())
                {
                    monomialMap.put(0, 0.0);
                }
            }
            else
            {
                throw new Exception("Invalid input:\n" + string);
            }
        }
        else
        {
            throw new Exception("Invalid input:\nEmpty string");
        }
    }

    public String printPolynomial()
    {
        TreeMap<Integer, Double> monomialMap2 = new TreeMap<>(Collections.reverseOrder());
        monomialMap2.putAll(this.monomialMap);
        String poly = "";
        boolean firstNumber = true;
        for(Map.Entry<Integer, Double> m: monomialMap2.entrySet())
        {
            if (m.getValue() == -1)
            {
                poly += "-";
                if (m.getKey() == 0)
                {
                    poly += '1';
                }
            }
            else
            {
                if (m.getValue() > 0)
                {
                    if (!firstNumber)
                    {
                        poly += "+";
                    }
                }
                if (m.getValue() == 1)
                {
                    if (m.getKey() == 0)
                    {
                        poly += '1';
                    }
                }
                else
                {
                    if (m.getValue().intValue() == m.getValue())
                    {
                        poly += Integer.toString(m.getValue().intValue());
                    }
                    else
                    {
                        DecimalFormat decimalFormat = new DecimalFormat("#0.##");
                        String formattedValue = decimalFormat.format(m.getValue());
                        poly += formattedValue;
                    }
                }
            }
            firstNumber = false;

            if (m.getKey() != 0)
            {
                poly += "x";
                if (m.getKey() > 1)
                {
                    poly += "^";
                    poly += Integer.toString(m.getKey());
                }
            }
        }
        poly = poly.replace(',', '.');

        return poly;
    }

    public Polynomial addPolynomials(Polynomial f)
    {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> monomial: this.getMonomialMap().entrySet())
        {
            int currentDegree = monomial.getKey();
            if (f.getMonomialMap().containsKey(currentDegree))
            {
                double coeff = monomial.getValue() + f.getMonomialMap().get(currentDegree);
                if (coeff != 0)
                {
                    res.getMonomialMap().put(currentDegree, coeff);
                }
            }
            else
            {
                if (monomial.getValue() != 0)
                {
                    res.getMonomialMap().put(monomial.getKey(), monomial.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Double> monomial: f.getMonomialMap().entrySet())
        {
            int currentDegree = monomial.getKey();
            if (!res.getMonomialMap().containsKey(currentDegree) && !this.getMonomialMap().containsKey(currentDegree) && monomial.getValue() != 0)
            {
                res.getMonomialMap().put(monomial.getKey(), monomial.getValue());
            }
        }

        if (res.getMonomialMap().isEmpty())
        {
            res.getMonomialMap().put(0, 0.0);
        }
        return res;
    }

    public Polynomial subtractPolynomials(Polynomial f)
    {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> monomial: this.getMonomialMap().entrySet())
        {
            int currentDegree = monomial.getKey();
            if (f.getMonomialMap().containsKey(currentDegree))
            {
                double coeff = monomial.getValue() - f.getMonomialMap().get(currentDegree);
                if (coeff != 0)
                {
                    res.getMonomialMap().put(currentDegree, coeff);
                }
            }
            else
            {
                if (monomial.getValue() != 0)
                {
                    res.getMonomialMap().put(monomial.getKey(), monomial.getValue());
                }
            }
        }

        for (Map.Entry<Integer, Double> monomial: f.getMonomialMap().entrySet())
        {
            int currentDegree = monomial.getKey();
            if (!res.getMonomialMap().containsKey(currentDegree) && !this.getMonomialMap().containsKey(currentDegree) && monomial.getValue() != 0)
            {
                res.getMonomialMap().put(monomial.getKey(), -monomial.getValue());
            }
        }

        if (res.getMonomialMap().isEmpty())
        {
            res.getMonomialMap().put(0, 0.0);
        }
        return res;
    }

    public Polynomial multiplyPolynomials(Polynomial f)
    {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> monomialF: this.getMonomialMap().entrySet())
        {
            for (Map.Entry<Integer, Double> monomialG: f.getMonomialMap().entrySet())
            {
                double coeff = monomialF.getValue() * monomialG.getValue();
                int degree = monomialF.getKey() + monomialG.getKey();
                if (res.getMonomialMap().containsKey(degree))
                {
                    double oldCoeff = res.getMonomialMap().get(degree);
                    if (oldCoeff + coeff != 0)
                    {
                        for (Map.Entry<Integer, Double> m: res.getMonomialMap().entrySet())
                        {
                            if (m.getKey() == degree)
                            {
                                m.setValue(m.getValue() + coeff);
                            }
                        }
                        res.getMonomialMap().replace(degree, oldCoeff, oldCoeff + coeff);
                    }
                    else
                    {
                        res.getMonomialMap().remove(degree);
                    }
                }
                else
                {
                    if (coeff != 0)
                    {
                        res.getMonomialMap().put(degree, coeff);
                    }
                }
            }
        }

        if (res.getMonomialMap().isEmpty())
        {
            res.getMonomialMap().put(0, 0.0);
        }
        return res;
    }

    public Polynomial[] dividePolynomials(Polynomial g) throws Exception
    {
        Polynomial f = this;
        if ((f.getMonomialMap().size() == 1 && f.getMonomialMap().get(0) != null && f.getMonomialMap().get(0) == 0) ||
                (g.getMonomialMap().size() == 1 && g.getMonomialMap().get(0) != null && g.getMonomialMap().get(0) == 0))
        {
            throw new Exception("Division by 0 is impossible!");
        }
        else
        {
            Polynomial q = new Polynomial();
            Polynomial r;
            TreeMap<Integer, Double> monomialMapF = new TreeMap<>(Collections.reverseOrder());
            monomialMapF.putAll(f.getMonomialMap());
            TreeMap<Integer, Double> monomialMapG = new TreeMap<>(Collections.reverseOrder());
            monomialMapG.putAll(g.getMonomialMap());
            if (monomialMapG.firstEntry().getKey() > monomialMapF.firstEntry().getKey())
            {
                Polynomial aux = f;
                f = g;
                g = aux;

                TreeMap<Integer, Double> auxMap = monomialMapF;
                monomialMapF = monomialMapG;
                monomialMapG = auxMap;
            }
            TreeMap<Integer, Double> monomialMapR = new TreeMap<>(Collections.reverseOrder());
            do
            {
                int degree = monomialMapF.firstEntry().getKey() - monomialMapG.firstEntry().getKey();
                double coeff = monomialMapF.firstEntry().getValue() / monomialMapG.firstEntry().getValue();

                Polynomial intermediate = new Polynomial();
                intermediate.getMonomialMap().put(degree, coeff);

                q.getMonomialMap().put(degree, coeff);
                r = f.subtractPolynomials(intermediate.multiplyPolynomials(g));
                monomialMapR.clear();
                monomialMapR.putAll(r.getMonomialMap());
                f = r;
                monomialMapF.clear();
                monomialMapF.putAll(f.getMonomialMap());
            }while(monomialMapR.firstEntry().getKey() >= monomialMapG.firstEntry().getKey() && r.getMonomialMap().get(0) != 0);

            return new Polynomial[]{q, r};
        }
    }

    public Polynomial differentiatePolynomial()
    {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> monomial: this.getMonomialMap().entrySet())
        {
            if (monomial.getKey() != 0)
            {
                int degree = monomial.getKey() - 1;
                double coeff = monomial.getKey() * monomial.getValue();
                if (coeff != 0)
                {
                    res.getMonomialMap().put(degree, coeff);
                }
            }
        }

        if (res.getMonomialMap().isEmpty())
        {
            res.getMonomialMap().put(0, 0.0);
        }
        return res;
    }

    public Polynomial integratePolynomial()
    {
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> monomial: this.getMonomialMap().entrySet())
        {
            int degree = monomial.getKey() + 1;
            double coeff = monomial.getValue() / degree;
            if (coeff != 0)
            {
                res.getMonomialMap().put(degree, coeff);
            }
        }

        if (res.getMonomialMap().isEmpty())
        {
            res.getMonomialMap().put(0, 0.0);
        }
        return res;
    }
}