package com.Catalin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.printf("Enter your choice " );
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }
    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.print("Current item name: ");
        /** By removind the ln from println, Java will not print a line but instead
         * the input will remain on the same line.
         * Enter item number: 2
         */
        String itemNo = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
        /** The -1 was added because humans start the count from 1 not 0 like arrays,
         * This means that if a human enters number 1, it actually wants to access the
         * first position, meaning 0 in the array list. So 1-1 = 0 and the user gets
         * the correct element.
         */
    }
    public static void removeItem(){
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }
    public static void searchForItem(){
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }
    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());
        /** This will add the entire groceryList array to our current array.
         * This can be done with a simple method instead of having to loop through all elements
         * and save them to the new array.
         */

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());
        /** If you already know the array list that you want to copy, you can add it when the new
         * array list is created.
         * The above code will initialize a new array "nextArray" with the elements of groceryList.
         */

        /** You can also convert an arrayList back to a regular array:
         */
        String[] myArray = new String[groceryList.getGroceryList().size()];
        /** This will initialize the new array at the correct size.
         */
        myArray = groceryList.getGroceryList().toArray(myArray);
        /** .toArray will return an object in array format.
         */

    }
}
