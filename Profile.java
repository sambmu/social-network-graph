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




public class Profile {

    private String name;
    private String status;



    public Profile(String newName) {
        this.name = newName;
        this.status = "Online";
    }

    public Profile(String newName, String newStatus) {
        this.name = newName;
        this.status = newStatus;
    }


    public void setName(String updateName) {
        this.name = updateName;
    }

    public void setStatusOnline() { this.status = "Online"; }

    public void setStatusOffline() {
        this.status = "Offline";
    }

    public void setStatusBusy() {
        this.status = "Busy";
    }



    public String getName(){
        return name;
    }

    public String getStatus() {
        return status;
    }


}

