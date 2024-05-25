package OIBSIP;

import java.util.Scanner;

/**
 *
 * @author Rajakta Bindoriya
 */
public class Task3_ATMInterface 
{
    String name;
    String pin;
    String acNo;
    float balance = 100000;
    String transHistory="";
    int trans = 0;
    
    
    Scanner sc = new Scanner(System.in);
    void register()
    {
        
        
        System.out.print("\nEnter Your name:");
        name = sc.nextLine();
        
        System.out.print("Enter Your Account number:");
        acNo = sc.nextLine();
        
        System.out.print("Generate your 4 digit pin:");
        pin = sc.nextLine();
        
        System.out.println("\n\n........Registered succesfully........");
        
    }
    
    boolean login()
    {
        boolean isLogin = false;
        while(!isLogin)
        {
            System.out.print("\nEnter your Account Number: ");
            String acNum = sc.nextLine();

            System.out.print("Enter your 4 digit Pin: ");
            String userPin = sc.nextLine();

            if(acNum.equals(acNo) && userPin.equalsIgnoreCase(pin))
            {
                System.out.println("\n\t....... Login successful !!! .......");
                isLogin = true;
                break;
            }
            else
            {
                System.out.println("\nIncorrect Account Number or Password....!");
                System.out.println("\nPlease try again...");
            }
        }
        return isLogin;
        
    }
    void balanceEnquiry()
    {
        System.out.println("__Available amount = "+balance+"__");
    }
    
    void transactionHistory()
    {        
        if(trans == 0)
        {
            System.out.println("\n\t\t You have 0 transactions");
        }
        else
        {
            System.out.println("\nYou have made "+trans+" Transactions");
            System.out.println("\n" + transHistory);
        }
    }
    
    void withdraw()
    {
        System.out.print("\nEnter the Amount you want to withdraw: ");
        float wAmount = sc.nextFloat();
        
        if(balance != 0 && wAmount <= balance-1000)
        {
            trans++;
            balance = balance - wAmount;
            System.out.println("\n..... "+wAmount+" Rs Withdrawn Successfully!.....");
            String str = wAmount + "Rs Withdrawed\n";
            transHistory = transHistory.concat(str);
        }
        else
        {
            System.out.println("\n\nYou don't have sufficient balance to make this widthdrawal.");
            System.out.print("\n\nIf you ant to check balance enter (yes/no):");
            
            String input = sc.next();
            if(input.equals("yes"))
                System.out.println("\n\t\tAvailable amount = "+balance);

            
        }
            
    }
    
    void deposit()
    {
        System.out.print("\nEnter the amount you want to Deposit:");
        float depAmount = sc.nextFloat();
        
        if( depAmount <=10000000)
        {
            trans++;
            balance += depAmount;
            System.out.println("\n..... "+depAmount+" Rs. Deposited Successfully!.....");
            
            String str = depAmount + " Rs. Deposited\n";
            transHistory = transHistory.concat(str);
            
        }
        else
            System.out.println("\nOops...You exceeds the limit !!");
    }
    
    void transfer()
    {
        System.out.print("\nEnter the Receipent's a/c no.: ");
        
        String rAcNo = sc.next();
        
        System.out.print("\nEnter the Amount you want to tranfer:");
        float transAmount = sc.nextFloat();
        if(balance > 1000)
        {
            if(transAmount!=0){
                

                if( transAmount<=25000)
                {
                    trans++;
                    balance = balance - transAmount;
                    System.out.println("\n.... "+transAmount+" Rs. Transfered Successfully to Account Number "+rAcNo+" ....");

                    String str = transAmount + "Rs Transfered to a/c no. "+rAcNo+"\n";

                    transHistory = transHistory.concat(str);
                }
                else
                    System.out.println("\n Oops...Limit is 25000 rs only.");
            }
            else
                System.out.println("*** You must enter the Amount greater than zero ***");
        }
        else
            System.out.println("\nYou don't have sufficient balance for this Transfer!!!");


    }
    
    void quit()
    {
        System.out.println("\n\n\n\t\t\t/////// Thank you for visiting ///////");
        System.out.println("\n\n\t\t\t//////////  Visit Again ///////////");
        System.exit(0);
    }
    
    public static void main(String args[])
    {
        Task3_ATMInterface atm = new Task3_ATMInterface();
        
        System.out.println("\t\t\t//////// Welcome To ATM ////////");
        System.out.println("\nEnter (1 or 2 or 3) to\n 1 Register\n 2 Exit ");
        
        System.out.print("\nEnter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        if(choice == 1)
        {
            atm.register();
            while(true)
            {
                System.out.print("\nNow, Enter (1 or 2) to\n 1.Login\n 2.Exit\nEnter your choice(1 or 2 ): ");
                int ch = sc.nextInt();
                if(ch == 1)
                {
                    atm.login();
                
                    System.out.println("\n///  Welcome "+atm.name +" ///");
                    boolean isFinished = false;
                    while (!isFinished) 
                    {
                        System.out.println("\n1.Transaction History  \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Quit");

                        System.out.print("\nEnter your choice: ");
                        int c = sc.nextInt();

                        switch(c)
                        {
                            case 1: atm.transactionHistory();
                                    break;
                            case 2: atm.withdraw();
                                    break;
                            case 3: atm.deposit();
                                    break;
                            case 4: atm.transfer();
                                    break;
                            case 5: isFinished = true;
                                    break;
                            default: System.out.println("\n***** Invalid input. Please enter valid input. *****");
                        }
                    
                    }
                }
                else
                    atm.quit();
                    
            }
        }  
        else if(choice == 2)
        {
            atm.quit();
        }
        else
        {
            System.out.println("\n***** Invalid input. Please enter your choice 1, 2 or 3. *****");
        }
    }
}
