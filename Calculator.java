import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField tf;
    JButton add, sub, mul, div, equals, clear, decimal;
    JButton[] numberButtons;
    double[] nums = new double[100];  // Array to store input values
    int numIndex = 0;                 // Index of the next empty slot in the array
    String operator;

    public Calculator() {
        tf = new JTextField(10);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equals = new JButton("=");
        clear = new JButton("C");
        decimal = new JButton(".");
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        equals.addActionListener(this);
        clear.addActionListener(this);
        decimal.addActionListener(this);
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton("" + i);
            numberButtons[i].addActionListener(this);
        }
        JPanel p1 = new JPanel(new GridLayout(5, 3, 5, 5));
        p1.add(numberButtons[1]);
        p1.add(numberButtons[2]);
        p1.add(numberButtons[3]);
        p1.add(add);
        p1.add(numberButtons[4]);
        p1.add(numberButtons[5]);
        p1.add(numberButtons[6]);
        p1.add(sub);p1.add(numberButtons[7]);
        p1.add(numberButtons[8]);
        p1.add(numberButtons[9]);
        p1.add(mul);
        p1.add(decimal);
        p1.add(numberButtons[0]);
        p1.add(clear);
        p1.add(div);

        JPanel p2 = new JPanel(new BorderLayout(5, 5));
        p2.add(tf, BorderLayout.CENTER);
        p2.add(p1, BorderLayout.EAST);
        JPanel p3 = new JPanel(new GridLayout(1, 1, 5, 5));
        p3.add(equals);
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(p2, BorderLayout.CENTER);
        getContentPane().add(p3, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("+")) {
            operator = "+";
            nums[numIndex++] = Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("-")) {
            operator = "-";
            nums[numIndex++] = Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("*")) {
            operator = "*";
            nums[numIndex++] = Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("/")) {
            operator = "/";
            nums[numIndex++] = Double.parseDouble(tf.getText());
            tf.setText("");
        } else if (s.equals("=")) {
            nums[numIndex++] = Double.parseDouble(tf.getText());
            double result = nums[0];
            for (int i = 1; i < numIndex; i++) {
                if (operator.equals("+")) {
                    result += nums[i];
                } else if (operator.equals("-")) {
                    result -= nums[i];
                } else if (operator.equals("*")) {
                    result *= nums[i];
                } else if (operator.equals("/")) {
                    result /= nums[i];
                }
            }
            tf.setText("" + result);
            numIndex = 0;
        } else if (s.equals("C")) {
            tf.setText("");
            numIndex = 0;
        } else {
            tf.setText(tf.getText() + s);
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator() ;
    }
}

