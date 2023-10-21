package org.sionnach.bot.service;

import org.sionnach.bot.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getPopular();

    Recipe findRecipeById(Long id);

}