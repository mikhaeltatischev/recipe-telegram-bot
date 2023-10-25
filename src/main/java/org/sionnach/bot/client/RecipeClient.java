package org.sionnach.bot.client;

import org.sionnach.bot.model.Meal;

import java.util.List;

public interface RecipeClient {

    List<Meal> findByName(String name);

    List<Meal> findByMainIngredient(String ingredient);

    List<Meal> findById(String id);
}