package Ques9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public class ColorChangerGUI extends Frame implements ActionListener {

    private Button colorButton;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA};
    private int currentColorIndex = 0;

    public ColorChangerGUI() {
        setTitle("AWT Color Changer");
        setSize(400, 200);
        setLayout(new FlowLayout());

        colorButton = new Button("Click Me to Change Color");
        
        colorButton.addActionListener(this);

        add(colorButton);

        setBackground(colors[currentColorIndex]);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            currentColorIndex = (currentColorIndex + 1) % colors.length;
            
            setBackground(colors[currentColorIndex]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorChangerGUI());
    }
}