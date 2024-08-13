/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.*;
import entity.*;

/**
 *
 * @author Mei Yi
 */
public class RecipeDao {
    public static ListInterface<Recipe> initRecipe() {
        ListInterface<Recipe> recipes = new ArrayList<Recipe> ();
        ListInterface<Ingredient> ingredients = new ArrayList<Ingredient> ();
        ListInterface<String> instructions = new ArrayList<> ();
        ListInterface<String> keywords = new ArrayList<> ();
        
        /* TEMPLATE
        ingredients.add(new Ingredient("", ""));
        instructions.add("");
        keywords.add("");
        Recipe r5 = new Recipe("",ingredients, instructions, keywords);
        ingredients.clear();
        instructions.clear();
        keywords.clear();
        */
        
        //Recipe 1
        ListInterface<Ingredient> i1 = new ArrayList<> ();
        ListInterface<String> ins1 = new ArrayList<String> ();
        ListInterface<String> k1 = new ArrayList<String> ();
        i1.add(new Ingredient("Vegetable oil", "1 tbsp"));
        i1.add(new Ingredient("Chopped garlic", "3 cloves"));
        i1.add(new Ingredient("Black bean", "3 x 400g"));
        i1.add(new Ingredient("Cider vinegar", "3 tbsp"));
        i1.add(new Ingredient("Honey", "1.5 tbsp"));
        i1.add(new Ingredient("Smoked paprika", "1.5 tbsp"));
        i1.add(new Ingredient("Ground cumin", "1.5 tbsp"));
        ins1.add("In a large frying pan, heat the oil and add the garlic. Fry until golden, then add the beans. Pour in the cider vinegar, honey and spices along with 1 tsp or more of salt, to taste. Cook until warmed through, crushing gently with the back of your wooden spoon, then set aside.");
        ins1.add("The best way to make the guacamole is with a large stone pestle and mortar, but you can use a medium bowl and a flat-ended rolling pin instead. Crush the garlic, coriander and chilli into a rough paste. Scoop in the avocado with a little salt and crush roughly - you want it chunky, not smooth. Squeeze in the lime juice and set aside.");
        ins1.add("Mix the salsa ingredients in a small bowl. Heat a griddle pan or steamer and quickly griddle the tortillas or steam a stack of them to warm up. Reheat the bean mixture.");
        ins1.add("To serve, put 1-2 heaped tbsp of beans on a tortilla. Top with a big spoonful of guacamole and some salsa, hot sauce and a dollop of soured cream or yogurt.");
        k1.add("spicy");
        k1.add("mexican food");
        k1.add("western food");
        k1.add("quick and easy");
        Recipe r1 = new Recipe("Spicy Black Bean Tacos", i1, ins1, k1);
        recipes.add(r1);
        
        
        //Recipe 2
        ListInterface<Ingredient> i2 = new ArrayList<> ();
        ListInterface<String> ins2 = new ArrayList<String> ();
        ListInterface<String> k2 = new ArrayList<String> ();
        i2.add(new Ingredient("Coles Long Grain", "1 cup"));
        i2.add(new Ingredient("Vegetable oil", "2 tbsp"));
        i2.add(new Ingredient("Eggs", "2"));
        i2.add(new Ingredient("Bacon rashers", "2"));
        i2.add(new Ingredient("Carrot", "1"));
        i2.add(new Ingredient("Shallots", "2"));
        i2.add(new Ingredient("Frozen peas", "1.5 cup"));
        i2.add(new Ingredient("Soy sauce", "1 tbsp"));
        i2.add(new Ingredient("Sesame seeds", "Based on preferences"));
        ins2.add("Cook the rice in a large saucepan of boiling water for 12 minutes or until tender. Drain and leave to cool.");
        ins2.add("Heat oil in non-stick wok or large frying pan over medium heat. Add eggs. Swirl over base to form an omelette. Cook for 2 minutes or until set. Transfer to a chopping board. Set aside to cool slightly. Roll up and thickly slice.");
        ins2.add("Add bacon to wok. Cook 4 minutes until light golden. Add carrot. Stir fry 1 minute. Add shallots, peas and rice. Cook, stirring, 3-4 minutes. Add egg and soy sauce. Stir until heated through. Sprinkle with sesame seeds and top with extra shallots. Serve immediately.");
        k2.add("asian food");
        k2.add("proper meal");
        k2.add("chinese food");
        k2.add("customizable");
        Recipe r2 = new Recipe("Chinese Fried Rice",i2, ins2, k2);
        recipes.add(r2);
        
        
        //Recipe 3
        ListInterface<Ingredient> i3 = new ArrayList<> ();
        ListInterface<String> ins3 = new ArrayList<String> ();
        ListInterface<String> k3 = new ArrayList<String> ();
        i3.add(new Ingredient("Chicken breast (bite size)", "1 pound"));
        i3.add(new Ingredient("Honey", "1.5 tbsp"));
        i3.add(new Ingredient("Chipotle pepper (minced)", "1"));
        i3.add(new Ingredient("Garlic", "1 clove"));
        i3.add(new Ingredient("Taco seasoning", "2 tbsp"));
        i3.add(new Ingredient("Orange", "1"));
        i3.add(new Ingredient("Kosher salt", "0.5 tbsp"));
        i3.add(new Ingredient("Avocado oil", "1 tbsp"));
        ins3.add("Soak the skewers in water for 15-30 minutes while you prep the chicken.");
        ins3.add("Using your hands or tongs, mix the chicken with the honey chipotle mix. It’ll look saucy and messy, in a good way.");
        ins3.add("Thread the chicken pieces onto skewers.");
        ins3.add("You can cook these a number of different ways – I air fry them at 400 degrees for 10 minutes or until internal temperature reaches 165 degrees. Grilling would also be amazing! Finish with a drizzle of honey, or (yum) 2 tablespoons of melted butter mixed with honey.");
        k3.add("barbeque");
        k3.add("sweet");
        k3.add("snack");
        k3.add("side dish");
        k3.add("homemade");
        k3.add("asian food");
        k3.add("western food");
        Recipe r3 = new Recipe("Honey Chipotle Chicken Skewers",i3, ins3, k3);
        recipes.add(r3);
        
        //Recipe 4
        ListInterface<Ingredient> i4 = new ArrayList<> ();
        ListInterface<String> ins4 = new ArrayList<String> ();
        ListInterface<String> k4 = new ArrayList<String> ();
        i4.add(new Ingredient("Tomato", "1.5kg"));
        i4.add(new Ingredient("Smoked paprika", "Based on preferences"));
        i4.add(new Ingredient("Garlic", "5 cloves"));
        i4.add(new Ingredient("Onion", "1"));
        i4.add(new Ingredient("Vegeteble broth", "300 ml"));
        i4.add(new Ingredient("Cream", "125 ml"));
        ins4.add("Place halved tomatoes and unpeeled garlic cloves on a baking tray. Toss with olive oil, smoked paprika, salt and pepper. Arrange them cut face up. Roast for 40 to 45 minutes in a hot oven until the surface has little charred bits and the tomatoes are completely soft.");
        ins4.add("Sauté the cutted onion and minced garlic in a little oil until the onion is soft and translucent.");
        ins4.add("Add the roasted tomatoes and vegetable stock.");
        ins4.add("Squeeze the roasted garlic flesh from the skins. The garlic flavour will be very mellowed and sweet. (It’s tempting to smear it on toast");
        ins4.add("Blitz until smooth using a stick blender. Or do this step in a food processor or blender (you need a high powered blender like a Vitamin or Blendtec to make the soup perfectly smooth).");
        ins4.add("Simmer for 10 minutes to bring the flavours together, then stir in the cream.");
        ins4.add("Ladle into bowls and serve with a drizzle of cream and sprinkle of fresh basil!");
        k4.add("hot soup");
        k4.add("winter dish");
        k4.add("western meal");
        k4.add("creamy");
        Recipe r4 = new Recipe("Smoky Roasted Tomato Soup",i4, ins4, k4);
        recipes.add(r4);
        
        
        //Recipe 5
        ListInterface<Ingredient> i5 = new ArrayList<> ();
        ListInterface<String> ins5 = new ArrayList<String> ();
        ListInterface<String> k5 = new ArrayList<String> ();
        i5.add(new Ingredient("Olive oil", "3 tbsp"));
        i5.add(new Ingredient("Onion", "1"));
        i5.add(new Ingredient("Garlic", "2 cloves"));
        i5.add(new Ingredient("Curry powder", "3 tbsp"));
        i5.add(new Ingredient("Ground cinnamon", "1 teaspoon"));
        i5.add(new Ingredient("Paprika", "1 teaspoon"));
        i5.add(new Ingredient("Bay leaf", "1"));
        i5.add(new Ingredient("Ginger", "15g"));
        i5.add(new Ingredient("Sugar", "1 teaspoon"));
        i5.add(new Ingredient("Chicken breast", "2"));
        i5.add(new Ingredient("Tomato paste", "1 tbsp"));
        ins5.add("Heat olive oil in a skillet over medium heat. Sauté onion until lightly browned.");
        ins5.add("Stir in garlic, curry powder, cinnamon, paprika, bay leaf, ginger, sugar, and salt. Continue stirring for 2 minutes.");
        ins5.add("Add chicken pieces, tomato paste, yogurt, and coconut milk. Bring to a boil, reduce heat, and simmer for 20 to 25 minutes.");
        ins5.add("Remove bay leaf, and stir in lemon juice and cayenne pepper. Simmer 5 more minutes.");
        k5.add("spicy");
        k5.add("curry");
        k5.add("asian food");
        k5.add("indian food");
        k5.add("homemade");
        Recipe r5 = new Recipe("Indian Chicken Curry",i5, ins5, k5);
        recipes.add(r5);
        
        
        return recipes;
    }
}
