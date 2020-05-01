package lesson7a;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {
        setBounds(600, 200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");

        JPanel panelN = new JPanel();
        panelN.setLayout(new BoxLayout(panelN, BoxLayout.X_AXIS));
        JTextField textField = new JTextField();
        panelN.add(textField);

        add(panelN, BorderLayout.NORTH);

        JPanel operations = new JPanel(new GridLayout(1, 4));

        JButton btn1 = new JButton("+");
        operations.add(btn1);

        JButton btn2 = new JButton("-");
        operations.add(btn2);

        JButton btn3 = new JButton("*");
        operations.add(btn3);

        JButton btn4 = new JButton("/");
        operations.add(btn4);

        JButton btnEquals = new JButton("=");
        panelN.add(btnEquals);

        add(operations, BorderLayout.SOUTH);

        JButton btnClear = new JButton("Clear");
        add(btnClear, BorderLayout.CENTER);

        final int[] value = new int[1]; // IDEA сказала что нельзя создать переменную, но предложила создать одиночный массив.
        final char [] action = new char[1];

        btn1.addActionListener(ea -> {
            value[0] = Integer.parseInt(textField.getText());
            action[0] = '+';
            textField.setText("");
        });
        btn2.addActionListener(ea -> {
            value[0] = Integer.parseInt(textField.getText());
            action[0] = '-';
            textField.setText("");
        });
        btn3.addActionListener(ea -> {
            value[0] = Integer.parseInt(textField.getText());
            action[0] = '*';
            textField.setText("");
        });
        btn4.addActionListener(ea -> {
            value[0] = Integer.parseInt(textField.getText());
            action[0] = '/';
            textField.setText("");
        });

        btnEquals.addActionListener(e -> {
            if (action[0] == '+') {
                textField.setText("" + (value[0] + Integer.parseInt(textField.getText())));
            } else if (action[0] == '-') {
                textField.setText("" + (value[0] - Integer.parseInt(textField.getText())));
            } else if (action[0] == '*') {
                textField.setText("" + (value[0] * Integer.parseInt(textField.getText())));
            } else if (action[0] == '/') {
                textField.setText("" + (value[0] / Integer.parseInt(textField.getText())));
            }
        });

        btnClear.addActionListener(e -> {
            value[0] = 0;
            textField.setText("");
        });

        setVisible(true);
    }
}