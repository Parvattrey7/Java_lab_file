package Ques10;
import javax.swing.*;
import java.awt.*;

public class LayoutDemonstration {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("BorderLayout and FlowLayout Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null); 

            frame.setLayout(new BorderLayout(10, 10)); 

            JPanel northPanel = createFlowLayoutPanel();
            frame.add(northPanel, BorderLayout.NORTH);

            JButton centerButton = createStyledButton("Center (Main Content Area)", Color.LIGHT_GRAY);
            frame.add(centerButton, BorderLayout.CENTER);

            JButton southButton = createStyledButton("South (Status Bar / Footer)", new Color(150, 200, 255));
            frame.add(southButton, BorderLayout.SOUTH);

            JButton eastButton = createStyledButton("East (Sidebar)", new Color(255, 200, 150));
            frame.add(eastButton, BorderLayout.EAST);

            JButton westButton = createStyledButton("West (Navigation Menu)", new Color(200, 255, 200));
            frame.add(westButton, BorderLayout.WEST);

            frame.setVisible(true);
        });
    }

    private static JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15)); 

        panel.add(createStyledButton("FL Button 1", new Color(255, 255, 180)));
        panel.add(createStyledButton("FL Button 2", new Color(255, 255, 180)));
        panel.add(createStyledButton("FL Button 3", new Color(255, 255, 180)));
        panel.add(createStyledButton("FL Button 4", new Color(255, 255, 180)));
        panel.add(createStyledButton("FL Button 5", new Color(255, 255, 180)));
        panel.setBorder(BorderFactory.createTitledBorder("North Panel (Uses FlowLayout)"));

        return panel;
    }

    private static JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        if (text.contains("West") || text.contains("East")) {
            button.setPreferredSize(new Dimension(150, 100));
        }
        return button;
    }
}