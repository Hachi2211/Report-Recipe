package receipeSystem;

import adt.*;
import boundary.*;
import control.*;
import entity.*;
import dao.*;

/**
 *
 * @author Li Hock
 */

// This is the driver class
public class ReceipeSystem {

    public static void main(String[] args) {
        ListInterface<Recipe> recipes = new ArrayList<>(30);
        recipes = RecipeDao.initRecipe();

        RecipeControl recipeControl = new RecipeControl(recipes);
        RecipeBoundary recipeBoundary = new RecipeBoundary();

        int choice;
        System.out.println("Number of recipes: " + recipes.getNumberOfEntries());

        do {
            recipeBoundary.printGeneralRecipes(recipes);
            choice = recipeBoundary.getSearchInputByNumber();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice < 0 || choice > recipes.getNumberOfEntries()) {
                System.out.println("Invalid input. Please enter a valid recipe number.");
            } else {
                ListInterface<Recipe> recipesToBeShown = recipeControl.searchRecipeByNumber(choice);
                recipeBoundary.printRecipes(recipesToBeShown);
                if(recipeBoundary.reportReceipt()){
                    recipes.remove(choice);
                    System.out.println("Recipe removed successfully");
                }else{
                    System.out.println("No changes made");
                }
            }
        } while (choice != 0);
    }
}
