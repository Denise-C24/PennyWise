import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PennyWise extends JFrame {

    public PennyWise() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 640);
        setLocationRelativeTo(null);

        // Load animated GIF
        ImageIcon splashIcon = new ImageIcon("Final.gif");
        JLabel splashLabel = new JLabel(splashIcon);

        add(splashLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PennyWise splashFrame = new PennyWise(); // Create an instance of PennyWise
            splashFrame.setVisible(true);

            Timer timer = new Timer(2400, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    splashFrame.dispose(); // Close the splash frame
                    SwingUtilities.invokeLater(() -> new Register()); // Open the Register frame
                }
            });

            timer.setRepeats(false); // Execute only once
            timer.start();
        });
    }
}