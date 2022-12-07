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

        User user = new User(0);
        user.setCarbs(10);
        user.setCalories(12);
        user.setFat(13);
        userRepository.save(user);

        Ingredient bacon = new Ingredient("Bacon",37, 0,41,0,false,false, "per 2 slices", 200.0);
        ingredientRepository.save(bacon);

        Ingredient apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true , "per one apple", 75.0);
        ingredientRepository.save(apple);

        Ingredient cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true, "per 20", 125.0);
        ingredientRepository.save(cashews);

        Steps bacSaladSteps = new Steps("");
        stepsRepository.save(bacSaladSteps);

        bacSaladSteps.setStep1("chop apple");
        stepsRepository.save(bacSaladSteps);

        Recipe bacSalad = new Recipe("BAC Salad", bacSaladSteps);
        recipeRepository.save(bacSalad);


        bacSalad.addIngredient(bacon);
        bacSalad.addIngredient(apple);
        bacSalad.addIngredient(cashews);
        recipeRepository.save(bacSalad);

//        bacSalad.addIngredient(bacon, 20);
//        bacSalad.addIngredient(apple, 50);
//        bacSalad.addIngredient(cashews, 10);
//        recipeRepository.save(bacSalad);


    }
}
