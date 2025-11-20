package Ques8;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class SumCalculator implements ActionListener {

    private JFrame frame;
    private JTextField number1Field, number2Field;
    private JButton sumButton;
    private JLabel resultLabel;

    public SumCalculator() {
        frame = new JFrame("Simple Sum Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setPreferredSize(new Dimension(350, 200));

        number1Field = new JTextField(10);
        number2Field = new JTextField(10);

        sumButton = new JButton("Calculate Sum");
        sumButton.addActionListener(this);

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        frame.add(new JLabel("Enter Number 1:"));
        frame.add(number1Field);
        frame.add(new JLabel("Enter Number 2:"));
        frame.add(number2Field);
        frame.add(new JLabel(""));
        frame.add(sumButton);
        frame.add(new JLabel(""));
        frame.add(resultLabel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SumCalculator();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sumButton) {
            try {
                String num1Text = number1Field.getText();
                String num2Text = number2Field.getText();

                double num1 = Double.parseDouble(num1Text);
                double num2 = Double.parseDouble(num2Text);

                double sum = num1 + num2;

                resultLabel.setText("Result: " + sum);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Result: Invalid input. Please enter numbers.");
            }
        }
    }
}