import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import Backbone.Account;
import java.util.ArrayList;

public class AdminDashboard extends JFrame implements ActionListener {

        private JButton AddAccountButton;
        private JButton RemoveAccountButton;
        private JButton LogoutButton;
        private Account adminAccount;

private JTable recentTransactionsTable;

    public AdminDashboard() {
        adminAccount = Account.getInstance();
        Account a = new Account();
        setTitle("PennyWise: Administrator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1024, 640);
        ImageIcon icon = new ImageIcon("logo.png"); // logo for the frame
        setIconImage(icon.getImage());
        
        //background
        ImageIcon adminImageIcon = new ImageIcon("adminDashboardBG.png");
        Image adminOriginalImage = adminImageIcon.getImage();
        Image adminScaledImage = adminOriginalImage.getScaledInstance(1024, 640, Image.SCALE_SMOOTH);
        ImageIcon adminScaledIcon = new ImageIcon(adminScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel adminImageLabel = new JLabel(adminScaledIcon);
        adminImageLabel.setHorizontalAlignment(JLabel.CENTER);
        adminImageLabel.setVerticalAlignment(JLabel.CENTER);

        // JTable setup
        JPanel JTablepanel = createRoundedPanel(new Color(0x1C3A46));
        JTablepanel.setBounds(65, 100, 880, 435);

        JLabel RecentAct = new JLabel("ACCOUNT MANAGER");
        RecentAct.setBounds(380, 330, 600, 100);
        RecentAct.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        RecentAct.setForeground(new Color(0xFFFFFF));

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Account Number");
        tableModel.addColumn("Name");
        tableModel.addColumn("Password");

        recentTransactionsTable = new JTable(tableModel);

        recentTransactionsTable.setPreferredScrollableViewportSize(new Dimension(800, 300));

        // Adjust row height
        recentTransactionsTable.setRowHeight(30);

        // Adjust column widths
        TableColumnModel columnModel = recentTransactionsTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);

        
        //button set up
        AddAccountButton = new JButton("Add Account");
        AddAccountButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        RemoveAccountButton = new JButton("Remove Account");
        RemoveAccountButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        LogoutButton = new JButton("Log out");
        LogoutButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        // panel for buttons
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        inputPanel.setPreferredSize(new Dimension(450, 75));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6); 
         //addedbutton panel setup
         constraints.gridx = 0;
         constraints.gridy = 1;
         constraints.gridwidth = 1; // Make the button span 1 column
         constraints.gridheight = 1; // Make the button span 1 row
         constraints.insets = new Insets(6, 10, 6, 6); 
        inputPanel.add(AddAccountButton, constraints);       
        //removebutton panel setup
         constraints.gridx = 1;
         constraints.gridy = 1;
         constraints.gridwidth = 1; // Make the button span 1 column
         constraints.gridheight = 1; // Make the button span 1 row
        constraints.insets = new Insets(6, 10, 6, 6); 
        inputPanel.add(RemoveAccountButton, constraints);
        //logoutbutton panel setup
         constraints.gridx = 2;
         constraints.gridy = 1;
         constraints.gridwidth = 1; // Make the button span 1 column
         constraints.gridheight = 1; // Make the button span 1 row
         inputPanel.add(LogoutButton, constraints); 

          

        JScrollPane scrollPane = new JScrollPane(recentTransactionsTable);
        JTablepanel.add(RecentAct);
        JTablepanel.add(scrollPane, BorderLayout.CENTER);
        JTablepanel.add(inputPanel, BorderLayout.SOUTH);
        
    
        updateAccountTable();
        AddAccountButton.addActionListener(this); // Add an action listener to the button
        RemoveAccountButton.addActionListener(this); // Add an action listener to the button
        LogoutButton.addActionListener(this); // Add an action listener to the button


        add(JTablepanel);
        add(adminImageLabel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == AddAccountButton) {
            addAccount();
        } else if (e.getSource() == RemoveAccountButton) {
            removeAccount();
        }  else if (e.getSource() == LogoutButton) {
            // Handle LogoutButton click
            dispose(); // Close the current AdminDashboard frame
            new Login(); // Open the Login frame
        }  
        
        }
        
        
        private void addAccount() {
        // Prompt the admin for new account details
        String name = JOptionPane.showInputDialog(this, "Enter the new account's name:", "Add Account", JOptionPane.PLAIN_MESSAGE);
        String password = JOptionPane.showInputDialog(this, "Enter the new account's password:", "Add Account", JOptionPane.PLAIN_MESSAGE);
    adminAccount.addAccount(name, password);

    // Refresh the table with updated account information
    updateAccountTable();
    }
    
    
    private void removeAccount() {
    // Prompt the admin for the account number to remove
    String accNumStr = JOptionPane.showInputDialog(this, "Enter the account number to remove:", "Remove Account", JOptionPane.PLAIN_MESSAGE);

    try {
        int accNum = Integer.parseInt(accNumStr);

        // Delete the account
        adminAccount.deleteAccount(accNum);

        // Refresh the table with updated account information
        updateAccountTable();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid account number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void updateAccountTable() {
    // Clear existing rows
    DefaultTableModel tableModel = (DefaultTableModel) recentTransactionsTable.getModel();
    tableModel.setRowCount(0);

    // Load and display the updated account information
    ArrayList<String[]> accountList = adminAccount.readAccount();
    for (String[] account : accountList) {
        tableModel.addRow(account);
    }
}

     private JPanel createRoundedPanel(Color bgColor) {
        return new RoundedPanel(bgColor);
    }


    public static void main(String[] args) {
        // Create an instance of AdminDashboard
        SwingUtilities.invokeLater(() -> new AdminDashboard());
    }
}