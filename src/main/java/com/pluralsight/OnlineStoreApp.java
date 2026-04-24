package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        //Initiate storeMenu variables
        boolean isRunning = true;
        while(isRunning){
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


            switch(usersChoice){
                case 1:
                    displayProduct();
                    break;
            }
        }

    }//END OF storeMenu METHOD

    public static void displayProduct(){
    //Import the loaded array into this method
        ArrayList<Product> inventory = getInventory();
        //displaySubMenu while loop/switch statement
        boolean isRunning = false;
        while(!isRunning){
        //Prompt the users what options they want
            System.out.println();
            System.out.println("=== Display Menu ===");
            System.out.println();
            System.out.println("1.List all items");
            System.out.println("2.Search Product");
            System.out.println("3.Add to Cart");
            System.out.println("4.Back to Main Menu");
            System.out.println();
            System.out.print("Please choose an option: ");
            int usersChoice = theScanner.nextInt();



            switch(usersChoice){
                case 1:
                    for (Product p : inventory) {
                        System.out.printf("SKU: %s | Name: %s | Price: $%.2f | Department: %s\n",
                                p.getProductSku(), p.getProductName(), p.getProductPrice(), p.getDepartment());

                    }
                    break;
                case 2:

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
            fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            //Need a loop to iterate through the files
            String line;
            //Skip the Header
            bufReader.readLine();
            while((line = bufReader.readLine()) != null){
                //Make it to an array, so it holds a list of the splits strings
                String[] lineSplit = line.split("\\|");
                //Organize the split stuff into their category
                String skuSplit = lineSplit[0];
                String nameSplit = lineSplit[1];
                double priceSplit = Double.parseDouble(lineSplit[2]);
                String departmentSplit = lineSplit[3];

                //Add them into an Array
                inventory.add(new Product(skuSplit,nameSplit,priceSplit,departmentSplit));

            }
            bufReader.close();

        } catch (Exception e) {
            System.out.println("Could not find that file");
            throw new RuntimeException(e);
        }


        //return the inventory
        return inventory;

    }//END OF ArrayList<Product> METHOD
    public static void searchMenu(){
    //Variable for the searchMenu
        boolean isRunning = false;
        while(!isRunning){
            //Prompt user How they want to search things
            System.out.println();
            System.out.println("What do you want to search your item by?");
            System.out.println();
            System.out.println("1.Search by SKU");
            System.out.println("2.Search by Name");
            System.out.println("3.Search by Price");
            System.out.println("4.Search by Department");
            System.out.println();
            System.out.print("Choose an option: ");
            int usersInput = theScanner.nextInt();

            boolean found = false;
            switch(usersInput){
                case 1:
                    while(!found) {
                        System.out.println("=== Search by SKU ===");
                        System.out.println();
                        System.out.println("Type in item SKU");
                        System.out.println();
                        String searchSku = theScanner.nextLine();

                        //Use a loop to iterate through the object array
                        for (int i = 0; i < inventory.size(); i++) {
                            Product p = inventory.get(i);
                            if (searchSku.equalsIgnoreCase(p.getProductSku())) {
                                System.out.println();
                                System.out.println("Your item SKU matches this item: ");
                                System.out.println(p.getProductName() + " | " + p.getProductPrice());
                            }
                        }
                    }
                    break;
                case 2:
                    while(!found) {
                        System.out.println("=== Search by Name ===");
                        System.out.println();
                        System.out.print("Type in the Item Name");
                        System.out.println();
                        String searchName = theScanner.nextLine();

                        //Use a loop to iterate through the object array
                        for (int i = 0; i < inventory.size(); i++) {
                            Product p = inventory.get(i);
                            if (searchName.equalsIgnoreCase(p.getProductSku())) {
                                System.out.println();
                                System.out.println("Your Item Search Matches this Item: ");
                                System.out.println(p.getProductName() + " | " + p.getProductPrice());
                            }
                        }
                    }
                    break;
                case 3:
                    while(!found){
                        //Prompt users to type in the Range
                        System.out.println("=== Search by Price Range ===");
                        System.out.println();
                        System.out.println("What is Minimum Price?");
                        int minPriceSearch = theScanner.nextInt();
                        System.out.println("What is Maximum Price");
                        int maxPriceSearch = theScanner.nextInt();

                        //Use a loop to iterate through the object array
                        for(int i = 0; i < inventory.size(); i++){
                            Product p = inventory.get(i);
                            if(minPriceSearch <= p.getProductPrice() && maxPriceSearch >= p.getProductPrice()){
                                System.out.println();
                                System.out.println("These are the Items that are within the Price Range: ");
                                System.out.println();
                                System.out.println(p.getProductName() + " | " + p.getProductPrice());
                            }
                        }
                    }
                    break;
                case 4:
                    while(!found){
                        //Prompt users to type in department
                        System.out.println("=== Search by Department ===");
                        System.out.println();
                        System.out.print("Type the Item Department");
                        System.out.println();
                        String searchDepartment = theScanner.nextLine();

                        //Use a loop to iterate through the object array
                        for (int i = 0; i < inventory.size(); i++) {
                            Product p = inventory.get(i);
                            if (searchDepartment.equalsIgnoreCase(p.getDepartment())) {
                                System.out.println();
                                System.out.println("Your Department Searches Matches these Item: ");
                                System.out.println(p.getProductName() + " | " + p.getProductPrice());
                            }
                        }
                    }
                    break;
                case 5:
                    break;

            }

        }
    }

}//END OF THE OnlineStoreApp CLASS
