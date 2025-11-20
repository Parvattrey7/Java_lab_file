package Ques13;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class ClickChanger {

    private static final String INITIAL_MESSAGE = "Click the button below!";
    private static final String CLICKED_MESSAGE = "The button was clicked! Event handled.";

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(ClickChanger::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Event Handling Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450, 200));

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel messageLabel = new JLabel(INITIAL_MESSAGE, JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton clickButton = new JButton("Change Text");
        clickButton.setFont(new Font("Arial", Font.PLAIN, 14));

        clickButton.addActionListener(e -> {
            System.out.println("Button Click Event Fired!");
            if (messageLabel.getText().equals(INITIAL_MESSAGE)) {
                 messageLabel.setText(CLICKED_MESSAGE);
            } else {
                 messageLabel.setText(INITIAL_MESSAGE);
            }
        });

        panel.add(messageLabel, BorderLayout.CENTER);
        panel.add(clickButton, BorderLayout.SOUTH);

        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}