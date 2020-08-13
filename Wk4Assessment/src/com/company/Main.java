//Week 4 Final Assessment
//PRG451 - Object Oriented Programming II
//Courtnee Sullivan
//Jerrie Pineda
//8/13/2020
//This is my Vending Machine Class
package com.company;
import java.util.Scanner;

class VendingMachine
{
    static Scanner input = new Scanner(System.in);
    static int balance = 0, product, coins, bills, total = 0, change = 0, options;

    // This will be used for testing
    public static void payment(int opt, int coin, int bill)
    {
      System.out.println("\nPlease select the payment method.");
        do
        {
            // This is the money options
            System.out.println("0. Stop Enter Money");
            System.out.println("1. Enter coins");
            System.out.println("2. Enter bills");
            options = opt;

            if (options == 0)
            {
                break;
            }
            //Because the Vending Machine accepts coins
            else if (options == 1)
            {
                System.out.println("Enter coins");
                System.out.print(coin);
                do
                    {
                    coins = coin;
                    switch (coins)
                    {
                        case 0:
                            break;
                        case 1: // for pennies
                            total += 1;
                            break;
                        case 5: // for nickles
                            total += 5;
                            break;
                        case 10: // for dimes
                            total += 10;
                            break;
                        case 25: // for quarters
                            total += 25;
                            break;
                        default:
                            System.out.println("Invalid Coins, Please enter the new coins");
                    }
                } while (coins != 0);
                //For bills
            } else if (options == 2) {
                // I will be using 2 for bills
                // 1 dollar bills, and 5 dollar bills, I could expand to using hire bills then this but for this
                //project I will stick with this.
                System.out.println("Enter bills");
                System.out.print(bill);
                do
                {
                    bills = bill;
                    // enter bills
                    switch (bills)
                    {
                        case 0:
                            break;
                        case 1: // for $1 dollar bill
                            total += 100;
                            break;
                        case 5: // for $5 dollar
                            total += 500;
                            break;
                        default:
                            System.out.println("Invalid Bills, Please enter the new bills");
                    }
                }
                while (bills != 0);
            }
            else
            {
                System.out.println("Invalid Options");
            }
        }
        while (options != 0);
    }

    public static void payment()
    {// This beings the payment options
        System.out.println("\nPlease select the payment method.");
        do
        {
            // this is for the different money options
            System.out.println("0. Stop Enter Money");
            System.out.println("1. Enter coins");
            System.out.println("2. Enter bills");
            options = input.nextInt();


            if (options == 0)
            {
                break;
            }
            // The vending machine accepts coins,
            else if (options == 1) { // 1 for coins
                System.out.println("Enter coins");
                do
                {
                    coins = input.nextInt();
                    // enter coins
                    switch (coins)
                    {
                        case 0:
                            break;
                        case 1: // penny
                            total += 1;
                            break;
                        case 5: // nickle
                            total += 5;
                            break;
                        case 10: // dime
                            total += 10;
                            break;
                        case 25: // quarter
                            total += 25;
                            break;
                        default:
                            System.out
                                    .println("Invalid Coins, Please enter the new coins");
                    }
                }
                while (coins != 0);
            }
            else if (options == 2) {// 2 for bills
                // 1 dollar bills, and 5 dollar bills
                System.out.println("Enter bills");

                do
                {
                    bills = input.nextInt();
                    // enter bills
                    switch (bills)
                    {
                        case 0:
                            break;
                        case 1: // 1 dollar
                            total += 100;
                            break;
                        case 5: // 5 dollar
                            total += 500;
                            break;
                        default:
                            System.out
                                    .println("Invalid Bills, Please enter the new bills");
                    }
                }
                while (bills != 0);
            }
            else
            {
                System.out.println("Invalid Options");
            }
        }
        while (options != 0);

        // This ends the payment options
    }

    public static void purchase()
    {
        // This starts the PURCHASE
        //This will ask the user to make a product selection
        System.out.println("Please select your product.");

        product = input.nextInt();

        switch (product)
        {
            case 0:
                balance += 0;
                break;
            case 1:
                balance += 36;
                break;
            case 2:
                balance += 45;
                break;
            case 3:
                balance += 55;
                break;
            case 4:
                balance += 125;
                break;
            case 5:
                balance += 150;
                break;
            default:
                System.out.println("Invalid Products");
        }

        // This is the end of the PURCHASE
    }

    public static String calCoins(int changes)
            //This will be used for the change/Coins calculations
    {
        String changeString = "";
        int quarters, remQuarters = 0;
        int dimes, remDimes = 0;
        int nickles, remNickles = 0;
        int pennies = 0;

        quarters = change / 25;
        remQuarters = change % 25;
        changeString += quarters + " quarters\n";

        if (remQuarters != 0)
        {
            dimes = remQuarters / 10;
            remDimes = remQuarters % 10;
            changeString += dimes + " dimes\n";
        }

        if (remDimes != 0)
        {
            nickles = remDimes / 5;
            remNickles = remDimes % 5;
            changeString += nickles + " nickles\n";
        }

        if (remNickles != 0)
        {
            pennies = remNickles;
            changeString += pennies + " pennies\n";
        }
        return changeString;
    }

    public static String change()
    {
        // This starts the change output
        String changeDisplay = "";
        if (total > balance)
        {
            //This will calculate the coins/change
            change = total - balance;
            changeDisplay = calCoins(change);
        }
        else
        {
            changeDisplay = "Enter more money";
        }

        return changeDisplay;
        // This is the end of the Coin/Change Calculations

    }

    public static void display()
    {
        // This is where I start the display
        System.out.println("BALANCE : " + balance);
        System.out.println("TOTAL MONEY : " + total);
        System.out.println("CHANGE :\n " + change());
        //This is the end of my display
    }

    public static void main(String[] args)
    {
        System.out.println("HELLO Customer!");
        // My vending machine will only offers 5 products
        System.out.println("0. Get money back");
        System.out.println("1. Smarties\t$.50");
        System.out.println("2. Twislers\t\t$1.25");
        System.out.println("3. M&M\t$1.00");
        System.out.println("4. Butterfinger\t\t$1.55");
        System.out.println("5. King Size Snicker\t$1.75");

        // This will call my payment
        payment();
        // This will call my purchase
        purchase();
        //This will call my change
        change();
        //This will call my display
        display();
    }
}
