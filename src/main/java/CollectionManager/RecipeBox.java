
package CollectionManager;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * RecipeBox is the driving class for the collection manager program.
 * The class takes user input to select an option from the provided menu and executes the selection.
 * The RecipeBox offers the options: add a new recipe, print all recipe details, print all recipe names,
 *                                   delete a recipe from the list, and add instructions to a previously added recipe. 
 * @author Jeremy Willett
*/



public class RecipeBox {
    
    private ArrayList<Recipe> listOfRecipes = new ArrayList<>(); //Initialize a new array list for the listOfRecipes.
    
    /**
     * 
     * @param listOfRecipes the list of recipes to set
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
    
    /**
     * 
     * @return the list of recipes
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }
    
    //Constructors

    /**
     *Constructor for RecipeBox
     */
    
    public void RecipeBox() {
        this.listOfRecipes = listOfRecipes; //construct RecipeBox as a listOfRecipes.
    }
    
    /**
     * Constructor of RecipeBox of an array list of recipes.
     * @param listOfRecipes becomes a RecipeBox containing an array list of recipes.
     */
    public void RecipeBox(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
    
    //User-Defined Methods

    /**
     * Method to print the names of all recipes in the RecipeBox
     */
    
    public void printAllRecipeNames() { //prints all the recipes name currently in the listOfRecipes array list. 
     
        for (Recipe currentRecipe : listOfRecipes) {
            System.out.println(currentRecipe.getRecipeName());
        }
    }
    
    /**
     * Method to print the details of recipe based on user input.
     * @param selectedRecipeName user input from the scanner for the Recipe to print the details of. 
     */
    public void printAllRecipeDetails(String selectedRecipeName) { //iterates through the array list listOfRecipes to print all recipe details for the selectedRecipeName.
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
                listOfRecipes.get(i).printRecipe();
            }  
        }
    }
    
    /**
     *Method to add a new recipe to the recipe box and input all the information from the user by calling the addNewRecipe
     * method from the Recipe class
     */
    public void addNewRecipe() { //calls the recipe class' addNewRecipe method to add a new recipe to the listOfRecipes.
        Recipe tempRecipe2 = new Recipe();
        listOfRecipes.add(tempRecipe2.addNewRecipe());    
        }
    
    //Additional Method for Final Project: Remove a Recipe
    //Accept user input. If user input matches a recipe in listOfRecipes, delete that recipe

    /**
     * Custom Method to delete a recipe from the list of recipes. 
     */
    
    public void deleteRecipe() {
       
        Scanner deleteScnr = new Scanner(System.in); //initiliaze a scanner to get user input for which recipe to delete
        System.out.println("Which recipe?\n"); //prompt user to provide the desires recipe.
        String recipeToDelete = deleteScnr.nextLine(); //initialize recipeToDelete as string based on user input for comparison.
        
        for(int j = 0; j < listOfRecipes.size(); j++) { //for loop to iterate through array list to find a recipeName that matches user input.
            
            if (listOfRecipes.get(j).recipeName.equals(recipeToDelete)) { //compare user input against the recipe array list to find the recipe to be deleted.
                
                listOfRecipes.remove(j); //delete the selected recipe.
                break;
            }
        }
    }
    
    //Custom Method from Recipe class to call addInstructions method.
    //Method iterates through the list to find the selected recipe and then adds instructions to the recipe.

    /**
     * Adds instructions to the selectedRecipeName2 provided by the user input.
     * @param selectedRecipeName2 user input from the scanner for the recipe to add instructions to
     */
    
    public void addInstructionsToRecipe(String selectedRecipeName2) {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName2)) {
                listOfRecipes.get(i).addInstructions();
            }
        }
    }
    
    //Start Menu

    /**
     * Main RecipeBox with menu that calls other classes and methods to perform actions
     * for the user. 
     * @param args an array of command-line arguments for the application 
     */
    
    public static void main(String[] args) {
        
        RecipeBox finalRecipeBox = new RecipeBox(); //Intialize the recipeBox.
        
        Scanner menuScnr = new Scanner(System.in);
        
        /**
         * Print a menu for the user to select one of three menu options.
         */
        
        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" 
                            + "5. Add Instructions to a Recipe\n" + "6. End Program\n" + "\nPlease select a menu item:");
        
            while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
                System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" 
                                     + "5. Add Instructions to a Recipe\n" + "6. End Program\n" + "\nPlease select a menu item:");
                int input = menuScnr.nextInt(); //intilize input as next user inputted integer.
                
                    if (input == 1) { //user input is 1.
                        finalRecipeBox.addNewRecipe(); //addNewRecipe menu selection
                    }
                    
                    else if (input == 2) { //user input is 2.
                        System.out.println("Which recipe?\n"); //prompt user to provide the desires recipe.
                        String selectedRecipeName = menuScnr.next(); //set the user input as the selected recipe to call the printAllRecipeDetails method. 
                        finalRecipeBox.printAllRecipeDetails(selectedRecipeName); //printAllRecipeDetails menu selection.
                    }
                    
                    else if (input == 3) { //user input is 3.
                        for (int j = 0; j < finalRecipeBox.listOfRecipes.size(); j++) { //iterate through the recipeBox's contents until the end.
                        System.out.println((j + 1) + ": " + finalRecipeBox.listOfRecipes.get(j).getRecipeName()); //Start list at 1 and print each recipe name in the finalRecipeBox array list.
                }
                    }
                    
                    else if (input == 4) { //user input is 4.
                        finalRecipeBox.deleteRecipe(); //deleteRecipe menu selection. calls the deleteRecipe method. 
                    }
                    
                    else if (input == 5) { //user input is 5.
                        System.out.println("Which recipe?\n"); //prompt user to provide the desires recipe.
                        String selectedRecipeName2 = menuScnr.next(); //set the user input as the selected recipe to call the addInstructionsToRecipe method.
                        finalRecipeBox.addInstructionsToRecipe(selectedRecipeName2); //addInstructionstoRecipe menu selection.
                    }
                    
                    else if (input == 6) { //user input is 6.
                        System.out.println("The program will now end, Thank you!");
                        return;
                    }
                    
                    else { //reprint menu if a valid selection is not provided.
                        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" 
                                            + "5. Add Instructions to a Recipe\n" + "6. End Program\n" + "\nPlease select a menu item:");
                    }
                    System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" 
                                        + "5. Add Instructions to a Recipe\n" + "6. End Program\n" + "\nPlease select a menu item:");
             }            
                
        }
    
}