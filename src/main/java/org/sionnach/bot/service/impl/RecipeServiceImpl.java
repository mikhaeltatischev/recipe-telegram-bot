package org.sionnach.bot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sionnach.bot.client.impl.RecipeClientImpl;
import org.sionnach.bot.exception.RecipeNotFoundException;
import org.sionnach.bot.model.Recipe;
import org.sionnach.bot.repository.RecipeRepository;
import org.sionnach.bot.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;
    private final RecipeClientImpl client;

    public List<Recipe> getPopular() {
        return repository.findAll();
    }

    @Override
    public Recipe findRecipeById(Long id) {
        return repository.findRecipeById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }
}