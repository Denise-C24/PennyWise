import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AboutPanel extends JPanel {
    public AboutPanel() {
        // About panel setup code
        setPreferredSize(new Dimension(780, 640));
        setLayout(new BorderLayout());

         // Expense panel background
        ImageIcon aboutImageIcon = new ImageIcon("aboutBackground.png");
        Image aboutOriginalImage = aboutImageIcon.getImage();
        Image aboutScaledImage = aboutOriginalImage.getScaledInstance(780, 640, Image.SCALE_SMOOTH);
        ImageIcon aboutScaledIcon = new ImageIcon(aboutScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel aboutImageLabel = new JLabel(aboutScaledIcon);
        aboutImageLabel.setHorizontalAlignment(JLabel.CENTER);
        aboutImageLabel.setVerticalAlignment(JLabel.CENTER);
        
        //logo icon
        ImageIcon originalLogoIcon = new ImageIcon(getClass().getResource("logo.png"));
        int logoWidth = 180; // Adjust the width as needed
        int logoHeight = -1; // maintain ratio
        ImageIcon logoIcon = new ImageIcon(originalLogoIcon.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(265, 10, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        
        //about icon
        ImageIcon aboutoriginalLogoIcon = new ImageIcon(getClass().getResource("aboutPanelLogo.png"));
        int aboutlogoWidth = 30; // Adjust the width as needed
        int aboutlogoHeight = -1; // maintain ratio
        ImageIcon aboutlogoIcon = new ImageIcon(aboutoriginalLogoIcon.getImage().getScaledInstance(aboutlogoWidth, aboutlogoHeight, Image.SCALE_SMOOTH));
        JLabel aboutlogoLabel = new JLabel(aboutlogoIcon);
        aboutlogoLabel.setBounds(-10, 205, logoIcon.getIconWidth(), logoIcon.getIconHeight());

        
        
     

         
        
  
         //text content
        JLabel penny = new JLabel("PennyWise");
        penny.setBounds(170, 170, 600, 65);
        penny.setFont(new Font("Verdana", Font.BOLD, 63));
        
        JLabel about = new JLabel("ABOUT");
        about.setBounds(102, 235, 600, 100);
        about.setFont(new Font("Verdana", Font.BOLD, 18));
        
        JLabel description1 = new JLabel("Welcome to PennyWise - Your Friendly Budgeting Companion!");
        description1.setBounds(90, 270, 600, 100);
        description1.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        JLabel description2 = new JLabel("At PennyWise, we understand the challenges that come with student life, and");
        description2.setBounds(90, 315, 600, 100);
        description2.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        JLabel description3 = new JLabel("we're  here   to   empower  you  on   your   financial   journey.  Our  mission");
        description3.setBounds(90, 330, 600, 100);
        description3.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        JLabel description4 = new JLabel("simple:  to  provide  students  with  a   user - friendly  budgeting  plan   that");
        description4.setBounds(90, 345, 600, 100);
        description4.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        JLabel description5 = new JLabel("helps  you  manage   your  finances   wisely,  so   you  can  focus   on  what");
        description5.setBounds(90, 360, 600, 100); 
        description5.setFont(new Font("Verdana", Font.PLAIN, 15));
        
         JLabel description6 = new JLabel("matters most – your education.");
        description6.setBounds(90,375, 600, 100);
        description6.setFont(new Font("Verdana", Font.PLAIN, 15));
        
        JLabel description7 = new JLabel("Developed By: Denise Aliah Cabiso, Josh Raven Lerio, Whela Quirol,");
        description7.setBounds(90, 430, 600, 100);
        description7.setFont(new Font("Verdana", Font.BOLD, 15));
        
        JLabel description8 = new JLabel("Johana Taboada, Goddess Phoebe Valdehuesa");
        description8.setBounds(90, 445, 600, 100);
        description8.setFont(new Font("Verdana", Font.BOLD, 15));
        
        
        JLabel copyright = new JLabel("© 2023 All Rights Reserved");
        copyright.setBounds(300, 505, 600, 100);
        copyright.setFont(new Font("Verdana", Font.BOLD, 10));
        copyright.setForeground(Color.GRAY);


        add(penny);
        add(about);
        add(description1);
        add(description2);
        add(description3);
        add(description4);
        add(description5);
        add(description6);
        add(description7);
        add(description8);
        add(copyright);
        add(logoLabel);
        add(aboutlogoLabel);
        add(aboutImageLabel, BorderLayout.CENTER);    
        }
} 