package CollectionManager;

import java.util.Scanner;

/**
 * This class takes user input to define an ingredient to be used in a recipe. 
 * The class asks the user for input and validates that the user input matches the expected
 * variable data type. If an invalid input is given, the program exits and must be restarted.
 * If valid inputs are given, the returns the newIngredient for the recipe to use.
 * @author Jeremy Willett
 */

public class Ingredient {

    private String nameOfIngredient;       //nameOfIngredient should use aplhabetical characters for a name.
    private String unitMeasurement;        //Options: Cups, Tbsps, Tsps, or Grams
    double ingredientAmount;               //Number of unitMeasurement Units, decimal number for cases of half or quarter values.
    private int numberCaloriesPerUnit;     //Number of Calories per each unit of unitMeasurement, whole numbers.
    double totalCalories;                  //(Calories Per Unit * Ingredient Amount). Should be double for multiplication 
                                           //and no loss of significant digits. 

    /**
     * @return the nameOfIngredient
     */
    public String getNameOfIngredient() { //accessor method to retrieve the name of the ingredient, returns that name.
        return nameOfIngredient;
    }

    /**
     * @param nameOfIngredient the nameOfIngredient to set
     */
    public void setNameOfIngredient(String nameOfIngredient) { //mutator method to set a ingredient name from a string.
        this.nameOfIngredient = nameOfIngredient;
    }
    
    /**
     * @return the unitMeasurement
     */
    public String getUnitMeasurement() { //accessor method to retrieve the name of the unit of measurement, returns that name.
        return unitMeasurement;
    }
    
    /**
     * @param unitMeasurement the unit of measurement to set
     */
    public void setUnitMeasurement(String unitMeasurement) { //mutator method to set the name of the unit of measurement from a string.
        this.unitMeasurement = unitMeasurement;
    }

    /**
     * @return ingredientAmount
     */
    public double getIngredientAmount() { //accessor method to retrieve amount of ingredient measurement, returns that number.
        return ingredientAmount;
    }
		
