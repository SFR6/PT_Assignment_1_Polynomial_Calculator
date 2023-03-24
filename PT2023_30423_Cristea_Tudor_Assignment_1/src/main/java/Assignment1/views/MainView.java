package Assignment1.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame
{
    class MyButton extends JButton
    {
        private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;

        public MyButton(String text)
        {
            super(text);
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            if (getModel().isPressed())
            {
                g.setColor(pressedBackgroundColor);
            }
            else if (getModel().isRollover())
            {
                g.setColor(hoverBackgroundColor);
            }
            else
            {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        public Color getHoverBackgroundColor()
        {
            return hoverBackgroundColor;
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor)
        {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public Color getPressedBackgroundColor()
        {
            return pressedBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor)
        {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }
    }

    private JTextField firstPolyTextField;
    private JTextField secondPolyTextField;

    private JTextArea resultPolyTextArea;

    private MyButton swapPolyButton;
    private MyButton clearButton1;
    private MyButton clearButton2;
    private MyButton additionButton;
    private MyButton subtractionButton;
    private MyButton multiplicationButton;
    private MyButton divisionButton;
    private MyButton differentiationButton1;
    private MyButton differentiationButton2;
    private MyButton integrationButton1;
    private MyButton integrationButton2;

    public MainView()
    {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tudor Cristea\\Pictures\\Screenshots\\calculator-2017-10-10.png"));
        this.setTitle("Polynomial Calculator");
        this.getContentPane().setBackground(new Color(216, 191, 216));
        this.setBounds(100, 100, 880, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(7, 2, 10, 10));

        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        this.getContentPane().add(titleLabel);

        JLabel noteLabel = new JLabel("<html>Note: Use the following format for polynomials:<br>ax^n+bx^m+...+cx^p, where a, b, ...,  c are rational coefficients and n, m, ..., p are positive integers (≠1); use only 'x' or 'X' as the variable</html>");
        noteLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));

        swapPolyButton = new MyButton("Swap Polynomials");
        swapPolyButton.setBackground(new Color(123, 252, 225));
        swapPolyButton.setHoverBackgroundColor(new Color (76, 253, 220));
        swapPolyButton.setPressedBackgroundColor(new Color(0, 255, 218));
        swapPolyButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JSplitPane splitPane0 = new JSplitPane();
        splitPane0.setEnabled(false);
        splitPane0.setResizeWeight(0.95);
        this.getContentPane().add(splitPane0);
        splitPane0.setLeftComponent(noteLabel);
        splitPane0.setRightComponent(swapPolyButton);

        JLabel firstPolyLabel = new JLabel("First Polynomial:");
        firstPolyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPolyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(firstPolyLabel);
        
        firstPolyTextField = new JTextField();
        firstPolyTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstPolyTextField.setColumns(10);

        clearButton1 = new MyButton("Clear");
        clearButton1.setBackground(new Color(250, 129, 129));
        clearButton1.setHoverBackgroundColor(new Color (252, 89, 89));
        clearButton1.setPressedBackgroundColor(new Color(255, 63, 63));
        clearButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setEnabled(false);
        splitPane1.setResizeWeight(0.95);
        this.getContentPane().add(splitPane1);
        splitPane1.setLeftComponent(firstPolyTextField);
        splitPane1.setRightComponent(clearButton1);

        JLabel secondPolyLabel = new JLabel("Second Polynomial:");
        secondPolyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondPolyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(secondPolyLabel);

        secondPolyTextField = new JTextField();
        secondPolyTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        secondPolyTextField.setColumns(10);

        clearButton2 = new MyButton("Clear");
        clearButton2.setBackground(new Color(250, 129, 129));
        clearButton2.setHoverBackgroundColor(new Color (252, 89, 89));
        clearButton2.setPressedBackgroundColor(new Color(255, 63, 63));
        clearButton2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JSplitPane splitPane2 = new JSplitPane();
        splitPane2.setEnabled(false);
        splitPane2.setResizeWeight(0.95);
        this.getContentPane().add(splitPane2);
        splitPane2.setLeftComponent(secondPolyTextField);
        splitPane2.setRightComponent(clearButton2);

        JLabel resultPolyLabel = new JLabel("Result Polynomial:");
        resultPolyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultPolyLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        this.getContentPane().add(resultPolyLabel);

        resultPolyTextArea = new JTextArea();
        resultPolyTextArea.setBackground(new Color(211, 211, 211));
        resultPolyTextArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        resultPolyTextArea.setEditable(false);
        resultPolyTextArea.setColumns(10);
        this.getContentPane().add(resultPolyTextArea);

        additionButton = new MyButton("Add Polynomials");
        additionButton.setBackground(new Color(255, 200, 100));
        additionButton.setHoverBackgroundColor(new Color (255, 200, 50));
        additionButton.setPressedBackgroundColor(new Color(255, 200, 0));
        additionButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(additionButton);

        subtractionButton = new MyButton("Subtract Polynomials");
        subtractionButton.setBackground(new Color(255, 200, 100));
        subtractionButton.setHoverBackgroundColor(new Color (255, 200, 50));
        subtractionButton.setPressedBackgroundColor(new Color(255, 200, 0));
        subtractionButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(subtractionButton);

        multiplicationButton = new MyButton("Multiply Polynomials");
        multiplicationButton.setBackground(new Color(144, 238, 144));
        multiplicationButton.setHoverBackgroundColor(new Color(144, 238, 94));
        multiplicationButton.setPressedBackgroundColor(new Color(144, 238, 44));
        multiplicationButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(multiplicationButton);

        divisionButton = new MyButton("Divide Polynomials");
        divisionButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        divisionButton.setBackground(new Color(144, 238, 144));
        divisionButton.setHoverBackgroundColor(new Color(144, 238, 94));
        divisionButton.setPressedBackgroundColor(new Color(144, 238, 44));
        this.getContentPane().add(divisionButton);

        differentiationButton1 = new MyButton("Differentiate Polynomial 1");
        differentiationButton1.setBackground(new Color(135, 206, 250));
        differentiationButton1.setHoverBackgroundColor(new Color(85, 206, 250));
        differentiationButton1.setPressedBackgroundColor(new Color(35, 206, 250));
        differentiationButton1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        differentiationButton2 = new MyButton("Differentiate Polynomial 2");
        differentiationButton2.setBackground(new Color(135, 206, 250));
        differentiationButton2.setHoverBackgroundColor(new Color(85, 206, 250));
        differentiationButton2.setPressedBackgroundColor(new Color(35, 206, 250));
        differentiationButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JSplitPane splitPane3 = new JSplitPane();
        splitPane3.setEnabled(false);
        splitPane3.setResizeWeight(0.5);
        this.getContentPane().add(splitPane3);
        splitPane3.setLeftComponent(differentiationButton1);
        splitPane3.setRightComponent(differentiationButton2);

        integrationButton1 = new MyButton("Integrate Polynomial 1");
        integrationButton1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        integrationButton1.setBackground(new Color(135, 206, 250));
        integrationButton1.setHoverBackgroundColor(new Color(85, 206, 250));
        integrationButton1.setPressedBackgroundColor(new Color(35, 206, 250));

        integrationButton2 = new MyButton("Integrate Polynomial 2");
        integrationButton2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        integrationButton2.setBackground(new Color(135, 206, 250));
        integrationButton2.setHoverBackgroundColor(new Color(85, 206, 250));
        integrationButton2.setPressedBackgroundColor(new Color(35, 206, 250));

        JSplitPane splitPane4 = new JSplitPane();
        splitPane4.setEnabled(false);
        splitPane4.setResizeWeight(0.5);
        this.getContentPane().add(splitPane4);
        splitPane4.setLeftComponent(integrationButton1);
        splitPane4.setRightComponent(integrationButton2);

        this.setVisible(true);
    }

    public JTextField getFirstPolyTextField()
    {
        return firstPolyTextField;
    }

    public void setFirstPolyTextField(JTextField firstPolyTextField)
    {
        this.firstPolyTextField = firstPolyTextField;
    }

    public JTextField getSecondPolyTextField()
    {
        return secondPolyTextField;
    }

    public void setSecondPolyTextField(JTextField secondPolyTextField)
    {
        this.secondPolyTextField = secondPolyTextField;
    }

    public JTextArea getResultPolyTextArea()
    {
        return resultPolyTextArea;
    }

    public void setResultPolyTextArea(JTextArea resultPolyTextArea)
    {
        this.resultPolyTextArea = resultPolyTextArea;
    }

    public void addSwapPolyButtonListener(ActionListener actionListener)
    {
        swapPolyButton.addActionListener(actionListener);
    }

    public void addClearButton1Listener(ActionListener actionListener)
    {
        clearButton1.addActionListener(actionListener);
    }

    public void addClearButton2Listener(ActionListener actionListener)
    {
        clearButton2.addActionListener(actionListener);
    }

    public void addAdditionButtonListener(ActionListener actionListener)
    {
        additionButton.addActionListener(actionListener);
    }

    public void addSubtractionButtonListener(ActionListener actionListener)
    {
        subtractionButton.addActionListener(actionListener);
    }

    public void addMultiplicationButtonListener(ActionListener actionListener)
    {
        multiplicationButton.addActionListener(actionListener);
    }

    public void addDivisionButtonListener(ActionListener actionListener)
    {
        divisionButton.addActionListener(actionListener);
    }

    public void addDifferentiationButton1Listener(ActionListener actionListener)
    {
        differentiationButton1.addActionListener(actionListener);
    }

    public void addDifferentiationButton2Listener(ActionListener actionListener)
    {
        differentiationButton2.addActionListener(actionListener);
    }

    public void addIntegrationButton1Listener(ActionListener actionListener)
    {
        integrationButton1.addActionListener(actionListener);
    }

    public void addIntegrationButton2Listener(ActionListener actionListener)
    {
        integrationButton2.addActionListener(actionListener);
    }

    public void showErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}