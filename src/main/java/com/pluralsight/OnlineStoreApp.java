package com.pluralsight;
import java.util.*;
public class OnlineStoreApp {
static Scanner theScanner = new Scanner(System.in);
    public static void main(String[] args) {


    }//END OF MAIN METHOD

    public static void storeMenu(){
        //Initiate storeMenu variables
        boolean isRunning = false;

        //Display the store Menu and store users choice
        System.out.println();
        System.out.println("=== Store Menu ===");
        System.out.println();
        System.out.println("1. Display Product");
        System.out.println("2. Display Cart");
        System.out.println("3. Close the Application");
        System.out.println();
        System.out.print("Please choose an option: ");
        int usersChoice = theScanner.nextInt();

        while(isRunning){
            switch(usersChoice){
                case 1:
                    displayProduct();
                    break;
            }
        }


    }//END OF storeMenu METHOD

}//END OF THE OnlineStoreApp CLASS
