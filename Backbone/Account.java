package Backbone;

import java.io.*;
import java.util.*;

public class Account {
    private int accNum = 0;
    private String name;
    private String password;
    private static Account instance = null;
    private static final String[] ADMIN_USERNAMES = {"Aliah", "Goddess", "Johana"};
    private static final String[] ADMIN_PASSWORDS = {"aliah123", "goddess123", "johana123"};
    
    public Account() 
    {
    // Initialize accNum to the maximum number of existing accounts
    ArrayList<String[]> accList = readAccount();
    int maxAccNum = 0;
    

    for (String[] credentials : accList) {
        int currentAccNum = Integer.parseInt(credentials[0].substring(2)); // Extract the numeric part
        if (currentAccNum > maxAccNum) {
            maxAccNum = currentAccNum;
        }
    }
    
    
    accNum = maxAccNum;
  }
    
    public Account(String name, String password) {
       this.name = name;
       this.password = password;
    }
   
    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
      
 
    //write users in the account
    public void writeAccount(String name, String password){
        try
        {
            accNum++;
            BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt", true));
            
            writer.write("00" + Integer.toString(accNum) + "," + name + "," + password + "\n");
            writer.close();
            
            BudgetOperation budgetOperation = new BudgetOperation();
            //BudgetOperation.createFilesForUser(accNum);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
   
    public ArrayList<String[]> readAccount(){
        ArrayList<String[]> accList = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split the line into parts
                    String[]parts = line.split(",");
                    if (parts.length == 3) {
                        String accNum = parts[0];
                        String name = parts[1];
                        String password = parts[2];


                        accList.add(new String[]{accNum, name, password});

                    }
                }
            }
            catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
            return accList;
    }
        
    public boolean verifyAccount(String inputName, String inputPassword) {
         ArrayList<String[]> accList = readAccount();

            for (String[] credentials : accList) {
                String accNum = credentials[0];
                String username = credentials[1];
                String password = credentials[2];

                if (username.equals(inputName) && password.equals(inputPassword)) {
                    return true; // Username and password match
                }
            }
         return false;
    }
    
    public boolean correctPassword(String inputPassword) {
         ArrayList<String[]> accList = readAccount();

            for (String[] credentials : accList) {
                String accNum = credentials[0];
                String username = credentials[1];
                String password = credentials[2];
                
                if (password.equals(inputPassword)) {
                    return true; // Correct Password
                }
            }
         return false;
    }
    
    public boolean checkAdminExists(String enteredName, String enteredPassword) {
        
        for (int i = 0; i < ADMIN_USERNAMES.length; i++) {
            if (ADMIN_USERNAMES[i].equals(enteredName) && ADMIN_PASSWORDS[i].equals(enteredPassword)) {
                return true; // Credentials match
            }
        }
        return false; // No match found
    }
    
    public void changeName(String currentName, String newName) {
        ArrayList<String[]> accList = readAccount();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", false));
            for (String[] credentials : accList) {
                String accNum = credentials[0];
                String username = credentials[1];
                String password = credentials[2];
                if (username.equals(currentName)) {
                    username = newName; // Change the username
                }
                writer.write(accNum + "," + username + "," + password + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String currentPassword, String newPassword) {
        ArrayList<String[]> accList = readAccount();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", false));
            for (String[] credentials : accList) {
                String accNum = credentials[0];
                String username = credentials[1];
                String password = credentials[2];
                if (password.equals(currentPassword)) {
                    password = newPassword; // Change the username
                }
                writer.write(accNum + "," + username + "," + password + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

     public double readCurrBal() {
          BudgetOperation b = new BudgetOperation();
          double currBal = b.readEducation() + b.readGrocery() + b.readBills() + b.readOthers();
          return currBal; 
      }
                 
      public static Account getInstance() {
           if (instance == null) {
               instance = new Account();
           }
           return instance;
       }
       
     public void eraseContent() {
         String[] txtFiles = {"education.txt", "groceries.txt", "bills and utilities.txt", "others.txt", "recent transactions.txt"};
        
              for (String newTxt : txtFiles) {
                  try {
                      BufferedWriter writer = new BufferedWriter(new FileWriter(newTxt, false));
                      if (newTxt.equals("recent transactions.txt")) {
                          writer.close(); 
                      } else {
                          writer.write("0.0");
                      }
                      writer.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  
              
          } catch (Exception e) {
              e.printStackTrace();
          } 

     }  
     
 }   
 
 public void addAccount(String name, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", true))) {
            accNum++;
            writer.write("00" + Integer.toString(accNum) + "," + name + "," + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an account
    public void deleteAccount(int accNum) {
        ArrayList<String[]> accList = readAccount();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", false))) {
            for (String[] credentials : accList) {
               int accountNumber = Integer.parseInt(credentials[0]);
            if (accountNumber != accNum) {
                // If the account number does not match, write it to the file
                writer.write(credentials[0] + "," + credentials[1] + "," + credentials[2] + "\n");                
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


    
