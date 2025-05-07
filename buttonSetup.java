import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.*;

public class buttonSetup
{
   private Font plainFont = new Font("Verdana", Font.PLAIN, 16);
   private Font boldFont = new Font("Verdana", Font.BOLD, 16);
   private Dimension buttonSize = new Dimension(180, 40);
   
   public void dashboardButton()
   {
      RoundedButton dashButton = new RoundedButton("Dashboard");
      dashButton.setFont(boldFont);
      dashButton.setForeground(new Color(0xFFFFFF));
      dashButton.setBackground(new Color(0x38556A));
      dashButton.setPreferredSize(buttonSize);

   }
   
   
}