    /**
    *@param ingredientAmount the ingredientAmount to set
    */
    public void setIngredientAmount(double ingredientAmount) { //mutator method to set the amount of ingredient measurement from a float input. 
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return the numberCaloriesPerUnit
     */
    public int getNumberCaloriesPerUnit() { //accessor method to retrieve the number of calories per unit measurement, returns that number.
        return numberCaloriesPerUnit;
    }

    /**
     * @param numberCaloriesPerUnit the numberCaloriesPerUnit to set
     */
    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) { //mutator method to set the number of calories per unit measurement from a integer input.
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    /**
     * @return the totalCalories
     */
    public double getTotalCalories() { //accessor method to retrieve the number of total calories, returns that number.
        return totalCalories;
    }
    
    /**
     * @param totalCalories the totalCalories to set
     */
    public void setTotalCalories(double totalCalories) { //mutator method to set the number of total calories from a double input.
        this.totalCalories = totalCalories;
    }
    
    //Initializing Constructor (creates new object with initialized fields).
    /**
     * 
     * Constructor for Ingredient
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.unitMeasurement = "";
	this.ingredientAmount = 0;
        this.numberCaloriesPerUnit = 0;
        this.totalCalories = 0.0;
    }
    
    //Overloaded Constructor
    /**
     * 
     * Overloads constructor with set data types
     * @param nameOfIngredient the ingredient name to set
     * @param unitMeasurement the unit name to set
     * @param ingredientAmount the measurement amount to set
     * @param numberCaloriesPerUnit the calories per unit name to set
     * @param totalCalories  the total calories to set
     */
    public void Ingredient(String nameOfIngredient, String unitMeasurement, 
        double ingredientAmount, int numberCaloriesPerUnit, double totalCalories) {
        this.nameOfIngredient = nameOfIngredient;
        this.unitMeasurement = unitMeasurement;
	this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
        this.totalCalories = totalCalories;
    }
    
    /**
     * 
     * @param tempNameOfIngredient the new ingredient to create
     * @return the newIngredient for use by recipe class
     */
    public Ingredient addIngredient(String tempNameOfIngredient) {
    
        Scanner scnr = new Scanner(System.in);  
    
        Ingredient newIngredient = new Ingredient(); //Creates New Ingredient "newIngredient" of Class "Ingredient"
    //Prompt user for name of ingredient and validate it is an expected alphabetical input, if not exit to retry.
        /*
        System.out.println("Please enter the name of the ingredient: ");
           if(scnr.hasNext("[A-Za-z]*")) { //use scnr to check that user input only contains alphbetical letters.
                nameOfIngredient = scnr.nextLine();
                       //Validating Input: scnr.nextLine is used for ingredients that have multiple names, if only scnr.next()
                       //was used, the program would ignore anything after the first white space. 
                System.out.println("You entered a valid name: " + nameOfIngredient);
            }
           else {
                System.out.println("Please Enter a valid ingredient name!");
                System.exit(0);
            }          //Ask user to enter a valid name and exit program to retry. 
            */

    //Prompt user for unit of measurement and validate it is an expected alphabetical input, if not exit to retry.

        System.out.println("Please Enter the Unit of Measurement for this Ingredient. You have the following options:");
        System.out.println("Cups");
        System.out.println("Tbsps");
        System.out.println("Tsps");
        System.out.println("Grams");

        System.out.println("Type a unit of measurement exactly as it appears in this list above.");

            if (scnr.hasNext("[A-Za-z]*")) { //use scnr to check that user input only contains alphbetical letters.
                unitMeasurement = scnr.next(); //options are only one word, default whitespace rules allow scanner to only copy one word.

                if (!"Grams".equals(unitMeasurement) && !"Cups".equals(unitMeasurement) && !"Tbsps".equals(unitMeasurement) && !"Tsps".equals(unitMeasurement)) {
                    System.out.println("Please enter one of the preceding options.");
                    }   //if input does not match one of the options, ask to re enter.

                else {
                    System.out.println("You have selected " + unitMeasurement);
                    newIngredient.setUnitMeasurement(unitMeasurement); //set the accepted input as the unitMeasurement for the newIngredient.
                    }   //confirm valid input from user.
                }

            else {
                System.out.println("Please enter one of the preceding options.");
                        //if input had was not alphabetical, execute else branch.

                if (scnr.hasNext("[A-Za-z]*")) { //use scnr to check that user input only contains alphbetical letters.
                    unitMeasurement = scnr.next(); //options are only one word, default whitespace rules allow scanner to only copy one word.

                    if (!"Grams".equals(unitMeasurement) && !"Cups".equals(unitMeasurement) && !"Tbsps".equals(unitMeasurement) && !"Tsps".equals(unitMeasurement)) {
                        System.out.println("Unit not recognized. You are out of attempts.");
                        System.exit(0); //exit program if none matching unit was entered on second attempt. 
                    }

                else {
                    System.out.println("You have selected " + unitMeasurement);
                    newIngredient.setUnitMeasurement(unitMeasurement); //set the accepted input as the unitMeasurement for the newIngredient.
                    }   //confirm valid input from user on second attempt.
                }
            }

    //Prompt user for number of units and validate it is within acceptable range and correct value type. If not,
    //exit to retry

        System.out.println("Please enter the number of " + unitMeasurement + " required (between 1 and 1000: )");

            if (scnr.hasNextDouble()) { 
                ingredientAmount = scnr.nextDouble(); 

                if ((ingredientAmount >= 0) && (ingredientAmount <= 1000)) { //compare to see if scanner input is between 0 and 1000
                    System.out.println(ingredientAmount + " is a valid amount."); //confirm valid input from user.
                    newIngredient.setIngredientAmount(ingredientAmount); //set the accepted amount as the ingrdientAmount for the newIngredient.
                }			
                else {
                    System.out.println(ingredientAmount + " is not a valid amount.");
                    System.out.println("Please enter a valid number of units between 1 and 1000: "); //retry input if not successful on first attempt.
                        if (scnr.hasNextDouble()) {
                            ingredientAmount = scnr.nextDouble();

                            if ((ingredientAmount >= 0) && (ingredientAmount <= 1000)) {
                                System.out.println(ingredientAmount + " is a valid amount!"); //confirm valid input from user.
                                newIngredient.setIngredientAmount(ingredientAmount); //set the accepted amount as the ingrdientAmount for the newIngredient.
                            }
                            else if (ingredientAmount < 0) {
                                System.out.println(ingredientAmount + " is less than 0 unit. Sorry, you are out of attempts."); //input less than zero.
                                System.exit(0); //exit program to retry.
                            }
                            else {
                                System.out.println(ingredientAmount + " is greater than 1000 units. Sorry, you are out of attempts."); //input greater than 1000
                                System.exit(0); //exit program to retry.
                            }
                        }       
                }
            }

            else {
                System.out.println("Error: That is not a number. Sorry, you are out of attempts."); //if a number is not entered
                System.exit(0); //exit program to retry.
            }

    //Prompt user for calories per unit and validate it is within acceptable range and correct value type.If not,
    //exit to retry

        System.out.println("Please enter the number of calories per " + unitMeasurement + " (between 1 and 2000): ");

            if (scnr.hasNextInt()) {
                numberCaloriesPerUnit = scnr.nextInt();

                if ((numberCaloriesPerUnit >= 1) && (numberCaloriesPerUnit <= 2000)) { //compare to see if scanner input is between 1 and 2000.
                    System.out.println(numberCaloriesPerUnit + " is a valid number of calories."); //confirm valid input from user.
                    newIngredient.setNumberCaloriesPerUnit(numberCaloriesPerUnit); //set the accepted amount as the numberCaloriesPerUnit for the newIngredient.
                }
                else {
                    System.out.println(numberCaloriesPerUnit + " is not a valid number of calories.");
                    System.out.println("Please enter a valid number of calories per unit between 1 and 2000: "); //retry input if not successful on first attempt.

                    if (scnr.hasNextInt()) {
                        numberCaloriesPerUnit = scnr.nextInt();

                        if ((numberCaloriesPerUnit >= 1) && (numberCaloriesPerUnit <= 2000)) { //compare to see if scanner input is between 1 and 2000.
                            System.out.println(numberCaloriesPerUnit + " is a valid number of calories!"); //confirm valid input from user.
                            newIngredient.setNumberCaloriesPerUnit(numberCaloriesPerUnit); //set the accepted amount as the numberCaloriesPerUnit for the newIngredient.
                        }

                        else if (numberCaloriesPerUnit < 1) {
                            System.out.println(numberCaloriesPerUnit + " is less than 1. Sorry, you are out of attempts."); //input less than one.
                            System.exit(0); //exit program to retry.
                        }

                        else {
                            System.out.println(numberCaloriesPerUnit + " is greater than 2000. Sorry, you are out of attempts."); //input greater than 2000.
                            System.exit(0); //exit program to retry.
                        }
                    }
                }
            }

            else {
                System.out.println("Error: That is not a number. Sorry, you are out of attempts."); //if a number is not entered
                System.exit(0); //exit program to retry.
                }


    //Calculate total calories

        totalCalories = ingredientAmount * numberCaloriesPerUnit;  //calculate totalCalories by multiplying ingredientAmount by number of calories.
        newIngredient.setTotalCalories(totalCalories);

        System.out.println("Congratulations!");
        System.out.println(ingredientAmount + " " + unitMeasurement + " of " + nameOfIngredient + " contains " 
                + totalCalories + " total calories.");
        System.out.println("Ingredient has been successfully added."); //confirm ingredient input.
        
        return newIngredient; //return the ingredient with user inputs added.
        
        }
}
      	