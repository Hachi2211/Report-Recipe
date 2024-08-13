/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Mei Yi
 */
public class Ingredient implements Comparable<Ingredient> {
    private String ingredient;
    private String portion;

    //Constructor
    public Ingredient() {
    }

    public Ingredient(String ingredient, String portion) {
        this.ingredient = ingredient;
        this.portion = portion;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    
    
    
    @Override
    public String toString() {
        String str = "";
        str = String.format("%16s%-30s%-30s", "",ingredient, portion);                
        return str;
    }
    
 
    
    @Override
    public int compareTo(Ingredient o) {
        Ingredient thisIngredient = this;
        Ingredient anotherIngredient = (Ingredient)o;
        
        return thisIngredient.ingredient.compareTo(anotherIngredient.ingredient);
    }
   
    
}
