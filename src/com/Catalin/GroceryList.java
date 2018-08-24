package com.Catalin;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers = new int[5];
    private ArrayList<String> groceryList = new ArrayList<String>();
    /** Unlike an array that can hold data types, an array list can hold objects.
     * In the above example we are creating an ArrayList that holds elements of type String.
     * When declaring the new ArrayList, there will be a set of brackets added at the end. The reason
     * for this is that the ArrayList itself is a class meaning that it has a default constructor.
     * Leaving the empty brackets means that the default constructor will be called.
     */
    public void addGroceryItem(String item){
//        myNumbers[5] = 4;
        /**This is how you normally save a value in a particular element.
         * In the case of array lists, this can be done by calling a method inside the ArrayList class.
         */
        groceryList.add(item);
    }

    /** Another way of accessing the array list is by adding a getter here:
     */

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    /** This is how you can print an array list, going through all the elements stored in the list.
     * Normally with an array you would use .length but in this case you can call another Array
     * List method, .size.
     */
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");
        for(int i=0; i< groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
            /** In order to retrieve a certain element from an array list, we can use another built in method, the
             * "get".
             */
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position >= 0) {
            modifyGroceryItem(position, newItem);
        }

    }

    /** This is how you can modify an element in an array list.
     */
    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);

        System.out.println("Grocery item " + (position + 1) + "has been modified.");
        /** The +1 has been added because we start counting from 1 but an array starts from 0.
         */
    }


    /**This is how you remove an item from an array list.
     */
    public void removeGroceryItem(int position){
        groceryList.remove(position);
        /** If we had a list of 3 elements:
         *
         * 0 - Milk
         * 1 - Cheese
         * 2 - Bread
         *
         * If we run the above method with position = 1, this means that the element in position 2, the Cheese
         * will be removed and Bread will take its place:
         *
         * 0 - Milk
         * 1 - Bread
         *
         */
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if(position >= 0){
            removeGroceryItem(position);
        }
    }


//    public String findItem(String searchItem){
//        /** An easy way to query an array list is to use another built in method, the
//         * contains method.
//         * Instead of comparing each element with the searchItem argument, we can let
//         * Java do the work with the built in method.
//         */
////        boolean exists = groceryList.contains(searchItem);
//        /** Another built in method is indexOf, this method will not only look for the
//         * element in the array list but it will also return the index position of that
//         * element in the array list.
//         * If the element is not found in the array, the method will return -1.
//         */
//        int position = groceryList.indexOf(searchItem);
//        if(position >=0){
//            return  groceryList.get(position);
//        }
//        return null;
//    }
    /** Modified method for the 3rd part of the Array lists.
     */
    public int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position >= 0){
            return true;
        }
        return false;
    }
}
