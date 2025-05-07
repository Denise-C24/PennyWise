import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.*;

//round button
class RoundedButton extends JButton {
    private Icon icon;

    // Constructor without an icon
    public RoundedButton(String text) {
        this(text, null);  // Call the main constructor with a null icon
    }

    // Constructor with both text and icon
    public RoundedButton(String text, Icon icon) {
        super(text);
        this.icon = icon;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arc = 50;

        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, width, height, arc, arc);
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        g2.setColor(getForeground());

        if (icon != null) {
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = (width - iconWidth) / 2;
            int y = (height - iconHeight) / 2;

            icon.paintIcon(this, g2, x, y);
        }

        super.paintComponent(g);
        g2.dispose();
    }
}
