package calculadora;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorOperations model;
    private CalculatorView view;

    public CalculatorController(CalculatorOperations model, CalculatorView view) {
        this.model = model;
        this.view = view;

        initializeListeners();
    }

    private void initializeListeners() {
        JButton[] numberButtons = view.getNumberButtons();
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 4; i++) {
            JButton operatorButton = view.getOperatorButton(i);
            operatorButton.addActionListener(this);
        }

        JButton equalButton = view.getOperatorButton(4);
        equalButton.addActionListener(this);

        JButton clearButton = view.getOperatorButton(5);
        clearButton.addActionListener(this);

        JButton powerButton = view.getOperatorButton(6); // Power (^) button
        powerButton.addActionListener(this);

        JButton rootButton = view.getOperatorButton(7); // Root (√) button
        rootButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        JButton pb = (JButton) ae.getSource();
        String buttonText = pb.getText();

        if (buttonText.equals("C")) {
            model.clear();
            view.getDisplay().setText("");
        } else if (buttonText.equals("=")) {
            model.calculate();
            view.getDisplay().setText("" + model.getResult());
        } else if ("+-*/".contains(buttonText)) {
            model.setOperator(buttonText.charAt(0));
            view.getDisplay().setText("");
        } else if (buttonText.equals("^")) {
            model.setOperator('^');
            view.getDisplay().setText("");
        } else if (buttonText.equals("√")) {
            model.calculateSquareRoot();
            view.getDisplay().setText("" + model.getResult());
        } else {
            int num = Integer.parseInt(buttonText);
            model.setNumber(num);
            String displayText = view.getDisplay().getText();
            view.getDisplay().setText(displayText + num);
        }
    }

    public static void main(String arg[]) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
    }
}

