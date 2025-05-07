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

public class DashboardPanel extends JPanel implements ActionListener, ExpensePanelListener {
        private Color color;
        private double educationMoney = 0.00, groceryMoney = 0.00, otherMoney = 0.00, billsMoney = 0.00;
        private DecimalFormat decimalFormat = new DecimalFormat("#.00");
        private JLabel educationLabel;
        private JLabel groceryLabel;
        private JLabel billsLabel;
        private JLabel otherLabel;
        private JLabel totalLabel;
        private JButton othersbutton;
        private JButton educationbutton;
        private JButton grocerybutton;
        private JButton billsbutton;
        private JButton minusEduc;
        private JButton minusBills;
        private JButton minusGrocery;
        private JButton minusOthers;
        private BudgetOperation b;
        private DefaultTableModel tableModel;
        private String name;
        private String password;
        private Account a;

    public DashboardPanel(String name, String password) {
        // Dashboard panel setup code
        this.name = name;
        this.password = password;
        a = new Account(name, password);
        BudgetOperation b = new BudgetOperation();
                 
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(780, 640));
        
                 // dashboard panel background
        
        ImageIcon dashImageIcon = new ImageIcon("dash1bg.png");
        Image dashOriginalImage = dashImageIcon.getImage();
        Image dashScaledImage = dashOriginalImage.getScaledInstance(780, 640, Image.SCALE_SMOOTH);
        ImageIcon dashScaledIcon = new ImageIcon(dashScaledImage);
        //create Jlabel with scaled ImageIcon
        JLabel dashImageLabel = new JLabel(dashScaledIcon);
        dashImageLabel.setHorizontalAlignment(JLabel.CENTER);
        dashImageLabel.setVerticalAlignment(JLabel.CENTER);
                
        //sa education Php label on panel
        JPanel educationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        educationPanel.setBounds(350, 390, 160, 40);
        educationPanel.setPreferredSize(new Dimension(230, 50));
        educationPanel.setBackground(Color.WHITE);
        educationPanel.setOpaque(false);
        
        educationLabel = new JLabel("Php 0.00");
        educationLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
        educationPanel.add(educationLabel);
   
        
        //bills php label ug panel
        JPanel billsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        billsPanel.setBounds(350, 505, 160, 40);
        billsPanel.setPreferredSize(new Dimension(230, 50));
        billsPanel.setBackground(Color.WHITE);
        billsPanel.setOpaque(false);
        
        billsLabel = new JLabel("Php 0.00");
        billsLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
        billsPanel.add(billsLabel);  
             
        //grocery php label on panel
        JPanel groceryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        groceryPanel.setBounds(555, 390, 160, 40);
        groceryPanel.setPreferredSize(new Dimension(230, 50));
        groceryPanel.setBackground(Color.WHITE);
        groceryPanel.setOpaque(false);
        
        groceryLabel = new JLabel("Php 0.00");
        groceryLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
        groceryPanel.add(groceryLabel);
        
         //other php on panel
        JPanel otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        otherPanel.setBounds(555, 505, 160, 40);
        otherPanel.setPreferredSize(new Dimension(230, 50));
        otherPanel.setBackground(Color.WHITE);
        otherPanel.setOpaque(false);
        
        otherLabel = new JLabel("Php 0.00");
        otherLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
        otherPanel.add(otherLabel);    
        
        //total php on panel
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        totalPanel.setBounds(25, 420, 300, 200);
        totalPanel.setPreferredSize(new Dimension(230, 50));
        totalPanel.setOpaque(false);
        
        totalLabel = new JLabel("PHP 0.00");
        totalLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
        totalLabel.setForeground(new Color(0x1E3948));
        totalPanel.add(totalLabel);   
        
        //para mo update ika sud balik
        educationMoney = b.readEducation();
        groceryMoney = b.readGrocery();
        billsMoney = b.readBills();
        otherMoney = b.readOthers();
         
        educationLabel.setText("Php " + decimalFormat.format(educationMoney));
        groceryLabel.setText("Php " + decimalFormat.format(groceryMoney));
        billsLabel.setText("Php " + decimalFormat.format(billsMoney));
        otherLabel.setText("Php " + decimalFormat.format(otherMoney));

        // Calculate and update the totalLabel with the sum of all initial values
        double totalAmount = a.readCurrBal(); 
        totalLabel.setText("PHP " + decimalFormat.format(totalAmount));


