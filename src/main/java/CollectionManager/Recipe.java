package CollectionManager;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * This class is to collect information to store as a recipe. The class defines three methods,
 * addInstructions, printRecipe, and addNewRecipe. These methods are utilized by the recipeBox to be called when needed.
 * When adding a new recipe, the class calls the ingredient class to receive user input for the recipe details on the 
 * different ingredients. The class compiles this information to store as a new recipe and prints the recipe details when finished.
 * The printRecipe method is used by the recipeBox to print the recipe details when selected by the user. 
 * @author Jeremy Willett
 */

public class Recipe {
	
    String recipeName; //define recipeName as a string. Not set as private as it is called by the recipeBox.
    private int servings; //define servings as an integer.
    private ArrayList<Ingredient> recipeIngredients = new ArrayList(); //initialize an array list for recipe ingredients of type Ingredient. 
    private double totalRecipeCalories = 0.0; //initialize totalRecipeCalories as a double.
    private ArrayList<String> recipeInstructions; //define an array list to store recipe instructions as a string type.
	
    /**
     * 
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) { //mutator method to set a recipe name from a string. 
    this.recipeName = recipeName;
    }
    
    /**
     * 
     * @return the recipeName
     */
    public String getRecipeName() { //accessor method to retrieve recipe name, returns that name.
        return recipeName;
    }
    
    /**
     * 
     * @param servings the servings to set
     */
    public void setServings(int servings) { //mutator method that sets number of servings.
        this.servings = servings;
    }
    
    /**
     * 
     * @return  the servings
     */
    public int getServings() { //accessor method to retrieve serving number, returns that number.
        return servings;
    }
    
    /**
     * 
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) { //mutator method to set the ingredients of a recipe in an array. 
        this.recipeIngredients = recipeIngredients;
    }
    
    /**
     * 
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() { //accessor method to retrieve recipe ingredients, returns the ingredients.
        return recipeIngredients;
    }
    
    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories() { //accessor method to retrieve total calories, returns total calories for recipe.
        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) { //mutator method to set the total calories of a recipe.
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
     * 
     * @param recipeInstructions the instructions to set
     */
    public void setRecipeInstructions(ArrayList<String> recipeInstructions) { //mutator method to set the instructions of a recipe in an array.
        this.recipeInstructions = recipeInstructions;
    }
    
    /**
     * 
     * @return the instructions
     */
    public ArrayList<String> getRecipeInstructions() { //accessor method to retrieve recipe instructions, returns the instructions.
        return recipeInstructions;
    }
    

 //Initial Constructor (creates new object with initialized fields)    
 /**
  * 
  * Constructor for Recipe
  */       
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; 
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
	this.recipeInstructions = new ArrayList<>();
	}
 
 //Overloaded Constructor
/**
 * 
 * Overloads constructor with set data types
 * @param recipeName the recipeName to set
 * @param servings the number of servings to set
 * @param recipeIngredients the ingredients to set
 * @param totalRecipeCalories the total calories to set
 * @param recipeInstructions the instructions for recipe to set
 */
    public Recipe(String recipeName, int servings, 
    	ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories, ArrayList<String> recipeInstructions) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
	this.recipeInstructions = recipeInstructions;
    }
    
 //Add Instructions Method [CUSTOM METHOD]
 /**
  * 
  * Custom method to add instructions to a recipe
  */
    public void addInstructions() {
		
	String instruction = "";	
	boolean addMoreInstructions = true; //set default boolean value to true for use in loop.      
        Scanner scnr = new Scanner(System.in);
		
        do { //do/while loop is used to ensure that the loop executes at least one time.
            System.out.println("Please enter an instruction or type 'end' if you are finished entering instructions: ");
            instruction = scnr.nextLine();
				
                if (instruction.toLowerCase().equals("end")) {              
                    addMoreInstructions = false; //if user enters "end", sets the boolean value to false.
                                                 //sets user input to lower case for comparison so it can be entered any way.
                        break;                     
                    
                } 
		else {
                            recipeInstructions.add(instruction); //adds instructions to the array list.           
                            addMoreInstructions = true; //sets boolean to true to allow continuation.
                }
                        
	} while (addMoreInstructions == true); //the loop continues as long as addMoreInstructions is true.			
	}
	
 //Print Recipe Method
 /**
  * 
  * Custom method to print a selected recipe
  */
    public void printRecipe() { //method to print the complete recipe by calling on stored values from previous methods and user inputs.
         
        double singleServingCalories = totalRecipeCalories / servings; //initialize singleServingCalories as a double and calculate based on total calories and number of servings.
        System.out.println("Recipe: " + getRecipeName()); //call recipeName from list and print.
        System.out.println("Yield: " + getServings() + " servings"); //call the number of servings and print.
        System.out.println("Ingredients: "); 

            for (int i = 0; i < recipeIngredients.size(); i++) {  //For loop to print each ingredient from array list.
                Ingredient currentIngredient = recipeIngredients.get(i);
                String currentIngredientName = currentIngredient.getNameOfIngredient();
                System.out.println(currentIngredientName);
            }
 
	System.out.println("Instructions: ");

            for (int j = 0; j < recipeInstructions.size(); j++) { //For loop to print each instruction from array list.
		String instruction = recipeInstructions.get(j);
		System.out.println((j+1) + ": " + instruction);
            }
                
        System.out.println("Total Calories per serving: " + singleServingCalories); //print calculated singleServingCalories.
}
   
 
 //Create New Recipe Method to Build Recipes Based on User Input
