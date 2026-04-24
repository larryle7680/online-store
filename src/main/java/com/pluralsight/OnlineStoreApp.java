package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public void displayProduct(){

    }//END OF displayProduct METHOD
    public ArrayList<Product> getInventory(){
        //Made an empty array list to hold our products
        ArrayList<Product> inventory = new ArrayList<Product>();

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

        } catch (Exception e) {
            System.out.println("Could not find that file");
            throw new RuntimeException(e);
        }


    }

}//END OF THE OnlineStoreApp CLASS