        //icon image sa education
        ImageIcon iconeducation = new ImageIcon(getClass().getResource("edu.png"));
        JLabel labeleducation = new JLabel( iconeducation);
        labeleducation.setBounds(350, 365,  iconeducation.getIconWidth(),  iconeducation.getIconHeight());
        
        //icon image sa grocery
        ImageIcon icongrocery = new ImageIcon(getClass().getResource("groceries.png"));
        JLabel labelgrocery = new JLabel(icongrocery);
        labelgrocery.setBounds(550, 365, icongrocery.getIconWidth(), icongrocery.getIconHeight());
        
        //icon image sa bills
        ImageIcon iconbills = new ImageIcon(getClass().getResource("utilities.png"));
        JLabel labelbills = new JLabel(iconbills);
        labelbills.setBounds(350, 480, iconbills.getIconWidth(), iconbills.getIconHeight());
        
        //icon image sa others
        ImageIcon iconothers = new ImageIcon(getClass().getResource("other.png"));
        JLabel labelothers = new JLabel(iconothers);
        labelothers.setBounds(550, 480, iconothers.getIconWidth(), iconothers.getIconHeight());
        
        //overall balance label
        String user = a.getName();
        JLabel welcome = new JLabel("Welcome back " + user + ",");
        welcome.setBounds(45, 330, 600, 100);
        welcome.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        welcome.setForeground(new Color(0x1E3948));
        JLabel welcome1 = new JLabel("you have");
        welcome1.setBounds(45, 350, 600, 100);
        welcome1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        welcome1.setForeground(new Color(0x1E3948));
        
        //word sa panels
        JLabel education = new JLabel("Education");
        education.setBounds(380, 330, 600, 100);
        education.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        education.setForeground(new Color(0xFFFFFF));
        
        JLabel bills = new JLabel("Bills &  Utilities");
        bills.setBounds(380, 445, 600, 100);
        bills.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        bills.setForeground(new Color(0xFFFFFF));
        
        JLabel grocery = new JLabel("Grocery");
        grocery.setBounds(585, 330, 600, 100);
        grocery.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        grocery.setForeground(new Color(0xFFFFFF));
           
        JLabel others = new JLabel("Others");
        others.setBounds(585, 445, 600, 100);
        others.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        others.setForeground(new Color(0xFFFFFF));
        
        
        //add button setup
       //add button (education)
        ImageIcon educationIcon = new ImageIcon(getClass().getResource("education.png"));
        educationbutton = new JButton(educationIcon);
        educationbutton.setFocusable(false);
        educationbutton.setBackground(new Color(0x61D68E));
        educationbutton.setBounds(480, 425, educationIcon.getIconWidth(), educationIcon.getIconHeight());
        educationbutton.setBorderPainted(false);
        educationbutton.setFocusable(false);    
       //add button (bill)
        ImageIcon billsIcon = new ImageIcon(getClass().getResource("bills.png"));
        billsbutton = new JButton(billsIcon);
        billsbutton.setFocusable(false);
        billsbutton.setBackground(new Color(0x40BCDC));
        billsbutton.setBounds(480, 537, educationIcon.getIconWidth(), educationIcon.getIconHeight());
        billsbutton.setBorderPainted(false);
        billsbutton.setFocusable(false);
        //add button (grocery)
        ImageIcon groceryIcon = new ImageIcon(getClass().getResource("grocery.png"));
        grocerybutton = new JButton(groceryIcon);
        grocerybutton.setFocusable(false);
        grocerybutton.setBackground(new Color(0xFDDA32));
        grocerybutton.setBounds(685, 425, educationIcon.getIconWidth(), educationIcon.getIconHeight());
        grocerybutton.setBorderPainted(false);
        grocerybutton.setFocusable(false);
         //add button(others)
        ImageIcon othersIcon = new ImageIcon(getClass().getResource("others.png"));
        othersbutton = new JButton(othersIcon);
        othersbutton.setFocusable(false);
        othersbutton.setBackground(new Color(0x145280));
        othersbutton.setBounds(685, 538,educationIcon.getIconWidth(), educationIcon.getIconHeight());
        othersbutton.setBorderPainted(false);
        othersbutton.setFocusable(false);
        
