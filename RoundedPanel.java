// Create a separate RoundedPanel class
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedPanel extends JPanel {
    private Color bgColor;

    public RoundedPanel(Color bgColor) {
        this.bgColor = bgColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(bgColor);

        int arcWidth = 30; // Adjust the arc width as needed
        int arcHeight = 30; // Adjust the arc height as needed

        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        g2d.dispose();
    }
}
