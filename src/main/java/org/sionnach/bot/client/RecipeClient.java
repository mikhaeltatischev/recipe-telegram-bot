package org.sionnach.bot.client;

import org.sionnach.bot.model.Meals;

public interface RecipeClient {

    Meals findByName(String name);

    Meals findByMainIngredient(String ingredient);

    Meals findById(String id);

}