/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author Mei Yi
 */
public class RecipeUI {
    public static void recipeSearchResultCount(int recipeCount) {
        System.out.print("\n>> " + recipeCount + " Search results: \n");
    }
    
    public static void noRecipeFound() {
        System.out.println("\n>> Sorry, there is no recipe with keyword entered.");
    }
    
    public static void recipeNotFound() {
        System.out.println("\n>> Sorry, there is no recipe with recipe ID entered.");
    }
}
