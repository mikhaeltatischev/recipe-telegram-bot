package org.sionnach.bot.client.impl;

import org.sionnach.bot.client.RecipeClient;
import org.sionnach.bot.client.WebClientBuilder;
import org.sionnach.bot.model.Meal;
import org.sionnach.bot.model.Meals;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class RecipeClientImpl implements RecipeClient {

    private static final String BASE_URL = "https://www.themealdb.com";
    private static final String NAME_PATH = "/api/json/v1/1/search.php";
    private static final String MAIN_INGREDIENT_PATH = "/api/json/v1/1/filter.php";
    private static final String ID_PATH = "/api/json/v1/1/lookup.php";
    private static final String NAME_PARAMETER = "s";
    private static final String INGREDIENT_PARAMETER = "i";
    private static final String ID_PARAMETER = "i";

    private final WebClient webClient;

    public RecipeClientImpl() {
        this.webClient = WebClientBuilder.webClientWithTimeout(BASE_URL);
    }

    public List<Meal> findByName(String name) {
        Mono<Meals> response = webClient.get()
                .uri((uriBuilder -> uriBuilder.path(NAME_PATH)
                        .queryParam(NAME_PARAMETER, name).build()))
                .retrieve()
                .bodyToMono(Meals.class);

        return response.block().getMeals();
    }

    public List<Meal> findByMainIngredient(String ingredient) {
        Mono<Meals> response = webClient.get()
                .uri((uriBuilder -> uriBuilder.path(MAIN_INGREDIENT_PATH)
                        .queryParam(INGREDIENT_PARAMETER, ingredient).build()))
                .retrieve()
                .bodyToMono(Meals.class);

        return response.block().getMeals();
    }

    public List<Meal> findById(String id) {
        Mono<Meals> response = webClient.get()
                .uri((uriBuilder -> uriBuilder.path(ID_PATH)
                        .queryParam(ID_PARAMETER, id).build()))
                .retrieve()
                .bodyToMono(Meals.class);

        return response.block().getMeals();
    }

}