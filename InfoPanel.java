import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;
import java.io.*;
import Backbone.Account;
import Backbone.BudgetOperation;


public class InfoPanel extends JPanel 
{
   
    private JTextField nameField;
    private JTextField passwordField;
    private JCheckBox checkBoxF;
    private JCheckBox checkBoxM;
    private JCheckBox checkBoxO;
    private int AccNum;
    private String newName;
    private String newPassword;
    private String role;
    private double currentBalance;
    private String name;
    private String password;
    private Account a;
    private String roleCheck = "";
    private String genderCheck = "";
 
    

    public InfoPanel(String name, String password) 
    {
          this.name = name;
          this.password = password;
          a = new Account();
          setLayout(new BorderLayout());
          setPreferredSize(new Dimension(780, 640));
        
        // editpanel setup
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BorderLayout());
        editPanel.setPreferredSize(new Dimension(780, 640));
         //edit panel background
        ImageIcon editImageIcon = new ImageIcon("infobgEDIT.png");
        Image editOriginalImage = editImageIcon.getImage();
        Image editScaledImage = editOriginalImage.getScaledInstance(780, 640, Image.SCALE_SMOOTH);
        ImageIcon editScaledIcon = new ImageIcon(editScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel editImageLabel = new JLabel(editScaledIcon);
        editImageLabel.setHorizontalAlignment(JLabel.CENTER);
        editImageLabel.setVerticalAlignment(JLabel.CENTER);
        
        //profile pic icon
        ImageIcon editoriginalLogoIcon = new ImageIcon(getClass().getResource("personal info icon.png"));
        int editlogoWidth = 210; // Adjust the width as needed
        int editlogoHeight = -1; // maintain ratio
        ImageIcon editlogoIcon = new ImageIcon(editoriginalLogoIcon.getImage().getScaledInstance(editlogoWidth, editlogoHeight, Image.SCALE_SMOOTH));
        JLabel editlogoLabel = new JLabel(editlogoIcon);
        editlogoLabel.setBounds(278, 105, editlogoIcon.getIconWidth(), editlogoIcon.getIconHeight());
       
         //text field setup
        //name textfield
        JLabel nameLabel = new JLabel("Change Name:");
        nameField = new JTextField(20);
        nameLabel.setBounds(80, 315, 150, 30);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nameField.setBounds(80, 350, 440, 32);
        //password text field
        JLabel passwordLabel = new JLabel("Change Password:"); 
        passwordField = new JTextField(10);
        passwordLabel.setBounds(80, 400, 300, 30);
        passwordField.setBounds(80, 435, 440, 32);
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        
        //Gender label
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(80, 485, 150, 30);
        genderLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        //gender comboBox
        String[] categories = {"Female", "Male", "Others"};
        JComboBox <String> comboBox = new JComboBox<>(categories);
        comboBox.setFont(new Font("Verdana", Font.PLAIN, 16));
        comboBox.setBounds(80, 520, 300, 30);
        comboBox.setBackground(Color.WHITE); 
        comboBox.setForeground(Color.BLACK);
        

        //save changes button setup         
        RoundedButton saveButton = new RoundedButton("Save Changes");        
        saveButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        saveButton.setBounds(480, 520, 225, 40);
        saveButton.setBackground(new Color(0x38556A)); 
        saveButton.setForeground(Color.WHITE);
        
       
       //updated information panel setup
        JPanel updatedPanel = new JPanel();
        updatedPanel.setLayout(new BorderLayout());
        updatedPanel.setPreferredSize(new Dimension(780, 640));
         //edit panel background
        ImageIcon updateImageIcon = new ImageIcon("updatedinfoPanelbg.png");
        Image updateOriginalImage = updateImageIcon.getImage();
        Image updateScaledImage = updateOriginalImage.getScaledInstance(780, 640, Image.SCALE_SMOOTH);
        ImageIcon updateScaledIcon = new ImageIcon(updateScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel updateImageLabel = new JLabel(updateScaledIcon);
        updateImageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImageLabel.setVerticalAlignment(JLabel.CENTER);
        
        a = new Account();
        a.setName(name);
        String user = a.getName();
        System.out.println(user);    
        JLabel updatedNameLabel = new JLabel(user);
        updatedNameLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        updatedNameLabel.setBounds(340,270, 600, 100);
        
        JLabel AccNumLabel = new JLabel("ACCOUNT NUMBER: " + a.getAccNum());
        AccNumLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        AccNumLabel.setBounds(110,325, 600, 100);
        
        boolean isUser;
        if (a.checkAdminExists(name, password))
        {
            roleCheck = "ADMIN";
        }
        else
        {
            roleCheck = "USER";
        }

        
        JLabel RoleLabel = new JLabel("ROLE: " + roleCheck);
        RoleLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        RoleLabel.setBounds(110,370, 600, 100);
        
        JLabel updatedGender = new JLabel("GENDER: ");
        updatedGender.setFont(new Font("Verdana", Font.BOLD, 18));
        updatedGender.setBounds(110,415, 600, 100);
       
        JLabel CurrentBalLabel = new JLabel("CURRENT BALANCE: " + String.format("PHP %.2f", a.readCurrBal()));
        CurrentBalLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        CurrentBalLabel.setBounds(110,465, 600, 100);
        
        // Action listener for the saveButton
    
         
         //profile pic icon
        ImageIcon updateoriginalLogoIcon = new ImageIcon(getClass().getResource("personal info icon.png"));
        int updatelogoWidth = 210; // Adjust the width as needed
        int updatelogoHeight = -1; // maintain ratio
        ImageIcon updatelogoIcon = new ImageIcon(updateoriginalLogoIcon.getImage().getScaledInstance(updatelogoWidth, updatelogoHeight, Image.SCALE_SMOOTH));
        JLabel updatelogoLabel = new JLabel(updatelogoIcon);
        updatelogoLabel.setBounds(278, 105, updatelogoIcon.getIconWidth(), updatelogoIcon.getIconHeight());
       
         //edit button
         //save changes button setup         
        RoundedButton editButton = new RoundedButton("Edit Personal Info");        
        editButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        editButton.setBounds(480, 520, 225, 40);
        editButton.setBackground(new Color(0x38556A)); 
        editButton.setForeground(Color.WHITE);

           
        //create cardlayout
        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
         cardPanel.add(updatedPanel, "updatedPanel");
        cardPanel.add(editPanel, "editPanel");
       
        //add(editImageLabel, BorderLayout.CENTER);
        
          //action listener
        saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
                cardLayout.show(cardPanel, "updatedPanel");
                nameLabel.setText(nameField.getText());
                AccNumLabel.setText("ACCOUNT NUMBER: " + a.getAccNum());
                RoleLabel.setText("ROLE: " + roleCheck);
                CurrentBalLabel.setText("CURRENT BALANCE: " + String.format("PHP %.2f", a.readCurrBal()));
                
                String selectedGender = null;
                selectedGender = (String) comboBox.getSelectedItem();
                updatedGender.setText("GENDER: " + selectedGender);
                newName = nameField.getText();
                newPassword = passwordField.getText();
                
                a.changeName(name, newName);
                a.changePassword(password, newPassword);
                           
            }
        });
        
        //action listener for editButton 
        editButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "editPanel"); 
                           
            }
        });


        //add components to the edit panel
        editPanel.add(nameLabel);
        editPanel.add(passwordLabel);
        editPanel.add(nameField);
        editPanel.add(saveButton);
        editPanel.add(passwordField);
        editPanel.add(genderLabel);
        editPanel.add(comboBox);
        editPanel.add(editlogoLabel);
        editPanel.add(editImageLabel, BorderLayout.CENTER);

        
        //add components to updated info panel
        updatedPanel.add(editButton);
        //updatedPanel.add(nameTrial);
        updatedPanel.add(updatedNameLabel);
        updatedPanel.add(AccNumLabel);
        updatedPanel.add(RoleLabel);
        updatedPanel.add(updatedGender);
        updatedPanel.add(CurrentBalLabel);
        updatedPanel.add(updatelogoLabel);
        updatedPanel.add(updateImageLabel, BorderLayout.CENTER);

        add(cardPanel);
        setVisible(true);      
    }
    
        
}