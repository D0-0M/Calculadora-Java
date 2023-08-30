package calculadora;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JButton b[];
    private JButton b10, b11, b12, b13, b14, b15, b16, b17; // Add buttons for ^ and √
    private JTextField res;

    public CalculatorView() {
        super("Calculator");
        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));

        b = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            b[i] = new JButton(i + "");
            p.add(b[i]);
        }

        b10 = new JButton("+");
        p.add(b10);
        b11 = new JButton("-");
        p.add(b11);
        b12 = new JButton("*");
        p.add(b12);
        b13 = new JButton("/");
        p.add(b13);
        b14 = new JButton("=");
        p.add(b14);
        b15 = new JButton("C");
        p.add(b15);
        b16 = new JButton("^"); // Add the ^ button
        p.add(b16);
        b17 = new JButton("√"); // Add the √ button
        p.add(b17);

        res = new JTextField(10);
        add(p, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);

        setVisible(true);
        setSize(200, 200);
    }

    public JButton[] getNumberButtons() {
        return b;
    }

    public JButton getOperatorButton(int index) {
        JButton[] operatorButtons = { b10, b11, b12, b13, b14, b15, b16, b17 };
        return operatorButtons[index];
    }

    public JTextField getDisplay() {
        return res;
    }
}
