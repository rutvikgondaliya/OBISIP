package com.rutvik.gondaliya.OBISIP_Task3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args)   //Main Method. The execution starts from this method
    {

        String accountName = "Rutvik Gondaliya";    //Declaring the account details
        String branchName = "Ahmedabad";
        String branchAddress = "VGEC, near visat new CG road, 382424";
        String branchIFSC = "RUT0000782";

        int accountNo = 123123123;
        int password = 1234;
        int balance = 0;

        boolean flag = true;

        int paper = 0;
        int attempt = 5;
        int currattempt = 0;

        LocalDate dateToday = LocalDate.now();  // Declaring the date format
        String dateStr = dateToday.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

        LocalTime currentTime = LocalTime.now();    // Declaring the time format
        String timeStr = currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        ArrayList<String> transaction = new ArrayList<String>();     // Declaring a new array

        Scanner sc = new Scanner(System.in);                // Importing the scanner class

        while(currattempt<attempt)               // Limiting the number of attempts for entering correct password
        {
            System.out.println("Enter your pin");
            int pass = sc.nextInt();
            if(pass==password)                // Checking if entered pin is same as the acccount pin
            {
                System.out.println("Do you want paper receipt");   // Asking if user wants to print receipt
                System.out.println("1. Yes");
                System.out.println("2. No");
                paper = sc.nextInt();
                break;
            }
            else
                System.out.println("You have entered wrong pin");
            currattempt = currattempt + 1;
        }


        if(currattempt<5)     // Executing the main task if users enters correct password within limited attempts
        {
            while(flag)
            {
                System.out.println("********************************");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.println("6. Change Password");

                System.out.println("What would to like to do today");
                int option = sc.nextInt();

                switch(option)
                {
                    case 1:       // Option for transaction history
                    {
                        System.out.println("Your Transaction History");
                        for(String q: transaction)
                        {
                            System.out.println(q);
                        }
                        break;
                    }



                    case 2:     // Option for withdrawal
                    {
                        while(true)
                        {
                            System.out.println("Enter the withdrawal amount");
                            int withdraw = sc.nextInt();
                            if((withdraw % 10) ==0)
                            {
                                if(withdraw <= balance)
                                {
                                    if((balance - withdraw) <1000)
                                    {
                                        System.out.println("Minimum balance has to Rs 1000");
                                    }
                                    else
                                    {
                                        balance = balance - withdraw;
                                        String str1 = String.format("You have successfully withdrawl Rs %d",withdraw);
                                        String str2 = String.format("Your balance is Rs %d", balance);
                                        System.out.println(str1);
                                        System.out.println(str2);

                                        String withdrawalStr = String.format("Withdrawl - Rs %d", withdraw);
                                        transaction.add(withdrawalStr);
                                        break;
                                    }

                                }
                                else
                                {
                                    System.out.println("Insufficient balance");
                                }
                            }
                            else
                                System.out.println("Enter the withdraw amount in multiples of 100");
                        }


                        break;
                    }



                    case 3:           // Option for deposit
                    {
                        while(true)
                        {
                            System.out.println("Enter the deposit amount");
                            int deposit = sc.nextInt();
                            if((deposit%10)==0)
                            {
                                balance = balance + deposit;
                                String str1 = String.format("You have successfully deposited Rs %d", deposit);
                                String str2 = String.format("Your balance is Rs %d", balance);
                                System.out.println(str1);
                                System.out.println(str2);

                                String depositStr = String.format("Deposit - Rs %d", deposit);
                                transaction.add(depositStr);

                                break;
                            }
                            else
                            {
                                System.out.println("Enter the amount in multiples of 100");
                            }
                        }

                        break;
                    }



                    case 4:      // Option for transfer
                    {
                        while(true)
                        {
                            System.out.println("Enter the account number of the beneficiary");
                            int account = sc.nextInt();
                            System.out.println("Enter the IFSC code of the bank of the beneficiary");
                            String ifsc = sc.next();
                            System.out.println(account);
                            System.out.println("Please confirm the account number of the beneficiary");
                            System.out.println("1. Correct");
                            System.out.println("2. Incorrect");
                            int conform = sc.nextInt();
                            if(conform==1)
                            {
                                System.out.println("Enter the amount you want to transfer");
                                int transferAmount = sc.nextInt();
                                if((transferAmount % 10) ==0)
                                {
                                    if(transferAmount <= balance)
                                    {
                                        if((balance - transferAmount) <1000)
                                        {
                                            System.out.println("Minimum balance has to Rs 1000");
                                        }
                                        else
                                        {
                                            balance = balance - transferAmount;
                                            String sf2 = String.format("You have successfully transferred Rs %d to %d",transferAmount,account);
                                            String sf3 = String.format("Your balance is Rs %d", balance);
                                            System.out.println(sf2);
                                            System.out.println(sf3);

                                            String transferStr = String.format("Transfer - Rs %d", transferAmount);
                                            transaction.add(transferStr);
                                            break;
                                        }

                                    }
                                    else
                                    {
                                        System.out.println("Insufficient balance");
                                    }
                                }
                                else
                                    System.out.println("Enter the amount in multiple of 100");
                            }
                            else
                                System.out.println("You entered incorrect account number");
                        }

                        break;
                    }



                    case 5:          // Option to end
                    {
                        System.out.println("Thank you for banking with us");
                        flag = false;
                        break;
                    }


                    case 6:          // Option for changing pin
                    {
                        System.out.println("Enter your new pin");
                        int newpin = sc.nextInt();
                        password = newpin;
                        System.out.println("Do not share your pin with anyone");
                        System.out.println("You have successfully changed your password");
                        transaction.add("Changed Password");
                    }


                    default:
                        System.out.println("Please select an appropriate option");
                        break;
                }

                System.out.println("Would you like to do another transaction");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int df = sc.nextInt();
                if(df==1)
                    flag = true;
                else
                    flag = false;

            }
            if(paper==1)
            {
                String str1 = String.format("Date: %s", dateStr);       // Printing the receipt
                String str2 = String.format("Time: %s", timeStr);
                String str9 = String.format("%s     %s", LocalDate.now().toString(), LocalTime.now().toString());
                String str3 = String.format("Account Holder Name: %s", accountName);
                String str4 = String.format("Branch Name: %s", branchName);
                String str5 = String.format("Branch Address: %s", branchAddress);
                String str6 = String.format("Branch IFSC code: %s", branchIFSC);
                String str7 = String.format("Account Number: %d", accountNo);
                String str8 = String.format("Your account balance is Rs %d", balance);
                System.out.println(str1);
                System.out.println(str2);
                System.out.println(str9);
                System.out.println(str3);
                System.out.println(str4);
                System.out.println(str5);
                System.out.println(str6);
                System.out.println(str7);
                System.out.println(str8);

            }
            System.out.println("Thank you for banking with us");
        }
        else
        {
            System.out.println("You have entered wrong pin multiple times");
        }

    }

}