        //minus button setup
       //minus button (education)
        ImageIcon educMinus = new ImageIcon(getClass().getResource("minusEduc.png"));
        minusEduc = new JButton(educMinus);
        minusEduc.setFocusable(false);
        minusEduc.setBackground(new Color(0x61D68E));
        minusEduc.setBounds(337, 422, educMinus.getIconWidth(), educMinus.getIconHeight());
        minusEduc.setBorderPainted(false);
        minusEduc.setFocusable(false);    
       //add button (bill)
        ImageIcon billsMinus = new ImageIcon(getClass().getResource("minusBills.png"));
        minusBills = new JButton(billsMinus);
        minusBills.setFocusable(false);
        minusBills.setBackground(new Color(0x40BCDC));
        minusBills.setBounds(337, 537, billsMinus.getIconWidth(), billsMinus.getIconHeight());
        minusBills.setBorderPainted(false);
        minusBills.setFocusable(false);
        //add button (grocery)
        ImageIcon groceryMinus = new ImageIcon(getClass().getResource("minusGroc.png"));
        minusGrocery = new JButton(groceryMinus);
        minusGrocery.setFocusable(false);
        minusGrocery.setBackground(new Color(0xFDDA32));
        minusGrocery.setBounds(543, 422, groceryMinus.getIconWidth(), groceryMinus.getIconHeight());
        minusGrocery.setBorderPainted(false);
        minusGrocery.setFocusable(false);
         //add button(others)
        ImageIcon othersMinus = new ImageIcon(getClass().getResource("minusOthers.png"));
        minusOthers = new JButton(othersMinus);
        minusOthers.setFocusable(false);
        minusOthers.setBackground(new Color(0x145280));
        minusOthers.setBounds(543, 538, othersMinus.getIconWidth(), othersMinus.getIconHeight());
        minusOthers.setBorderPainted(false);
        minusOthers.setFocusable(false);

        
         //para sa panel pero dapat mo reflect ang ge input nga amount gikan sa textfield
         JPanel boxgreen = createRoundedPanel(new Color(0x61D68E));
         boxgreen.setBackground(new Color(0x61D68E));
         boxgreen.setBounds(331, 358, 190, 100);
         
         JPanel boxyellow = createRoundedPanel(new Color(0xFDDA32));
         boxyellow.setBackground(new Color(0xFDDA32));
         boxyellow.setBounds(536, 358, 190, 100);
         
         JPanel boxblue = createRoundedPanel(new Color(0x40BCDC));
         boxblue.setBackground(new Color(0x40BCDC));
         boxblue.setBounds(331, 471, 190, 100);
         
         JPanel boxdark = createRoundedPanel(new Color(0x145280));
         boxdark.setBackground(new Color(0x145280));
         boxdark.setBounds(536, 471, 190, 100);
        
