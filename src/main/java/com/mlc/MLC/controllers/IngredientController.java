package com.mlc.MLC.controllers;


import com.mlc.MLC.models.Ingredient;
import com.mlc.MLC.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping(value = "/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        return new ResponseEntity<>(ingredientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/ingredients/{id}")
    public ResponseEntity getIngredient(@PathVariable Long id){
        return new ResponseEntity<>(ingredientRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/ingredients")
    public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/ingredients/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable Long id){
        ingredientRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @PatchMapping(value = "/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }
}
