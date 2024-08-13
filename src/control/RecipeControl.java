/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.*;
import entity.Recipe;
import boundary.RecipeBoundary;

/**
 *
 * @author Mei Yi
 */
public class RecipeControl {
    private ListInterface<Recipe> recipes;

    //Constructor
    public RecipeControl() {
        
    }

    public RecipeControl(ListInterface<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ListInterface<Recipe> searchRecipeByKeyword(String searchInput, ListInterface<Recipe> recipes) {
        /* Story acceptance:
            - contains any keyword of any length = sucessful search
            - if no result, error msg and prompt search keyword input again
            - if has result, display recipe id, dish name arranged by ID
            - if has result, view details through prompt
        */
        
        //create dummy Recipe object
        ListInterface<String> keyword = new ArrayList<String> ();
        keyword.add(searchInput);
        Recipe targetRecipe = new Recipe("",null,null,keyword, 1);
        
        Recipe.KeywordComparator recipeComparator = new Recipe.KeywordComparator();
        ListInterface<Recipe> results = recipes.searchObjByAttrib(targetRecipe, recipeComparator);
        
        return results;
    }
    
    public ListInterface<Recipe> searchRecipeById(String recipeIdInput, ListInterface<Recipe> recipes) {
        //creating dummy Recipe obj
        
        Recipe recipe = new Recipe(recipeIdInput);
        
        Recipe.IdComparator recipeComparator = new Recipe.IdComparator();
        ListInterface<Recipe> result = recipes.searchObjByAttrib(recipe, recipeComparator);
        return result;
    }
    public ListInterface<Recipe>searchRecipeByNumber(int position) {
        //creating dummy Recipe obj
         Recipe recipe = recipes.getItem(position);
        ListInterface<Recipe> result= new ArrayList<>();
        result.add(recipe);
        return result;
    }
    
}
