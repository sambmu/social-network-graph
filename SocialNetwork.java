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

public class SocialNetwork {
    UndirectedGraph<Profile> socialNet;
    DictionaryInterface<String, Profile> profileList;

    public SocialNetwork() {

         profileList = new LinkedDictionary<>();
         socialNet = new UndirectedGraph<>();
    }




    public void setSampleUsers(){

         Profile S1 = new Profile("Joe", "Online");

         Profile S2 = new Profile("Samar", "Online");

         Profile S3 = new Profile("Lewandowski", "Offine");


        socialNet.addVertex(S1);
        socialNet.addVertex(S2);
        socialNet.addVertex(S3);

        socialNet.addEdge(S1,S2);
        socialNet.addEdge(S2,S3);
        socialNet.addEdge(S1,S3);

        profileList.add("Joe", S1);
        profileList.add("Samar", S2);
        profileList.add("Lewandowski", S3);
    }


    public void makeAccount( Profile user){
        Scanner temp = new Scanner(System.in);
        System.out.println("Please enter your name:  " );
        String newName = temp.nextLine().trim();
        System.out.println("Set account status. " +
                "Enter 1 for Online, 2 for Offline, or 3 for Busy:");
        int sel = temp.nextInt();

        if (sel == 1) {

            Profile newProfile = new Profile(newName, "Online");
            user = newProfile;
            socialNet.addVertex(user);
            profileList.add(newName, user);
            System.out.println("New account created!");

        }
        else if (sel == 2) {
            Profile newProfile = new Profile(newName, "Offline");
            user = newProfile;

            System.out.println("New account created!");
            socialNet.addVertex(user);
            profileList.add(newName, user);
        }
        else if (sel == 3) {
            Profile newProfile = new Profile(newName, "Busy");
            user = newProfile;

            System.out.println("New account created!");
            socialNet.addVertex(user);
            profileList.add(newName, user);
        }else {
            System.out.println("Please enter the appropriate answer! :");
        }

        System.out.println(" ");



    }
    public void searchAccount() {

        Scanner temp = new Scanner(System.in);
        System.out.println("Please enter the account name:  ");
        String newName = temp.nextLine();

        boolean found = false;

        if(profileList.contains(newName)) {
            System.out.println("Found the user name : " + newName);
            found = true;
        }

        //Fail to find the account
        if(!found) {
            System.out.println("Account can't be found");
        }



        System.out.println(" ");
    }

    public void updateAccount (Profile user){

            Scanner choice = new Scanner(System.in);

            System.out.println("What do you want to change?");
            System.out.println("1. Updating Profile");
            System.out.println("2. Adding Friends");
            System.out.println("3. Display Friends and Contacts");
            System.out.println("4. Remove Friend");
            int answer = choice.nextInt();

            if(answer == 1) {
                updateProfile(user);
            }else if(answer == 2) {

                System.out.println("You can search the account to find friends!");


                Scanner temp = new Scanner(System.in);
                System.out.println("Please enter the friend name:  " );
                String newName = temp.nextLine();



                if(!profileList.contains(newName)) {
                    System.out.println(newName + " does not exist.");

                }
                else {
                    socialNet.addEdge(profileList.getValue(newName), user);
                    System.out.println(newName + " is added to your friend list");

                }

            }


            else if (answer == 3) {
                Scanner temp = new Scanner(System.in);
                System.out.println("Please enter the name of the account:  " );
                String newName = temp.nextLine();
                socialNet.getEdges(profileList.getValue(newName));
            }



            else if (answer == 4) {
            Scanner temp = new Scanner(System.in);
            System.out.println("Please enter the name of the friend:  " );
            String newName = temp.nextLine();
            if(profileList.contains(newName)) {
                profileList.remove(newName);
                socialNet.removeEdge(user, profileList.getValue(newName));

                System.out.println(newName + " is removed from your friend list");

            }
        }

            else {
                System.out.println("Not a vaild Input!");
            }



        }
    public void updateProfile(Profile user){
        Scanner choice = new Scanner(System.in);

        // Changing the name
        System.out.println("Enter your name: ");
        String oldName = choice.nextLine();
        System.out.println("Update your name: ");
        String newName = choice.nextLine();
        user.setName(newName);
        profileList.remove(oldName);
        profileList.add(newName, user);

        //Changing the status
        System.out.println("Choice for the status: Online(1), Offline(2), Busy(Any other key)");
        int statusChoice = choice.nextInt();

        if(statusChoice == 1) {
            user.setStatusOnline();
        }else if(statusChoice == 2) {
            user.setStatusOffline();
        }else {
            user.setStatusBusy();
        }

        System.out.println("Your name is "+ user.getName() +" now! and "+ user.getStatus());
    }




}







