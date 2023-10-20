package org.sionnach.bot.client;

import org.sionnach.bot.model.Meal;
import org.sionnach.bot.model.Meals;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class RecipeClient {

    private static final String BASE_URL = "https://www.themealdb.com";
    private static final String NAME_PATH = "/api/json/v1/1/search.php";

    private final WebClient webClient;



    public RecipeClient() {
        this.webClient = WebClientBuilder.webClientWithTimeout(BASE_URL);
    }

    public Object findByName() {
        String name = "Arrabiata";

        Mono<Meals> response = webClient.get()
                .uri((uriBuilder -> uriBuilder.path(NAME_PATH)
                        .queryParam("s", name).build()))
                .retrieve()
                .bodyToMono(Meals.class);

        List<Meal> meals = response.block().getMeals();
        return meals;
    }
}