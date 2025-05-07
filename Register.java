import javax.swing.*; // components of a GUI
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //for event handling
import java.awt.image.BufferedImage; //image stored
import java.io.*; // input output
import javax.imageio.ImageIO; //writing in the image
import java.net.*; //for urls
import Backbone.Account; //from the folder

public class Register extends JFrame implements ActionListener {

    private JTextField nameField;
    private JPasswordField passwordField;
    private JPasswordField confirmpassField;  

    public Register() {
        // Set frame properties
        setTitle("PennyWise: Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024, 640);
        ImageIcon icon = new ImageIcon("logo.png"); // logo for frame
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        

        // load the bg image
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
        communityLabel.setBounds(250, 370, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        
        
        //mouse listener hover + click on icons
        githubLabel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
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


        //panel to hold components and set it as transparent
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        //content       
        JLabel hiLabel = new JLabel("Hi, Welcome!");
        JLabel registerLabel = new JLabel("REGISTER");
        JLabel pennyLabel = new JLabel("PennyWise");
        
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        JLabel confirmpassLabel = new JLabel("Confirm Password:");
        confirmpassField = new JPasswordField(10);
        
        
        //font + bounds for each component
        hiLabel.setBounds(600, 115, 300, 50);
        hiLabel.setFont(new Font("Verdana", Font.BOLD, 35));
        
        registerLabel.setBounds(600, 150, 300, 50);
        registerLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        
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

        
        nameLabel.setBounds(600, 203, 500, 25);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        nameField.setBounds(600, 230, 290, 30);
        
        passwordLabel.setBounds(600, 270, 500, 25);
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        passwordField.setBounds(600, 297, 290, 30);
        
        confirmpassLabel.setBounds(600, 337, 500, 25);
        confirmpassLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        confirmpassField.setBounds(600, 364, 290, 30);

         //getstarted button setup
        JButton getStartedButton = new JButton("GET STARTED");
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
        
        JLabel haveLabel = new JLabel("Already have an account?");
        haveLabel.setFont(new Font("Verdana", Font.ITALIC, 13));
        haveLabel.setBounds(615, 450, 500, 25);
        haveLabel.setFocusable(true);

        //login button
        JButton loginButton = new JButton("Log in");
        loginButton.setFont(new Font("Verdana", Font.BOLD, 12));
        loginButton.setBounds(800, 450, 75, 25);
        loginButton.setBackground(new Color(0, 0, 0, 0));
        loginButton.setOpaque(false);
        
        
        // Add components to the panel
        contentPanel.add(iconsPanel);
        contentPanel.add(pennyLabel);
        contentPanel.add(logoLabel);
        contentPanel.add(hiLabel);
        contentPanel.add(registerLabel);
        contentPanel.add(nameLabel);
        contentPanel.add(passwordLabel);
        contentPanel.add(confirmpassLabel);
        contentPanel.add(haveLabel);
        contentPanel.add(loginButton);
        contentPanel.add(descriptionPanel);
        contentPanel.add(nameField);
        contentPanel.add(passwordField);
        contentPanel.add(confirmpassField);
        contentPanel.add(getStartedButton);        
        contentPanel.setVisible(true);
        
        
        
        
        // Add action listener to the "Add Expense" button
        getStartedButton.addActionListener(this);
        loginButton.addActionListener(this);



        // Make the frame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Account a = Account.getInstance();  //initialize Account object with the same instance
        if (e.getActionCommand().equals("GET STARTED")) {
            // Handle registration logic here
            String name = nameField.getText();
            String password = passwordField.getText(); 
            String conPassword = confirmpassField.getText(); 
            a.setName(name);
            a.setPassword(password);
            System.out.println(password + "" + conPassword);
            // Validate input (You can add more validation as needed)
            if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(!password.equals(conPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords don't match! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (name.length() < 3) {
                JOptionPane.showMessageDialog(this, "Invalid Input. Name should be at least 3 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (password.length() < 5 || password.length() > 15) {
                JOptionPane.showMessageDialog(this, "Invalid Input. Password should be between 5 and 15 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (a.verifyAccount(name, password)) {
                JOptionPane.showMessageDialog(this, "This Account already exists", "Error", JOptionPane.ERROR_MESSAGE);
    
            } else {
                // Registration successful
                a.writeAccount(a.getName(), a.getPassword());
                a.eraseContent();
                JOptionPane.showMessageDialog(this, "Successfully registered!", "Success", JOptionPane.INFORMATION_MESSAGE);
               
                // Clear text fields
                nameField.setText("");
                passwordField.setText("");
                confirmpassField.setText("");
                
                 dispose(); // Close the current frame
            new Login();
            }
        } else if (e.getActionCommand().equals("Log in")) {
            // For simplicity, let's just show a message
            dispose(); // Close the current frame
            new Login(); // Open a new Login frame
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
        SwingUtilities.invokeLater(Register::new);
    }
}
