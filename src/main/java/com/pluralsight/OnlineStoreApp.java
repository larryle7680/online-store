package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.*;
public class OnlineStoreApp {
static Scanner theScanner = new Scanner(System.in);
    //Made an empty array list to hold our products
    static ArrayList<Product> inventory = new ArrayList<Product>();
    public static void main(String[] args) {

    //Call the Store menu
        storeMenu();
    }//END OF MAIN METHOD

    public static void storeMenu(){
        ArrayList<Product> inventory = getInventory();

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

    public static void displayProduct(){
    //Import the loaded array into this method
        ArrayList<Product> inventory= getInventory();

        //Prompt the users what options they want
        System.out.println();
        System.out.println("=== Display Menu ===");
        System.out.println();
        System.out.println("1.List all items");
        System.out.println("2.Display Cart");
        System.out.println("Main Menu");
        System.out.println();
        System.out.print("Please choose an option: ");
        int usersChoice = theScanner.nextInt();

        //displaySubMenu while loop/switch statement
        boolean isRunning = false;
        while(!isRunning){
            switch(usersChoice){
                case 1:
                    for(int i = 0; i < inventory.size(); i++){
                        Product p = inventory.get(i);
                        System.out.printf("Name: %s | Price: $%.2f | Department: %s\n",
                                p.getProductName(),p.getProductPrice(),p.getDepartment());
                    }
                    break;
                case 2:
                    System.out.println("CART");
                    break;
                case 3:
                    return;
            }
        }

    }//END OF displayProduct METHOD
    public static ArrayList<Product> getInventory(){


        //Need to something to read the csv
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/product.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            //Need a loop to iterate through the files
            String line;
            while((line = bufReader.readLine()) != null){
                //Make it to an array, so it holds a list of the splits strings
                String[] lineSplit = line.split("\\|");

                //Organize the split stuff into their category
                String nameSplit = lineSplit[0];
                double priceSplit = Double.parseDouble(lineSplit[1]);
                String departmentSplit = lineSplit[2];

                //Add them into an Array
                inventory.add(new Product(nameSplit,priceSplit,departmentSplit));

            }

            //Close the bufReader
            bufReader.close();
        } catch (Exception e) {
            System.out.println("Could not find that file");
            throw new RuntimeException(e);
        }


        //return the inventory
        return inventory;


    }//END OF ArrayList<Product> METHOD

}//END OF THE OnlineStoreApp CLASS