/**
 * 
 * Gets user input for the parameters of a recipe. Calls ingredient class to add ingredients
 * for the recipe. Also adds instructions to the recipe. 
 * @return the new recipe to add to recipeBox
 */
    public Recipe addNewRecipe() {
	totalRecipeCalories = 0.0; //initialize totalRecipeCalories as a double. 	
        ArrayList <Ingredient> recipeIngredients = new ArrayList(); //initialize an array list for recipe ingredients.
		
            boolean addMoreIngredients = true; //set default boolean value to true for use in loop.
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine(); //Get user input to assign recipeName
        
        System.out.println("Please enter the number of servings: ");
        servings = scnr.nextInt(); //Get user integer input to assign servings.
        scnr.nextLine(); //parse the scanner to next line so it does not take the whitespace after the
                         //the previous integer input as the next scnr input requested.
                         
//Do-While loop to add more ingredients. Calls ingredient class to add ingredients until user enters end.        
                
       do {     //do/while loop is used to ensure that the loop executes at least one time.
            System.out.println("Please enter the ingredient name or type 'end' if you are done: ");
            String ingredientName = scnr.nextLine(); //Get user string input to assign ingredient name.
                                                     //nextLine is used to allow for multi-word ingredients (i.e. Baking Soda).
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false; //if user enters "end", sets the boolean value to false.
                                            //sets user input to lower case for comparison so it can be entered any way.
                    break;
            }
            
            else {
                Ingredient tempIngredient = new Ingredient().addIngredient(ingredientName);
                tempIngredient.setNameOfIngredient(ingredientName);
                recipeIngredients.add(tempIngredient); //adds ingredients to the array list.
                addMoreIngredients = true; //sets boolean to true to allow continuation.
            }
        } while (addMoreIngredients == true); //the loop continues as long as addMoreIngredients is true.

//Calculate totalRecipeCalories by adding the total calories from each ingredient.       
        for (int i = 0; i < recipeIngredients.size(); i++) { //iterate through ingredients to get the calories of all ingredients and add them to
                                                             //totalRecipeCalories for use in calculation of calories per serving. 
            Ingredient currentIngredient = recipeIngredients.get(i);
            totalRecipeCalories = totalRecipeCalories + currentIngredient.getTotalCalories();
        }        
        
//Do-While loop to add step by step instructions during the addition of a new recipe.      
        
        String instruction = "";	
	boolean addMoreInstructions = true; //set default boolean value to true for use in loop.
        do { //do/while loop is used to ensure that the loop executes at least one time.
            System.out.println("Please enter an instruction or type 'end' if you are finished entering instructions: ");
            instruction = scnr.nextLine();
				
                if (instruction.toLowerCase().equals("end")) {                
                    addMoreInstructions = false; //if user enters "end", sets the boolean value to false.
                                                 //sets user input to lower case for comparison so it can be entered any way.
                        break;                         
                } 
		else {
                            recipeInstructions.add(instruction); //adds instructions to the array list.      
                            addMoreInstructions = true; //sets boolean to true to allow continuation.
                }
                        
	} while (addMoreInstructions == true); //the loop continues as long as addMoreInstructions is true.
        
                
         
        
    Recipe recipe1 = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories, recipeInstructions); //initilize recipe1 with defined parameters to be printed.
    
    recipe1.printRecipe(); //prints the complete recipe using the recipe method and the printRecipe method from above.
   
    return recipe1; //returns the recipe to be stored when called.
    
    } 

 }