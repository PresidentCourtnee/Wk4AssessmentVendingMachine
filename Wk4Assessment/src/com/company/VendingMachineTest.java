//Week 4 Final Assessment
//PRG451 - Object Oriented Programming II
//Courtnee Sullivan
//Jerrie Pineda
//8/13/2020
//This is my test class for my vending machine
package com.company;
import java.util.Random;

public class VendingMachineTest
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        VendingMachine vm1 = new VendingMachine();

        Random rand = new Random();

        for (int i = 0; i < 2; i++)
        {

            System.out.println("Test " + i);
            int options = rand.nextInt(3);
            int coins = 25;//rand.nextInt(26);
            int bills = 1;//rand.nextInt(6);

            vm1.payment(options, coins, bills);
            vm1.display();
        }
    }

}
