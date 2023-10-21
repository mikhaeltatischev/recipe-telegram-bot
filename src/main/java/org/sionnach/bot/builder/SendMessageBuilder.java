package org.sionnach.bot.builder;

import lombok.SneakyThrows;
import org.sionnach.bot.keyboard.InlineKeyboard;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.Recipe;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

public class SendMessageBuilder {

    private static final String START_MESSAGE = "Привет! \nЭтот бот поможет тебе с поиском рецептов любых блюд\n" +
            "Ниже ты можешь выбрать способ поиска рецепта";
    private static final String INGREDIENTS_MESSAGE = "Введите ингредиенты по которым вы хотели бы найти рецепт\n" +
            "Формат ввода: \"Спаггети, бекон, сыр\"";
    private static final String POPULAR_MESSAGE = "Популярные рецепты";
    private static final String NAME_MESSAGE = "Введите название блюда";
    private static final String DESCRIPTION = "Описание блюда - ";
    private static final String INGREDIENTS = "Ингредиенты:\n";
    private static final String INSTRUCTION = "Способ приготовления - ";
    private static final String VIDEO = "Видео приготовления (английский язык) - ";
    private static final String AREA = "Происхождение - ";
    private static final String CATEGORY = "Категория - ";

    private SendMessage sendMessage;

    public SendMessageBuilder() {
        this.sendMessage = new SendMessage();
    }

    public SendMessageBuilder chatId(Long chatId) throws Exception {
        if (chatId == null) {
            throw new Exception("Id must be not null");
        }
        this.sendMessage.setChatId(chatId);
        return this;
    }

    @SneakyThrows
    public Answer buildStart() {
        return createAnswer(START_MESSAGE, InlineKeyboard.mainKeyboard());
    }

    @SneakyThrows
    public Answer buildIngredients() {
        return createAnswer(INGREDIENTS_MESSAGE);
    }

    @SneakyThrows
    public Answer buildName() {
        return createAnswer(NAME_MESSAGE);
    }

    @SneakyThrows
    public Answer buildPopular(List<Recipe> recipes) {
        return createAnswer(POPULAR_MESSAGE, InlineKeyboard.popularKeyboard(recipes));
    }

    @SneakyThrows
    public Answer buildRecipe(Recipe recipe) {
        String stringRecipe = createRecipeString(recipe);
        return createAnswer(stringRecipe);
    }

    private Answer createAnswer(String message, InlineKeyboardMarkup keyboard) {
        Answer answer = new Answer();
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(keyboard);
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    private Answer createAnswer(String message) {
        Answer answer = new Answer();
        sendMessage.setText(message);
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    private String createRecipeString(Recipe recipe) {
        StringBuilder builder = new StringBuilder();
        builder.append(recipe.getName())
                .append("\n\n")
                .append(CATEGORY)
                .append(recipe.getCategory())
                .append("\n\n")
                .append(AREA)
                .append(recipe.getArea())
                .append("\n\n")
                .append(DESCRIPTION)
                .append(recipe.getDescription())
                .append("\n\n")
                .append(INGREDIENTS);

        List<String> ingredients = List.of(recipe.getIngredients().split(","));
        List<String> measures = List.of(recipe.getMeasures().split(","));

        for (int i = 0; i < ingredients.size(); i++) {
            builder.append(ingredients.get(i))
                    .append(" ")
                    .append("-")
                    .append(" ")
                    .append(measures.get(i))
                    .append("\n");
            if (i == ingredients.size() - 1) {
                builder.append("\n");
            }
        }
        builder.append(INSTRUCTION)
                .append(recipe.getInstruction())
                .append("\n\n")
                .append(VIDEO)
                .append(recipe.getYoutube());

        return builder.toString();
    }
}