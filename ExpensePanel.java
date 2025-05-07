import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.text.*;
import Backbone.BudgetOperation;
import Backbone.Account;

public class ExpensePanel extends JPanel implements ActionListener {
    private String name;
    private String password;
    private DefaultTableModel tableModel;
    private Account a;
    private BudgetOperation b;
    private ExpensePanelListener expensePanelListener;
    
    public ExpensePanel(String name, String password, ExpensePanelListener listener) {
        b = new BudgetOperation();
        this.name = name;
        this.password = password;
        this.expensePanelListener = listener;
        a = new Account(name, password);       
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(780, 640));

        // Expense panel background
        ImageIcon expenseImageIcon = new ImageIcon("expensebackground.png");
        Image expenseOriginalImage = expenseImageIcon.getImage();
        Image expenseScaledImage = expenseOriginalImage.getScaledInstance(780, 640, Image.SCALE_SMOOTH);
        ImageIcon expenseScaledIcon = new ImageIcon(expenseScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel expenseImageLabel = new JLabel(expenseScaledIcon);
        expenseImageLabel.setHorizontalAlignment(JLabel.CENTER);
        expenseImageLabel.setVerticalAlignment(JLabel.CENTER);

     
 //JTable setup
   JPanel JTablepanel = new JPanel(new FlowLayout());
   JTablepanel.setBackground(new Color(0x1C3A46));
   JTablepanel.setBounds(50, 150, 680, 350);
   
   
   JLabel RecentAct = new JLabel("Recent Activities");
   RecentAct.setBounds(380, 330, 600, 100);
   RecentAct.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
   RecentAct.setForeground(new Color(0xFFFFFF));

   tableModel = new DefaultTableModel();
   tableModel.addColumn("Name");
   tableModel.addColumn("Category");
   tableModel.addColumn("Recent Transaction");
        
   JTable recentTransactionsTable = new JTable(tableModel);
        
   recentTransactionsTable.setPreferredScrollableViewportSize(new Dimension(680, 400));

   // Adjust row height
   recentTransactionsTable.setRowHeight(30);

    // Adjust column widths
    TableColumnModel columnModel = recentTransactionsTable.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(2).setPreferredWidth(250);
            
    JScrollPane scrollPane = new JScrollPane(recentTransactionsTable);
    JTablepanel.add(RecentAct);
    // Create a panel for input components
    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.setPreferredSize(new Dimension(360, 75)); // Set the preferred size

     JTablepanel.add(scrollPane, BorderLayout.CENTER);
     JTablepanel.add(inputPanel, BorderLayout.SOUTH);
     loadRecentTransactions();
     

         ArrayList<String[]> recentTransactionsData = b.readBal();
        for (String[] transaction : recentTransactionsData) {
            tableModel.addRow(transaction);
        }
        
        
  
        add(JTablepanel);
        add(expenseImageLabel, BorderLayout.CENTER);
        setVisible(true);
        
                JTablepanel.revalidate();
        JTablepanel.repaint();

       }  
       
     public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Save Changes")) 
        {
   
        }
    }
    
      private void loadRecentTransactions() {
        BudgetOperation b = new BudgetOperation();
        ArrayList<String[]> recentTransactions = b.readBal();

         for (String[] transaction : recentTransactions) {
           // Assuming the order of elements is [name, category, amount]
           addTransaction(transaction[0], transaction[1], Double.parseDouble(transaction[2]));
    }    
    }

    // Method to add a transaction to the table at the top
    private void addTransaction(String name, String category, Double amount) {
       Vector<Object> row = new Vector<>();
       row.add(name);
       row.add(category);
       if (name.equals("Add Cash")) {
           row.add(String.format("+ %.2f", amount)); 
       } else {
           row.add(String.format("- %.2f", amount));        
       }
   
       // Insert the new row at the beginning of the table
       tableModel.insertRow(0, row);
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
      
}
