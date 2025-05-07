package Backbone;

import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class BudgetOperation extends Budget implements FileIO{
    private String nameBal;
    private String category;
    private double expense;
    private double balance;
    private double totalBal;
    private boolean isAddBal;

    public String getNameBal()
    {
        return nameBal;
    }

    public String getCategory()
    {
        return category;
    }

    public double getExpense()
    {
        return expense;
    }
    public double getBalance()
    {
        return balance;
    }
    
    public double getTotalBal()
    {
        return totalBal;
    }

    public void setNameBal(String nameBal)
    {
       this.nameBal = nameBal;
    }
    
    public void setCategory(String category)
    {
       this.category = category;
    }
    
    public void setExpense(double expense)
    {
       this.expense = expense;
    }
      
    public void setBalance(double balance)
    {
       this.balance = balance;
    }

    public double addBalance(double balance)
    {
        totalBal += balance;
        isAddBal = true;
        
        return totalBal;
    }
    
    public double minusBalance(double balance)
    {
        totalBal -= balance;
        isAddBal = false;
        
        return totalBal;
    }

    public double addExpense(double expense)
    {
        totalBal -= expense;
        isAddBal = false;
                
        return totalBal;
    }
    
        
    //to write data for the recent transaction
    public void writeBal(String nameBal, String category, double money)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("recent transactions.txt", true));
            if(isAddBal) {
                balance = money;
                writer.write(nameBal + "," + category + "," + (String.format("%.2f", balance)) + "\n");
            }
            else {
                expense = money;
                writer.write(nameBal + "," + category + "," + (String.format("%.2f", expense)) + "\n");
            }
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    //read data to display in the table
    public ArrayList<String[]> readBal() {
     ArrayList<String[]> recentTransactions = new ArrayList<>();
       try {
            BufferedReader reader = new BufferedReader(new FileReader("recent transactions.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts 
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String category = parts[1];
                    Double amount = Double.parseDouble(parts[2]);
                    
                
                    recentTransactions.add(new String[]{name, category, amount.toString()});
 
                }
            }
        } 
        catch (IOException | NumberFormatException e) {
            e.printStackTrace(); 
        }
        return recentTransactions;
    }
      //Write the data in each category txt file - johana
      public static void writeCategory(String category, double amount)
      {
         String selectedCategory = "";
         if (category.equals("Education"))
         {
            selectedCategory = "education.txt";  
         }
         else if (category.equals("Grocery"))
         {
            selectedCategory = "groceries.txt"; 
         }
         else if (category.equals("Bills & Utilities"))
         {
            selectedCategory = "bills and utilities.txt"; 
         }
         else if (category.equals("Others"))
         {
            selectedCategory = "others.txt";   
         }

         try
         {
            BufferedWriter writer = new BufferedWriter(new FileWriter(selectedCategory));
            writer.write(Double.toString(amount));
            System.out.println(amount);
            writer.close();
         }
         catch(IOException e)
         {
            e.printStackTrace();
         }
         
      }
    
    //read data from each category txt files and store it in an arraylist
    public void readCategory(String category)
      {
         String selectedCategory = "";
         if (category.equals("Education"))
         {
            selectedCategory = "education.txt";  
         }
         else if (category.equals("Grocery"))
         {
            selectedCategory = "groceries.txt"; 
         }
         else if (category.equals("Bills & Utilities"))
         {
            selectedCategory = "bills and utilities.txt"; 
         }
         else if (category.equals("Others"))

         {
            selectedCategory = "others.txt";   
         }

         try
         {
            BufferedReader reader = new BufferedReader(new FileReader(selectedCategory));
            String content = reader.readLine();
            reader.close();
            this.totalBal = Double.parseDouble(content);
            
         }
         catch (IOException e)
         {
            e.printStackTrace();
         }
         catch (NumberFormatException e)
         {
            e.printStackTrace();
         }


      }
      
      public double readCurrBal() {
         double currBal = readEducation() + readGrocery() + readBills() + readOthers();
         return currBal; 
      }
      
      public double readCatDynamic(String category) {
       readCategory(category);
       return totalBal;
   }
      public double readEducation() {
          readCategory("Education");
         return totalBal;
   }
   
      public double readGrocery() {
            readCategory("Grocery");
           return totalBal;
   }
   public double readBills() {
         readCategory("Bills & Utilities");
         return totalBal;
   }
   
      public double readOthers() {
         readCategory("Others");
         return totalBal;
   }
   
   
}
   