package Assignment1.controllers;

import Assignment1.models.Polynomial;
import Assignment1.views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController
{
    private MainView view;

    public MainController(MainView view)
    {
        this.view = view;

        this.view.addSwapPolyButtonListener(new SwapPolyButtonListener());
        this.view.addClearButton1Listener(new ClearButton1Listener());
        this.view.addClearButton2Listener(new ClearButton2Listener());
        this.view.addAdditionButtonListener(new AdditionButtonListener());
        this.view.addSubtractionButtonListener(new SubtractionButtonListener());
        this.view.addMultiplicationButtonListener(new MultiplicationButtonListener());
        this.view.addDivisionButtonListener(new DivisionButtonListener());
        this.view.addDifferentiationButton1Listener(new DifferentiationButton1Listener());
        this.view.addDifferentiationButton2Listener(new DifferentiationButton2Listener());
        this.view.addIntegrationButton1Listener(new IntegrationButton1Listener());
        this.view.addIntegrationButton2Listener(new IntegrationButton2Listener());
    }

    private Polynomial readPoly(JTextField polyTextField)
    {
        Polynomial poly = new Polynomial();
        try
        {
            poly.readPolynomial(polyTextField.getText());
        }
        catch (Exception ex)
        {
            view.showErrorMessage(ex.getMessage());
            return null;
        }
        return poly;
    }

    class SwapPolyButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String aux = view.getFirstPolyTextField().getText();
            view.getFirstPolyTextField().setText(view.getSecondPolyTextField().getText());
            view.getSecondPolyTextField().setText(aux);
        }
    }

    class ClearButton1Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.getFirstPolyTextField().setText("");
        }
    }

    class ClearButton2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.getSecondPolyTextField().setText("");
        }
    }

    class AdditionButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            Polynomial g = readPoly(view.getSecondPolyTextField());
            if (f != null && g != null)
            {
                Polynomial addRes = f.addPolynomials(g);
                view.getResultPolyTextArea().setText(addRes.printPolynomial());
            }
        }
    }

    class SubtractionButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            Polynomial g = readPoly(view.getSecondPolyTextField());
            if (f != null && g != null)
            {
                Polynomial subRes = f.subtractPolynomials(g);
                view.getResultPolyTextArea().setText(subRes.printPolynomial());
            }
        }
    }

    class MultiplicationButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            Polynomial g = readPoly(view.getSecondPolyTextField());
            if (f != null && g != null)
            {
                Polynomial mulRes = f.multiplyPolynomials(g);
                view.getResultPolyTextArea().setText(mulRes.printPolynomial());
            }
        }
    }

    class DivisionButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            Polynomial g = readPoly(view.getSecondPolyTextField());
            if (f != null && g != null)
            {
                try
                {
                    Polynomial[] divRes = f.dividePolynomials(g);
                    view.getResultPolyTextArea().setText("Quotient: " + divRes[0].printPolynomial() + "\nRemainder: " + divRes[1].printPolynomial());
                }
                catch (Exception ex)
                {
                    view.showErrorMessage(ex.getMessage());
                }
            }
        }
    }

    class DifferentiationButton1Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            if (f != null)
            {
                Polynomial diffRes = f.differentiatePolynomial();
                view.getResultPolyTextArea().setText(diffRes.printPolynomial());
            }
        }
    }

    class DifferentiationButton2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getSecondPolyTextField());
            if (f != null)
            {
                Polynomial diffRes = f.differentiatePolynomial();
                view.getResultPolyTextArea().setText(diffRes.printPolynomial());
            }
        }
    }

    class IntegrationButton1Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getFirstPolyTextField());
            if (f != null)
            {
                Polynomial diffRes = f.integratePolynomial();
                view.getResultPolyTextArea().setText(diffRes.printPolynomial());
            }
        }
    }

    class IntegrationButton2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Polynomial f = readPoly(view.getSecondPolyTextField());
            if (f != null)
            {
                Polynomial diffRes = f.integratePolynomial();
                view.getResultPolyTextArea().setText(diffRes.printPolynomial());
            }
        }
    }
}