/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;
import boundary.*;
import control.*;
import entity.*;
import dao.*;import java.util.Comparator;


/**
 *
 * @author Mei Yi
 */
public class Recipe implements Comparable<Recipe> {
    private String recipeId;
    private String dishName;
    private ListInterface<Ingredient> ingredients;
    private ListInterface<String> instructions;
    private ListInterface<String> keywords;
    private static int lastRecipeId = 1000;
    private static final String RECIPE_ID_PREFIX = "RCP";
    
    //Constructors
    public Recipe() {
        
    }
    
    public Recipe(String dishName, ListInterface<Ingredient> ingredients, ListInterface<String> instructions, ListInterface<String> keywords) {
        recipeId = RECIPE_ID_PREFIX + lastRecipeId;
        this.dishName = dishName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.keywords = keywords;
        lastRecipeId++;
    }
    
    //Constructor for dummy objects
    public Recipe(String dishName, ListInterface<Ingredient> ingredients, ListInterface<String> instructions, ListInterface<String> keywords, int dummyIdentifier) {
        this.dishName = dishName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.keywords = keywords;
    }
    
    public Recipe(String recipeId) {
        this.recipeId = recipeId;
        this.dishName = null;
        this.ingredients = null;
        this.instructions = null;
        this.keywords = null;
    }

    
    
    
    
    //Getter & Setter
    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public ListInterface<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ListInterface<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ListInterface<String> getInstructions() {
        return instructions;
    }

    public void setInstruction(ListInterface<String> instructions) {
        this.instructions = instructions;
    }

    public ListInterface<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ListInterface<String> keywords) {
        this.keywords = keywords;
    }

    public static int getLastRecipeId() {
        return lastRecipeId;
    }

    public static void setLastRecipeId(int lastRecipeId) {
        Recipe.lastRecipeId = lastRecipeId;
    }

    @Override
    public String toString() {
        String instructionStr = "";
        String str = "";
        
        for (int i=1; i<=instructions.getNumberOfEntries();i++){
            str = String.format("\n%5s >  %30s\n", i,instructions.getItem(i));
            instructionStr = instructionStr.concat(str);
            //instructionStr.concat("\n\t" + i + ">> " + instructions.getItem(i) + "\n");
        }
        
        String ingredientTitleStr= String.format("\n\n%-15s%1s\n", "   Ingredients",":");
        String instructionTitleStr= String.format("\n%-15s%1s", "   Instructions",":");        
        
        return "\n\n\nRecipe " + recipeId + 
                "\n   DishName:" + dishName + 
                "\nKeywords: " + keywords +
                ingredientTitleStr + ingredients + instructionTitleStr + instructionStr;
    }
    
    @Override
    public int compareTo(Recipe o) {
        Recipe anotherRecipe = (Recipe) o;
        
        return this.recipeId.compareTo(anotherRecipe.recipeId);
    }
    
    public static class KeywordComparator implements Comparator<Recipe> {
        @Override
        public int compare(Recipe target, Recipe input) {
            /*
            ListInterface<String> targetKeywords = new ArrayList<String> ();
            targetKeywords = target.getKeywords();
            String inputKeyword = input.getKeywords().getItem(1);
            char firstInputChar = inputKeyword.charAt(0);
            String targetKeyword;
            
            for (int i=1; i <= targetKeywords.getNumberOfEntries(); i++){
                targetKeyword = targetKeywords.getItem(i);
                int firstSameIndex = targetKeyword.indexOf(firstInputChar);
                
                if (firstSameIndex!=-1) {
                    String targetValidStr = targetKeyword.substring(firstSameIndex);
                    if (inputKeyword.length() < targetValidStr.length()) {
                        if (targetValidStr.substring(firstSameIndex,inputKeyword.length()).equalsIgnoreCase(inputKeyword)){
                            return 0;
                        }
                    } else {
                        if (inputKeyword.substring(0,targetValidStr.length()).equalsIgnoreCase(targetValidStr)){
                            return 0;
                        }
                    }
                }
            }
            return -1;
            */
            ListInterface<String> targetKeywords = new ArrayList<String> ();
            targetKeywords = target.getKeywords();
            String inputKeyword = input.getKeywords().getItem(1);
            String targetKeyword;
            
            for (int i=1; i <= targetKeywords.getNumberOfEntries(); i++){
                targetKeyword = targetKeywords.getItem(i);
                int firstSameChar;
                                
                if (inputKeyword.length() < targetKeyword.length()) {
                    if (targetKeyword.substring(0,inputKeyword.length()).equalsIgnoreCase(inputKeyword)){
                        return 0;
                    }
                } else {
                    if (inputKeyword.substring(0,targetKeyword.length()).equalsIgnoreCase(targetKeyword)){
                        return 0;
                    }
                }
            }
            return -1;
        }        
    }
    
    public static class IdComparator implements Comparator<Recipe> {
        @Override
        public int compare(Recipe current, Recipe input) {
            if (current.getRecipeId().equalsIgnoreCase(input.getRecipeId())) {
                return 0;
            }
            return -1;
        }
    }
}
