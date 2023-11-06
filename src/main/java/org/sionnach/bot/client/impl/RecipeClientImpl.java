package org.sionnach.bot.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sionnach.bot.client.BaseClient;
import org.sionnach.bot.client.RecipeClient;
import org.sionnach.bot.model.Meals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class RecipeClientImpl extends BaseClient implements RecipeClient {

    private final ObjectMapper mapper;

    private static final String NAME_PATH = "/api/json/v1/1/search.php";
    private static final String MAIN_INGREDIENT_PATH = "/api/json/v1/1/filter.php";
    private static final String ID_PATH = "/api/json/v1/1/lookup.php";
    private static final String NAME_PARAMETER = "?s=";
    private static final String INGREDIENT_PARAMETER = "?i=";
    private static final String ID_PARAMETER = "?i=";

    @Autowired
    public RecipeClientImpl(@Value("${security.url}") String serverUrl, RestTemplateBuilder builder, ObjectMapper mapper) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
        this.mapper = mapper;
    }

    public Meals findByName(String name) {
        ResponseEntity<Object> entity = get(NAME_PATH + NAME_PARAMETER + name);

        return mapper.convertValue(entity.getBody(), Meals.class);
    }

    public Meals findByMainIngredient(String ingredient) {
        ResponseEntity<Object> entity = get(MAIN_INGREDIENT_PATH + INGREDIENT_PARAMETER + ingredient);

        return mapper.convertValue(entity.getBody(), Meals.class);
    }

    public Meals findById(String id) {
        ResponseEntity<Object> entity = get(ID_PATH + ID_PARAMETER + id);

        return mapper.convertValue(entity.getBody(), Meals.class);
    }
    
}