package com.mlc.MLC.components;

import com.mlc.MLC.models.Ingredient;
import com.mlc.MLC.models.Recipe;
import com.mlc.MLC.models.Steps;
import com.mlc.MLC.models.User;
import com.mlc.MLC.repository.IngredientRepository;
import com.mlc.MLC.repository.RecipeRepository;
import com.mlc.MLC.repository.StepsRepository;
import com.mlc.MLC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    StepsRepository stepsRepository;


    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User(0,0,0,0,0);
        userRepository.save(user1);

        // BACsalad data (NOT FINAL)
        Ingredient bacon = new Ingredient("Bacon",37, 0,41,0,false,false, "per 2 slices", 200.0);
        ingredientRepository.save(bacon);
        Ingredient apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true , "One apple", 75.0);
        ingredientRepository.save(apple);
        Ingredient cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true, "per 20", 125.0);
        ingredientRepository.save(cashews);

        Steps bacSaladSteps = new Steps("");
        stepsRepository.save(bacSaladSteps);
        bacSaladSteps.setStep1("Chop apple");
        stepsRepository.save(bacSaladSteps);

        Recipe bacSalad = new Recipe("BAC Salad", bacSaladSteps);
        recipeRepository.save(bacSalad);

        bacSalad.addIngredient(bacon);
        bacSalad.addIngredient(apple);
        bacSalad.addIngredient(cashews);
        recipeRepository.save(bacSalad);

        //Portobello Mushroom And Squash Risotto data(NOT FINAL)
        Ingredient onion = new Ingredient("Onion", 1, 8, 0, 2, true, true, "Per medium onion", 44.0);
        ingredientRepository.save(onion);
        Ingredient oliveOil = new Ingredient("Olive Oil", 0,0,14,0, true, true, "Per TableSpoon", 120.0);
        ingredientRepository.save(oliveOil);
        Ingredient squash = new Ingredient("Squash",5.5,36,0.6,2.8, true, true, "Per medium squash",143.0);
        ingredientRepository.save(squash);
        Ingredient risottoRice = new Ingredient("Risotto Rice",11,117,1,0,true,true,"Per 150g",524.0);
        ingredientRepository.save(risottoRice);
        Ingredient whiteWine = new Ingredient("White Wine",0,1.6,0,0, true,true,"Per 60ml",49.0);
        ingredientRepository.save(whiteWine);
        Ingredient vegetableStockCube = new Ingredient("Vegetable Stock",0.6, 3,2,0.4,true,true,"Per Stock cube",31.0);
        ingredientRepository.save(vegetableStockCube);
        Ingredient parmesanCheese = new Ingredient("ParmesanCheese", 14.4, 1.5, 10.7, 0, false, false, "Per 40g",162.0);
        ingredientRepository.save(parmesanCheese);
        Ingredient portobelloMushroom = new Ingredient("Portobello Mushroom",2,4,0.5,1.3,true,true, "Per large mushroom", 22.0);

        Steps portobelloMushroomAndSquashRisottoSteps = new Steps("Prepare Mushrooms");
        portobelloMushroomAndSquashRisottoSteps.setStep2("In a large pot add two teaspoons of olive oil");
        portobelloMushroomAndSquashRisottoSteps.setStep3("Add the onions to the pot");
        stepsRepository.save(portobelloMushroomAndSquashRisottoSteps);

        Recipe portobelloMushroomAndSquashRisotto = new Recipe("Portobello Mushroom And Squash Risotto", portobelloMushroomAndSquashRisottoSteps);
        recipeRepository.save(portobelloMushroomAndSquashRisotto);
        portobelloMushroomAndSquashRisotto.addIngredient(onion);
        portobelloMushroomAndSquashRisotto.addIngredient(oliveOil);
        portobelloMushroomAndSquashRisotto.addIngredient(squash);
        portobelloMushroomAndSquashRisotto.addIngredient(risottoRice);
        portobelloMushroomAndSquashRisotto.addIngredient(whiteWine);
        portobelloMushroomAndSquashRisotto.addIngredient(vegetableStockCube);
        portobelloMushroomAndSquashRisotto.addIngredient(parmesanCheese);
        recipeRepository.save(portobelloMushroomAndSquashRisotto);


        //Vegan Chickpea Frittata

        Ingredient cauliflower = new Ingredient("Cauliflower", 2, 5, 0, 2, true, true, "per 100g", 25.00);
        ingredientRepository.save(cauliflower);
        Ingredient spinach = new Ingredient("Spinach", 1.6, 2.4, 0.4, 1.2, true, true, "per 60g", 14.0);
        ingredientRepository.save(spinach);
        Ingredient chickpeaFlour = new Ingredient("Chickpea Flour", 32.3, 72.2, 6.9, 11.1, true, true, "per 140g", 501.1);
        ingredientRepository.save(chickpeaFlour);

        Steps veganChickpeaFrittataSteps = new Steps("Preheat oven to 190oC and use 1 tsp of olive oil to grease a round baking tin");
        veganChickpeaFrittataSteps.setStep2("Place a large saute pan over medium-high heat, coat with remaining olive oil and add the diced onion and chopped cauliflower.");
        veganChickpeaFrittataSteps.setStep3("Stir, reducing the heat to medium when it starts to sizzle. When the cauliflower is tender, about 4 minutes, remove from the heat and stir in the spinach and salt. Let it stand as the spinach wilts.");
        veganChickpeaFrittataSteps.setStep4("In a medium bowl, whisk the chickpea flour, pepper and 1 1/2 cups (375ml) water. Stir the cooked vegetables into the chickpea mixture, then pour into the prepared pie pan. Smooth the top.");
        veganChickpeaFrittataSteps.setStep5("Bake for 45 minutes, until the top is cracked and feels firm when pressed. Let cool for 5 minutes on a rack before slicing in 6 pieces.");
        stepsRepository.save(veganChickpeaFrittataSteps);

        Recipe veganChickpeaFrittata = new Recipe("Vegan Chickpea Frittata", veganChickpeaFrittataSteps);
        recipeRepository.save(veganChickpeaFrittata);
        veganChickpeaFrittata.addIngredient(oliveOil);
        veganChickpeaFrittata.addIngredient(onion);
        veganChickpeaFrittata.addIngredient(cauliflower);
        veganChickpeaFrittata.addIngredient(spinach);
        veganChickpeaFrittata.addIngredient(chickpeaFlour);
        recipeRepository.save(veganChickpeaFrittata);

        //Mushroom and Kale Pasta

        Ingredient garlic = new Ingredient("Garlic", 0.6, 3, 0, 0.2, true, true, "per 3 cloves", 13.0);
        ingredientRepository.save(garlic);
        Ingredient penne = new Ingredient("Penne", 12.3, 74, 1.8, 3.5, false, true, "per 100g", 353.0);
        ingredientRepository.save(penne);
        Ingredient kale = new Ingredient("Kale", 4.7, 9.3, 0, 4.7, true, true, "per 100g", 47.0);
        ingredientRepository.save(kale);
        Ingredient boursin = new Ingredient("Boursin Cheese", 3.4, 1.7, 20.7, 0, false, true, "per 50g", 207.0);
        ingredientRepository.save(boursin);

        Steps mushroomAndKalePastaSteps = new Steps("Put the oil in the pot,When the oil is hot, add the mushrooms, onions and salt, and cook, stirring frequently, until mushrooms begin to release their juices, 5 minutes.");
        mushroomAndKalePastaSteps.setStep2("Add the garlic and cook until fragrant, 30 seconds.");
        mushroomAndKalePastaSteps.setStep3("Add the pasta to a pot of boiling salted water and cook for 10-12 minutes");
        mushroomAndKalePastaSteps.setStep4("Drain the pasta but keep 1/4 cup of the water. Add the water and kale to the mushroom pan and let it soften for a few minutes");
        mushroomAndKalePastaSteps.setStep5("Take the pan off the heat an stir in the cheese till combined. add the sauce to your pasta and enjoy!");
        stepsRepository.save(mushroomAndKalePastaSteps);

        Recipe mushroomAndKalePasta = new Recipe("Mushroom and Kale Pasta", mushroomAndKalePastaSteps);
        recipeRepository.save(mushroomAndKalePasta);
        mushroomAndKalePasta.addIngredient(oliveOil);
        mushroomAndKalePasta.addIngredient(portobelloMushroom);
        mushroomAndKalePasta.addIngredient(onion);
        mushroomAndKalePasta.addIngredient(garlic);
        mushroomAndKalePasta.addIngredient(penne);
        mushroomAndKalePasta.addIngredient(kale);
        mushroomAndKalePasta.addIngredient(boursin);
        recipeRepository.save(mushroomAndKalePasta);

        






    }
}
