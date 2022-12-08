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




    }
}
