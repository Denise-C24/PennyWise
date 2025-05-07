import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;
import java.io.*;
import Backbone.Account;
import Backbone.BudgetOperation;

public class MenuFrame extends JFrame implements ActionListener {
    private Account currentUserAccount;
    
    public MenuFrame(Account userAccount) {
        // Jframe main setup
        setTitle("PennyWise: Expense Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
        setSize(1024, 640);
        ImageIcon icon = new ImageIcon("logo.png"); // logo for the frame
        setIconImage(icon.getImage());
        
        
        // Panel creation
        
        DashboardPanel dashboard = new DashboardPanel(userAccount.getName(), userAccount.getPassword());
        InfoPanel info = new InfoPanel(userAccount.getName(), userAccount.getPassword());
        ExpensePanel expense = new ExpensePanel(userAccount.getName(), userAccount.getPassword(), dashboard);
        AboutPanel about = new AboutPanel();

        //dashbutton setup
        RoundedButton dashButton = new RoundedButton("Dashboard");
        dashButton.setFont(new Font("Verdana", Font.BOLD, 16));
        dashButton.setForeground(new Color(0xFFFFFF));
        dashButton.setBackground(new Color(0x38556A));
        dashButton.setPreferredSize(new Dimension(180, 40));
        //infobutton setup
        RoundedButton infoButton = new RoundedButton("Personal Info");
        infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        infoButton.setForeground(new Color(0xFFFFFF));
        infoButton.setBackground(new Color(0x7F959C));
        infoButton.setPreferredSize(new Dimension(180, 40));
        //expensebutton setup
        RoundedButton expenseButton = new RoundedButton("History");
        expenseButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        expenseButton.setForeground(new Color(0xFFFFFF));
        expenseButton.setBackground(new Color(0x7F959C));
        expenseButton.setPreferredSize(new Dimension(180, 40));
        //aboutbutton setup
        RoundedButton aboutButton = new RoundedButton("About");
        aboutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        aboutButton.setForeground(new Color(0xFFFFFF));
        aboutButton.setBackground(new Color(0x7F959C));
        aboutButton.setPreferredSize(new Dimension(180, 40));
        //lgoutbutton setup
        RoundedButton logoutButton = new RoundedButton("Log out");
        logoutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        logoutButton.setForeground(new Color(0xFFFFFF));
        logoutButton.setBackground(new Color(0x1C3A46));
        logoutButton.setBorderPainted(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setPreferredSize(new Dimension(180, 40)); 
        
        // Add panels to cardPanel
        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.add(dashboard, "dashboard");
        cardPanel.add(info, "info");
        cardPanel.add(expense, "expense");
        cardPanel.add(about, "about");

  
        //button clickAction
        dashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "dashboard");
                dashButton.setBackground(new Color(0x38556A));
                dashButton.setFont(new Font("Verdana", Font.BOLD, 16));
                infoButton.setBackground(new Color(0x7F959C));
                infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                aboutButton.setBackground(new Color(0x7F959C));
                aboutButton.setFont(new Font("Verdana", Font.PLAIN, 16)); 
                expenseButton.setBackground(new Color(0x7F959C));
                expenseButton.setFont(new Font("Verdana", Font.PLAIN, 16));
             }
        });
        
        infoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                 cardLayout.show(cardPanel, "info");
                 infoButton.setBackground(new Color(0x38556A));
                 infoButton.setFont(new Font("Verdana", Font.BOLD, 16));
                 dashButton.setBackground(new Color(0x7F959C));
                 dashButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 aboutButton.setBackground(new Color(0x7F959C));
                 aboutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 expenseButton.setBackground(new Color(0x7F959C));
                 expenseButton.setFont(new Font("Verdana", Font.PLAIN, 16));
            }
          });
          
        expenseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                 cardLayout.show(cardPanel, "expense");
                 expenseButton.setBackground(new Color(0x38556A));
                 expenseButton.setFont(new Font("Verdana", Font.BOLD, 16));
                 dashButton.setBackground(new Color(0x7F959C));
                 dashButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 aboutButton.setBackground(new Color(0x7F959C));
                 aboutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 infoButton.setBackground(new Color(0x7F959C));
                 infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
            }
          });
          
        aboutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                 cardLayout.show(cardPanel, "about");
                 aboutButton.setBackground(new Color(0x38556A));
                 aboutButton.setFont(new Font("Verdana", Font.BOLD, 16));
                 dashButton.setBackground(new Color(0x7F959C));
                 dashButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 infoButton.setBackground(new Color(0x7F959C));
                 infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
                 expenseButton.setBackground(new Color(0x7F959C));
                 expenseButton.setFont(new Font("Verdana", Font.PLAIN, 16));
            }
          });
 
       logoutButton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
            Account a = new Account();
            logoutButton.setFont(new Font("Verdana", Font.BOLD, 16));   
            a.eraseContent();
            
              dispose();
          }
            });
            
       //button hover action
       dashButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
        dashButton.setFont(dashButton.getFont().deriveFont(Font.BOLD));
        dashButton.setPreferredSize(new Dimension(new Dimension(180, 40).width + 5, new Dimension(180, 40).height + 5));
         }

         public void mouseExited(java.awt.event.MouseEvent evt) {
        dashButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        dashButton.setPreferredSize(new Dimension(180, 40));
         }
       });      
          
       infoButton.addMouseListener(new java.awt.event.MouseAdapter() {
       public void mouseEntered(java.awt.event.MouseEvent evt) {
       infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        infoButton.setPreferredSize(new Dimension(new Dimension(180, 40).width + 5, new Dimension(180, 40).height + 5));
         }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        infoButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        infoButton.setPreferredSize(new Dimension(180, 40));
         }
      }); 
   
      expenseButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
         expenseButton.setFont(expenseButton.getFont().deriveFont(Font.BOLD));
        expenseButton.setPreferredSize(new Dimension(new Dimension(180, 40).width + 5, new Dimension(180, 40).height + 5));
      }

         public void mouseExited(java.awt.event.MouseEvent evt) {
        expenseButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        expenseButton.setPreferredSize(new Dimension(180, 40));
      }
   });   
   
       aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
        aboutButton.setFont(aboutButton.getFont().deriveFont(Font.BOLD));
        aboutButton.setPreferredSize(new Dimension(new Dimension(180, 40).width + 5, new Dimension(180, 40).height + 5));
      }

         public void mouseExited(java.awt.event.MouseEvent evt) {
        aboutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        aboutButton.setPreferredSize(new Dimension(180, 40));
      }
   });     
   
   logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            // Change font to bold when mouse enters the button
            logoutButton.setFont(new Font("Verdana", Font.BOLD, 16)); // Replace "YourFontName" with your font
            }

         public void mouseExited(java.awt.event.MouseEvent evt) {
        // Change font back to plain when mouse exits the button
        logoutButton.setFont(new Font("Verdana", Font.PLAIN, 16)); // Replace "YourFontName" with your font
         }
      });
      
       //panel for button with GridBagLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(230,330));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6); // Add insets for spacing
        //dashbutton panel setup
         constraints.gridx = 0;
         constraints.gridy = 1;
         constraints.gridwidth = 1; // Make the button span 1 column
         constraints.gridheight = 1; // Make the button span 1 row
        buttonPanel.add(dashButton, constraints);       
        //infobutton panel setup
         constraints.gridx = 0;
         constraints.gridy = 2;
         constraints.gridwidth = 1; // Make the button span 1 column
         constraints.gridheight = 1; // Make the button span 1 row
        buttonPanel.add(infoButton, constraints); 
        //expensebutton panel setup
        constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.gridwidth = 1; // Make the button span 1 column
            constraints.gridheight = 1; // Make the button span 1 row 
        buttonPanel.add(expenseButton, constraints);
        //aboutbutton panel setup
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 1; // Make the button span 1 column
            constraints.gridheight = 1; // Make the button span 1 row 
            constraints.insets = new Insets(6, 6, 40, 6); //the third is for the spacing between the about and logout button
        buttonPanel.add(aboutButton, constraints);
        //lgoutButton panel setup
            constraints.gridx = 0;
            constraints.gridy = 5;
            constraints.gridwidth = 1; // Make the button span 1 column
            constraints.gridheight = 1; // Make the button span 1 row 
            constraints.insets = new Insets(20, 6, 6, 6);
        buttonPanel.add(logoutButton, constraints);

        
      //logo with title
      ImageIcon menulogoriginalLogoIcon = new ImageIcon(getClass().getResource("logo with words.png"));
        int menulogologoWidth = 180; // Adjust the width as needed
        int menulogologoHeight = -1; // maintain ratio
        ImageIcon menulogologoIcon = new ImageIcon(menulogoriginalLogoIcon.getImage().getScaledInstance(menulogologoWidth, menulogologoHeight, Image.SCALE_SMOOTH));
        JLabel menulogologoLabel = new JLabel(menulogologoIcon);
      
      //menu profile icon
        ImageIcon menuproforiginalLogoIcon = new ImageIcon(getClass().getResource("menuprofileicon.png"));
        int menuproflogoWidth = 190; // Adjust the width as needed
        int menuproflogoHeight = -1; // maintain ratio
        ImageIcon menuproflogoIcon = new ImageIcon(menuproforiginalLogoIcon.getImage().getScaledInstance(menuproflogoWidth, menuproflogoHeight, Image.SCALE_SMOOTH));
        JLabel menuproflogoLabel = new JLabel(menuproflogoIcon);
        
      //menuProfile name static lng sa pero basically mao ni icode aron moappear and maposition siya
        JLabel ProfileNameLabel = new JLabel("User");
        ProfileNameLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        ProfileNameLabel.setForeground(Color.WHITE);

      //top part of menu
       JPanel topMenuPanel = new JPanel();
       topMenuPanel.setPreferredSize(new Dimension(230,320));
       topMenuPanel.setOpaque(false);
       topMenuPanel.setLayout(new GridBagLayout());
       GridBagConstraints constraints1 = new GridBagConstraints();
       constraints1.insets = new Insets(6, 6, 6, 6); // Add insets for spacing
       //logo position
       constraints1.gridx = 0;
       constraints1.gridy = 1;
       constraints1.gridwidth = 1; // Make the button span 1 column
       constraints1.gridheight = 1; // Make the button span 1 row
       topMenuPanel.add(menulogologoLabel, constraints1);
       //pfp position
       constraints1.gridx = 0;
       constraints1.gridy = 2;
       constraints1.gridwidth = 1; // Make the button span 1 column
       constraints1.gridheight = 1; // Make the button span 1 row
       topMenuPanel.add(menuproflogoLabel, constraints1); 
       //username label position
       constraints1.gridx = 0;
       constraints1.gridy = 3;
       constraints1.gridwidth = 1; // Make the button span 1 column
       constraints1.gridheight = 1; // Make the button span 1 row 
       topMenuPanel.add(ProfileNameLabel, constraints1);
      

      //menu panel 
       JPanel menuPanel = createRoundedPanel(new Color(0x1C3A46));
       menuPanel.setPreferredSize(new Dimension(230,640));
       menuPanel.setLayout(new BorderLayout());
       menuPanel.add(topMenuPanel, BorderLayout.NORTH);
       menuPanel.add(buttonPanel, BorderLayout.SOUTH);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(cardPanel, BorderLayout.EAST);
        container.add(menuPanel, BorderLayout.WEST);
        setBackground(new Color(0xDBE4E6));
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
   }
     private JPanel createRoundedPanel(Color bgColor) {
        return new RoundedPanel(bgColor);
    }

   public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Save Changes")) 
        {

          
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuFrame(new Account()));
    }
}