         //action listener mouse hover
        educationbutton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
        educationbutton.setSize(35, 36);
       }

      @Override
      public void mouseExited(MouseEvent e) {
        educationbutton.setSize(31,30);
      }
   });
   
      billsbutton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        billsbutton.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        billsbutton.setSize(31,30);
      }
   });
   
        grocerybutton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        grocerybutton.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        grocerybutton.setSize(31,30);
      }
   });
   
     othersbutton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        othersbutton.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        othersbutton.setSize(31,30);
      }
   });
   
    minusEduc.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        minusEduc.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        minusEduc.setSize(31,30);
      }
   });
   
      minusBills.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        minusBills.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        minusBills.setSize(31,30);
      }
   });
   
        minusGrocery.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        minusGrocery.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        minusGrocery.setSize(31,30);
      }
   });
   
   minusOthers.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        minusOthers.setSize(35, 36);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        minusOthers.setSize(31,30);
      }
   });


   
   //JTable setup
   JPanel JTablepanel = new JPanel(new FlowLayout());
   JTablepanel.setBackground(new Color(0x1C3A46));
   JTablepanel.setBounds(350, 60, 380, 215);
   
   
   JLabel RecentAct = new JLabel("Recent Activities");
   RecentAct.setBounds(380, 330, 600, 100);
   RecentAct.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
   RecentAct.setForeground(new Color(0xFFFFFF));

   tableModel = new DefaultTableModel();
   tableModel.addColumn("Name");
   tableModel.addColumn("Category");
   tableModel.addColumn("Recent Transaction");
        
   JTable recentTransactionsTable = new JTable(tableModel);
        
   recentTransactionsTable.setPreferredScrollableViewportSize(new Dimension(360, 160));

   // Adjust row height
   recentTransactionsTable.setRowHeight(30);

    // Adjust column widths
    TableColumnModel columnModel = recentTransactionsTable.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(2).setPreferredWidth(150);
            
    JScrollPane scrollPane = new JScrollPane(recentTransactionsTable);
    JTablepanel.add(RecentAct);
    // Create a panel for input components
    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.setPreferredSize(new Dimension(360, 75)); // Set the preferred size

     JTablepanel.add(scrollPane, BorderLayout.CENTER);
     JTablepanel.add(inputPanel, BorderLayout.SOUTH);

      ArrayList<String[]> recentTransactionsData = b.readBal();
        for (String[] transaction : recentTransactionsData) {
            tableModel.addRow(transaction);
        }
   
   
         add(labeleducation);
         add(labelgrocery);
         add(labelbills);
         add(labelothers);
        
         add(welcome);
         add(welcome1);
         add(education);
         add(grocery);
         add(bills);
         add(others);
        
         add(educationbutton);
         add(minusGrocery);
         add(billsbutton);
         add(othersbutton);
        
         add(minusEduc);
         add(grocerybutton);
         add(minusBills);
         add(minusOthers);
    
         add(educationPanel);
         add(groceryPanel);
         add(billsPanel);
         add(otherPanel);
         add(totalPanel);
        
         add(boxgreen);
         add(boxyellow);
         add(boxblue);
         add(boxdark);
        
         add(JTablepanel);
         add(dashImageLabel, BorderLayout.CENTER);
         setVisible(true);

  
        // Add action listener to the "Add Expense" button
        educationbutton.addActionListener(this);
        grocerybutton.addActionListener(this);
        billsbutton.addActionListener(this);
        othersbutton.addActionListener(this);
        minusEduc.addActionListener(this);
        minusGrocery.addActionListener(this);
        minusBills.addActionListener(this);
        minusOthers.addActionListener(this);

        // set panel visible
        setVisible(true);
    }
    
    private JPanel createRoundedPanel(Color bgColor) {
        return new RoundedPanel(bgColor);
    }
    
    //action lister for Jbuttons
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == educationbutton) {
            handleExpenseButtonClick("Education", educationLabel, educationMoney);
        } else if (e.getSource() == grocerybutton) {
            handleExpenseButtonClick("Grocery", groceryLabel, groceryMoney);
        } else if (e.getSource() == billsbutton) {
            handleExpenseButtonClick("Bills", billsLabel, billsMoney);
        } else if (e.getSource() == othersbutton) {
            handleExpenseButtonClick("Others", otherLabel, otherMoney);
        }else if (e.getSource() == minusEduc) {
        handleMinusButtonClick("Education", educationLabel, educationMoney);
        } else if (e.getSource() == minusGrocery) {
            handleMinusButtonClick("Grocery", groceryLabel, groceryMoney);
        } else if (e.getSource() == minusBills) {
            handleMinusButtonClick("Bills", billsLabel, billsMoney);
        } else if (e.getSource() == minusOthers) {
            handleMinusButtonClick("Others", otherLabel, otherMoney);
        }
    }
    
    private void handleExpenseButtonClick(String expenseType, JLabel label, double money) 
    {
      try 
      {
          BudgetOperation b = new BudgetOperation();
          String prompt = JOptionPane.showInputDialog("Enter " + expenseType + " Amount: ");
          double expenseAmount = Double.parseDouble(prompt);
          
          //set values
          String name = "Add Cash";
          b.setNameBal(name);
          b.setBalance(expenseAmount);
          
          if (expenseAmount < 0) {
              JOptionPane.showMessageDialog(null, "Invalid input. Please enter a non-negative amount.");
          } else {
              // Update the instance variable directly
              if (expenseType.equals("Education")) {
                  b.setCategory("Education");
                  b.writeBal(b.getNameBal(), b.getCategory(), b.getBalance());
                  b.readCategory("Education");
                  educationMoney = b.addBalance(expenseAmount);
                  b.writeCategory("Education", educationMoney);
                  label.setText("Php " + decimalFormat.format(b.readEducation()));
    
              } else if (expenseType.equals("Grocery")) {
                  b.setCategory("Grocery");
                  b.writeBal(b.getNameBal(), b.getCategory(), b.getBalance());
                  b.readCategory("Grocery");
                  groceryMoney = b.addBalance(expenseAmount);
                  b.writeCategory("Grocery", groceryMoney);
                  label.setText("Php " + decimalFormat.format(b.readGrocery()));
                  
              } else if (expenseType.equals("Bills")) {
                  b.setCategory("Bills & Utilities");
                  b.writeBal(b.getNameBal(), b.getCategory(), b.getBalance());
                  b.readCategory("Bills & Utilities");
                  billsMoney = b.addBalance(expenseAmount);
                  b.writeCategory("Bills & Utilities", billsMoney);
                  label.setText("Php " + decimalFormat.format(b.readBills()));
              } else if (expenseType.equals("Others")) {
                  b.setCategory("Others");
                  b.writeBal(b.getNameBal(), b.getCategory(), b.getBalance());
                  b.readCategory("Others");
                  otherMoney = b.addBalance(expenseAmount);
                  b.writeCategory("Others", otherMoney);
                  label.setText("Php " + decimalFormat.format(b.readOthers()));            }
  
              // Update the totalLabel with the sum of all expenses
              double totalAmount = a.readCurrBal();
              totalLabel.setText("PHP " + decimalFormat.format(totalAmount));
              
              addTransaction(name, expenseType, expenseAmount);
          }
      } catch (NumberFormatException exc) {
          JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");
      }
    }
 
    private void handleMinusButtonClick(String expenseType, JLabel label, double money) 
    {
    try {
        BudgetOperation b = new BudgetOperation();
        String prompt1 = JOptionPane.showInputDialog("Enter " + expenseType + " Amount to Subtract: ");
        double expenseAmount = Double.parseDouble(prompt1);
        
        //set values
        String name = "Add Expense";
        b.setNameBal(name);
        b.setBalance(expenseAmount);
        
        if (expenseAmount < 0) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a non-negative amount.");
        } else {
            // Update the instance variable directly
            if (expenseType.equals("Education")) {
                b.setCategory("Education");
                b.writeBal(b.getNameBal(), b.getCategory(), b.getExpense());
                b.readCategory("Education");
                educationMoney = b.addExpense(expenseAmount);
                b.writeCategory("Education", educationMoney);
                label.setText("Php " + decimalFormat.format(b.readEducation()));
                
                
            } else if (expenseType.equals("Grocery")) {
                b.setCategory("Grocery");
                b.writeBal(b.getNameBal(), b.getCategory(), b.getExpense());
                b.readCategory("Grocery");
                groceryMoney = b.addExpense(expenseAmount);
                b.writeCategory("Grocery", groceryMoney);
                label.setText("Php " + decimalFormat.format(b.readGrocery()));
                
            } else if (expenseType.equals("Bills")) {
                b.setCategory("Bills & Utilities");
                b.writeBal(b.getNameBal(), b.getCategory(), b.getExpense());
                b.readCategory("Bills & Utilities");
                billsMoney = b.addExpense(expenseAmount);
                b.writeCategory("Bills & Utilities", billsMoney);
                label.setText("Php " + decimalFormat.format(b.readBills()));
            } else if (expenseType.equals("Others")) {
                b.setCategory("Others");
                b.writeBal(b.getNameBal(), b.getCategory(), b.getExpense());
                b.readCategory("Others");
                otherMoney = b.addExpense(expenseAmount);
                b.writeCategory("Others", otherMoney);
                label.setText("Php " + decimalFormat.format(b.readOthers()));            }

            // Update the totalLabel with the sum of all expenses
            double totalAmount = a.readCurrBal();
            totalLabel.setText("PHP " + decimalFormat.format(totalAmount));
            
            addTransaction(name, expenseType, expenseAmount);
        }
      } catch (NumberFormatException exc) {
        System.out.println("Exception occurred: " + exc.getMessage());
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.");    
    }   
  }

  
    public void expenseAdded() {
        // Update the DashboardPanel based on the expense added
        updateLabels();  // Call the method you want to execute in DashboardPanel
    }
     
     public void updateLabels() {
       educationMoney = b.readEducation();
       groceryMoney = b.readGrocery();
       billsMoney = b.readBills();
       otherMoney = b.readOthers();
   
       educationLabel.setText("Php " + decimalFormat.format(educationMoney));
       groceryLabel.setText("Php " + decimalFormat.format(groceryMoney));
       billsLabel.setText("Php " + decimalFormat.format(billsMoney));
       otherLabel.setText("Php " + decimalFormat.format(otherMoney));
   
       // Update the totalLabel
       double totalAmount = a.readCurrBal();
       totalLabel.setText("PHP " + decimalFormat.format(totalAmount));
   
       // Refresh the recent transactions table
       tableModel.setRowCount(0); // Clear existing rows
       loadRecentTransactions();
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