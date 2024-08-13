/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.ListInterface;
import adt.ArrayList;
import entity.*;
import control.*;
import java.util.*;
import utility.RecipeUI;

/**
 *
 * @author Mei Yi
 */
public class RecipeBoundary {
    Scanner scanner = new Scanner(System.in);
    RecipeControl recipeControl = new RecipeControl();
    
    public void searchRecipeInterface(ListInterface<Recipe> recipes){
        String searchKeyword;

        do {
            searchKeyword = getSearchInput();
            ListInterface<Recipe> results = recipeControl.searchRecipeByKeyword(searchKeyword, recipes);
            int resultsCount = results.getNumberOfEntries();
            
            //if results is not empty
            if (resultsCount >=1){
                RecipeUI.recipeSearchResultCount(resultsCount);
                printRecipeTitles(results);
                viewRecipeDetailInterface(recipes);
            } else if (searchKeyword.equalsIgnoreCase("exit")) {
                break;
            }
            else {
                RecipeUI.noRecipeFound();
            }
            
        } while (searchKeyword!="exit");
    }
    
    public void viewRecipeDetailInterface(ListInterface<Recipe> recipes) {
        System.out.print("\n>> Enter Recipe ID of recipe you want to view: ");
        String recipeIdInput = scanner.nextLine();
        ListInterface<Recipe> result = recipeControl.searchRecipeById(recipeIdInput, recipes);
        printRecipes(result);
    }
    
    public void printRecipes(ListInterface<Recipe> recipes){
        //formatting strings
        Recipe recipe;
        ListInterface<Ingredient> ingredients;
        ListInterface<String> instructions;
        
        String ingredientTitleStr= String.format("\n\n%-15s%1s", "    Ingredients",":");
        String instructionTitleStr= String.format("\n\n%-15s%1s", "   Instructions",":"); 
        
        for (int i=1; i <= recipes.getNumberOfEntries(); i++) {
            recipe = recipes.getItem(i);
            ingredients = recipe.getIngredients();
            instructions = recipe.getInstructions();
            
            printDivider(".",120);
            System.out.printf("\n\n%20s%28s", "","____________________________");
            System.out.printf("\n%20s|| %10s   %-10s||\n", "","Recipe", recipe.getRecipeId());
            System.out.print("\n       DishName: " + recipe.getDishName()+ingredientTitleStr);
            
            for (int j=1; j <= ingredients.getNumberOfEntries(); j++){
                //formatting ingredient str
                Ingredient ingredient = ingredients.getItem(j);
                String ingredientCont = ingredient.getIngredient();
                String portionCont = ingredient.getPortion();
                System.out.print(String.format("\n%16s%-30s%-30s", "",ingredientCont, portionCont));
                
            }
            
            System.out.print(instructionTitleStr);
            
            for (int j=1; j<= instructions.getNumberOfEntries(); j++){
                //formatting instruction str
                String instruction = instructions.getItem(j);
                System.out.print(String.format("\n%5s >  %30s\n", j,instruction));
            }  
        } 
        printDivider(".",120);
    }
    
    
    public void printRecipeTitles(ListInterface<Recipe> recipes){
        Recipe recipe;
        String format = "\n%10s\t%-30s";
        
        printDivider(".",120);
        
        System.out.printf(format, "Recipe ID", "Dish name");
        printDivider("-",70);
        
        for (int i=1; i<= recipes.getNumberOfEntries(); i++) {
            recipe = recipes.getItem(i);
            System.out.printf(format, recipe.getRecipeId(), recipe.getDishName());
        }
        printDivider("-",70);
    }
    
    public void printDivider(String symbol, int qty) {
        System.out.print("\n");
        for (int i=1; i<=qty; i++){
            System.out.print(symbol);
        }
        System.out.print("\n");
    }

    public String getSearchInput() {
        System.out.print("\n>> Enter keyword you want to search a recipe : ");
        String keyword = scanner.nextLine();
        return keyword; 
    }
    
     public int getSearchInputByNumber() {
         int num = -1;
         while (true) {
             try {
                 System.out.print("\n>> Enter the number of the recipe you want to report (0 for exit): ");
                 num = scanner.nextInt();
                 scanner.nextLine(); // consume the newline character
                 break;
             } catch (InputMismatchException e) {
                 System.out.println("Invalid input. Please enter a valid number.");
                 scanner.nextLine(); // clear the invalid input
             }
         }
         return num;
    }
    
    public void printGeneralRecipes(ListInterface<Recipe> recipes){
         Recipe recipe;
        System.out.println("\nRecipe List: ");
        System.out.printf("\n%s%n","-".repeat(54));
        System.out.printf("|%-7s|%-11s|%-32s|","No","Recipe code","Recipe Name");
        System.out.printf("\n%s%n","-".repeat(54));
        for(int i=1;i<=recipes.getNumberOfEntries();i++){
            recipe = recipes.getItem(i);
            System.out.printf("|%-7s|%-11s|%-32s|\n",i,recipe.getRecipeId(),recipe.getDishName()); 
        } 
      
        System.out.printf("%s%n","-".repeat(54));
    }

    public boolean reportReceipt(){
        //ask if user want to report a recipe, return true if yes, false if no, keep asking until user input Y or N
        String input;
        boolean report = false;
        do {
            System.out.print("\n>> Do you want to delete this recipe? (Y/N): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                report = true;
                break;
            } else if (input.equalsIgnoreCase("N")) {
                report = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (true);
        return report;
    }
}
