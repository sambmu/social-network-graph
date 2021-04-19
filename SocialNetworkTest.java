/*
 *
 *
 * 	Name: Samar Dange
 * 	Final Part 1
 * ** SOME CODE BORROWED FROM MIDTERM 1 PROJECT**
 * 	Date: March 16th, 2021
 *
 */
package com.company;
import java.util.Scanner;

public class SocialNetworkTest<T>{

    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        SocialNetwork admin = new SocialNetwork();

        Profile user = new Profile(null);

        admin.setSampleUsers();
        int option;


        do
        {
            showChoices();
            option = x.nextInt();
            switch(option)
            {
                case 1:
                {
                    admin.makeAccount(user);

                    break;
                }
                case 2:
                {
                    admin.searchAccount();
                    break;
                }
                case 3:
                {
                    admin.updateAccount(user);
                    break;
                }


                case 0:
                {
                    System.out.println("Thank you for using our network!");
                    System.exit(0);
                }
                default:
                    System.out.println("Please enter an available option");
            }


        } while(option != 0);
    }

    private static void showChoices()
    {
        System.out.print("Please select an action:\n" + " Make a profile 		- 1\n" + " Search for a profile	- 2\n"
                + " Update a profile       - 3\n" + " Log out			    - 0\n" + "\n Enter # -> ");
    }
}