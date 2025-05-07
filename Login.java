import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Map;
import java.net.*; //for urls
import Backbone.BudgetOperation;
import Backbone.Account;

public class Login extends JFrame implements ActionListener {

    private JTextField nameField;
    private JPasswordField passwordField;  
    private JCheckBox checkBoxU;
    private JCheckBox checkBoxA;
    private Account a;

    public Login() {
        //frame set up
        a = new Account();
        setTitle("PennyWise: Log in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024, 640);
        ImageIcon icon = new ImageIcon("logo.png"); // logo for the frame
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        


        //load the background image
        BufferedImage backgroundImage = loadImage("gui.png");
        //Graphics2D object to draw on the image
        Graphics2D g2d = backgroundImage.createGraphics();
        //for smooth text
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        
        
         //icon setups     
        //logo icon
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("logoLogin.png"));
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(100, 120, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        //github icon 
        ImageIcon githubIcon = new ImageIcon(getClass().getResource("githubLogo.png"));
        JLabel githubLabel = new JLabel(githubIcon);
        githubLabel.setBounds(170, 370, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        //email icon    
        ImageIcon emIcon = new ImageIcon(getClass().getResource("EmailLogo.png"));
        JLabel emLabel = new JLabel(emIcon);
        emLabel.setBounds(330, 370, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        //community icon      
        ImageIcon communityIcon = new ImageIcon(getClass().getResource("communityLogo.png"));
        JLabel communityLabel = new JLabel(communityIcon);

        
          //mouse listener hover + click on icons
          githubLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
          int newWidth = (int) (githubIcon.getIconWidth() + 2);
          int newHeight = (int) (githubIcon.getIconHeight() + 2);
          githubLabel.setIcon(new ImageIcon(githubIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                githubLabel.setIcon(githubIcon);
               }
            
             public void mouseClicked(MouseEvent e) {
                openURL("https://github.com"); // Replace with your GitHub URL
            }
        });
        
         communityLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         int newComWidth = (int) (communityIcon.getIconWidth() + 3);
         int newComHeight = (int) (communityIcon.getIconHeight() + 3);
          communityLabel.setIcon(new ImageIcon(communityIcon.getImage().getScaledInstance(newComWidth, newComHeight, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                communityLabel.setIcon(communityIcon);
            }
            
             public void mouseClicked(MouseEvent e) {
                openURL("https://PennyWise.com");            
             }
        });
         
         emLabel.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         int newEmailWidth = (int) (emIcon.getIconWidth() + 3);
         int newEmailHeight = (int) (emIcon.getIconHeight() + 3);
         emLabel.setIcon(new ImageIcon(emIcon.getImage().getScaledInstance(newEmailWidth, newEmailHeight, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               emLabel.setIcon(emIcon); // Restore original size on exit
            }
            
             public void mouseClicked(MouseEvent e) {
                openURL("mailto:goddessphoebevaldehuesa@gmail.com"); // Replace with your GitHub URL
            }
        });



         //panel for icons in flowlayout
         JPanel iconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0)); // for elements spacing
         iconsPanel.setOpaque(false);
         // add icon labels to the panel
         iconsPanel.add(githubLabel);
         iconsPanel.add(communityLabel);
         iconsPanel.add(emLabel);
         iconsPanel.setBounds(190, 380, 260, logoIcon.getIconHeight());         



        // Create a panel to hold components and set it as transparent
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        //declare components
        JLabel hiLabel = new JLabel("Hi, Welcome!");
        JLabel loginLabel = new JLabel("LOG IN");
        JLabel pennyLabel = new JLabel("PennyWise");
        
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        
        
        //set bounds + font for each left text component
        hiLabel.setBounds(600, 115, 300, 50);
        hiLabel.setFont(new Font("Verdana", Font.BOLD, 35)); 
        loginLabel.setBounds(600, 150, 300, 50);
        loginLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        pennyLabel.setBounds(120, 180, 500, 100);
        pennyLabel.setFont(new Font("Verdana", Font.BOLD, 60));
        
        
        
        //description
        JLabel description1 = new JLabel("Discover financial freedom with Pennywise—where");
        description1.setFont(new Font("Verdana", Font.PLAIN, 14));
        
        JLabel description2 = new JLabel("every penny paves  the  way to prosperity.  Start");
        description2.setFont(new Font("Verdana", Font.PLAIN, 14));
        
        JLabel description3 = new JLabel("your  journey to smarter spending and a  brighter");
        description3.setFont(new Font("Verdana", Font.PLAIN, 14));
        
        JLabel description4 = new JLabel("financial future today!");
        description4.setFont(new Font("Verdana", Font.PLAIN, 14)); 
        //store in flowlayout panel
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(description1);
        descriptionPanel.add(description2);
        descriptionPanel.add(description3);
        descriptionPanel.add(description4);
        descriptionPanel.setBounds(125, 270, 400, 100);
        
        
        //set bounds + font for each right text component
        nameLabel.setBounds(600, 203, 500, 25);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        nameField.setBounds(600, 230, 290, 30);
        
        passwordLabel.setBounds(600, 270, 500, 25);
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        passwordField.setBounds(600, 297, 290, 30);
        
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(600, 350, 300, 12);
        roleLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        
        
        //checkbox set up
        checkBoxU = new JCheckBox();
        checkBoxA = new JCheckBox();
        
        checkBoxU.setText("USER");
        checkBoxU.setFont(new Font("Verdana", Font.BOLD, 16));
        checkBoxU.setBounds(640, 370, 100, 30);
        checkBoxU.setForeground(Color.BLACK);
        checkBoxU.setFocusable(false);
        checkBoxU.setOpaque(false);
        
        checkBoxA.setText("ADMIN");
        checkBoxA.setFont(new Font("Verdana", Font.BOLD, 16));
        checkBoxA.setBounds(750, 370, 115, 30);
        checkBoxA.setForeground(Color.BLACK);
        checkBoxA.setFocusable(false);
        checkBoxA.setOpaque(false);

        
        //getStartedButton setup
        JButton getStartedButton = new JButton("LOG IN");
        getStartedButton.setFont(new Font("Verdana", Font.BOLD, 14));
        getStartedButton.setBounds(600, 410, 290, 30);
        getStartedButton.setBackground(Color.BLACK); 
        getStartedButton.setForeground(Color.WHITE);  
         //mouse hover
         getStartedButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
        getStartedButton.setBounds(595, 405, 300, 35);
         }

