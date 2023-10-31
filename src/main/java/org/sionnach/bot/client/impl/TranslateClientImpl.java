package org.sionnach.bot.client.impl;

import org.sionnach.bot.client.TranslateClient;
import org.sionnach.bot.client.WebClientBuilder;
import org.sionnach.bot.model.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class TranslateClientImpl implements TranslateClient {

    private static final String BASE_URL = "https://api.mymemory.translated.net";
    private static final String TRANSLATE_URL = "/get";
    private static final String TEXT_PARAMETER = "q";
    private static final String LANGUAGE_PARAMETER = "langpair";
    private static final String LANGUAGE_PAIR = "en|ru";

    private final WebClient webClient;

    public TranslateClientImpl() {
        this.webClient = WebClientBuilder.webClientWithTimeout(BASE_URL);
    }

    @Override
    public String translate(String text) {
        return splitText(text);
    }

    private String translateRequest(String text) {
        Mono<ResponseData> response = webClient.get()
                .uri((uriBuilder -> uriBuilder.path(TRANSLATE_URL)
                        .queryParam(TEXT_PARAMETER, text)
                        .queryParam(LANGUAGE_PARAMETER, LANGUAGE_PAIR).build()))
                .retrieve()
                .bodyToMono(ResponseData.class);

        return Objects.requireNonNull(response.block()).getResponseData().getTranslatedText();
    }

    private String splitText(String text) {
        if (text.length() > 1500) {
            return splitByCount(text, 4);
        } else if (text.length() > 1000) {
            return splitByCount(text, 3);
        } else if (text.length() > 500) {
            return splitByCount(text, 2);
        } else {
            return translateRequest(text);
        }
    }

    private String splitByCount(String text, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        int begin = 0;
        int end = 499;

        for (int i = 1; i <= count; i++) {
            String str;
            if (end > text.length()) {
                str = text.substring(begin);
            } else {
                str = text.substring(begin, end);
            }
            stringBuilder.append(translateRequest(str));
            begin += 500;
            end += 500;
        }

        return stringBuilder.toString();
    }
}