package org.sionnach.bot.repository;

import org.sionnach.bot.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAll();

    Optional<Recipe> findRecipeById(Long id);

}