         public void mouseExited(java.awt.event.MouseEvent evt) {
        getStartedButton.setFont(new Font("Verdana", Font.BOLD, 14));
        getStartedButton.setBounds(600, 410, 290, 30);
         }
      });  
        

        JLabel haveLabel = new JLabel("Don't have an account?");
        haveLabel.setFont(new Font("Verdana", Font.ITALIC, 13));
        haveLabel.setBounds(615, 450, 500, 25);
        haveLabel.setFocusable(true);

         //register button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Verdana", Font.BOLD, 13));
        registerButton.setBounds(780, 450, 100, 25);
        registerButton.setBackground(new Color(0, 0, 0, 0));
        registerButton.setOpaque(false);
        
        
        // Add components to the panel
        contentPanel.add(iconsPanel);
        contentPanel.add(roleLabel);
        contentPanel.add(pennyLabel);
        contentPanel.add(logoLabel);
        contentPanel.add(hiLabel);
        contentPanel.add(loginLabel);
        contentPanel.add(nameLabel);
        contentPanel.add(passwordLabel);
        contentPanel.add(haveLabel);
        contentPanel.add(registerButton);
        contentPanel.add(descriptionPanel);
        contentPanel.add(nameField);
        contentPanel.add(passwordField);
        contentPanel.add(passwordField);
        contentPanel.add(getStartedButton);   
        contentPanel.add(checkBoxU);
        contentPanel.add(checkBoxA);       
        contentPanel.setVisible(true);
        
        
        // Add action listener to the "Add Expense" button
        getStartedButton.addActionListener(this);
        registerButton.addActionListener(this);
        checkBoxU.addActionListener(this);
        checkBoxA.addActionListener(this);
        getContentPane().add(getStartedButton);

        // Make the frame visible
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("LOG IN")) {
          BudgetOperation b = new BudgetOperation();
          String name = nameField.getText();
          String password = passwordField.getText();
          
          System.out.println("Name: " + name);
          System.out.println("Password: " + password);
          a.setName(name);
          a.setPassword(password);
      
          if (name.isEmpty() || password.isEmpty()) {
              JOptionPane.showMessageDialog(this, "Complete all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
          } else if (a.verifyAccount(name, password) || a.checkAdminExists(name, password)) {
              if (a.correctPassword(password) || a.checkAdminExists(name, password)) {
                     if (checkBoxU.isSelected() && checkBoxA.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please select only one role.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (checkBoxU.isSelected()) {
                       boolean userExists = a.verifyAccount(name, password);
                       handleLoginResult(userExists, "USER");
                       a.eraseContent();
                   } else if (checkBoxA.isSelected()) {
                       boolean adminExists = a.checkAdminExists(name, password);
                       handleLoginResult(adminExists, "ADMIN");
                   }
    
              } else {
                  JOptionPane.showMessageDialog(null, "Incorrect password!");
              }
          } else {
              nameField.setText("");
              passwordField.setText("");
              JOptionPane.showMessageDialog(null, "Account does not exist!");
          }
      } else if (e.getActionCommand().equals("Register")) {
          dispose();
          new Register();   
      }
        
    }


    private void handleLoginResult(boolean success, String role) {
    if (success) {
        JOptionPane.showMessageDialog(this, "Successfully logged in as " + role, "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();

        if ("USER".equals(role)) {
            new MenuFrame(a); // Open the Dashboard frame for users palihug tag connect 
        } else if ("ADMIN".equals(role)) {
            new AdminDashboard(); // Open the Admin Dashboard frame for admins
        }
    } else {
        JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
     
    private BufferedImage loadImage(String imagePath) 
    {
        try 
        {
            return ImageIO.read(getClass().getResource(imagePath));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
       
    private void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("Desktop is not supported.");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(Login::new);
    }
}

