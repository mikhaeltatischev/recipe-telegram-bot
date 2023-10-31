package org.sionnach.bot.builder;

import lombok.SneakyThrows;
import org.sionnach.bot.client.TranslateClient;
import org.sionnach.bot.client.impl.TranslateClientImpl;
import org.sionnach.bot.keyboard.InlineKeyboard;
import org.sionnach.bot.keyboard.ReplyKeyboardMaker;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.BotState;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.Meal;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

public class SendMessageBuilder {

    private static final String START_MESSAGE = """
            Привет!\s
            Этот бот поможет тебе с поиском рецептов любых блюд
            Ниже ты можешь выбрать способ поиска рецепта""";
    private static final String INGREDIENT_MESSAGE = "Введите основной ингредиент блюда";
    private static final String NOT_FOUND_MESSAGE = "Рецепты не найдены. Попробуйте ещё раз";
    private static final String MEALS_MESSAGE = "Подобранные рецепты";
    private static final String NAME_MESSAGE = "Введите название блюда";
    private static final String INGREDIENTS = "Ингредиенты:\n";
    private static final String INSTRUCTION = "Способ приготовления - ";
    private static final String VIDEO = "Видео приготовления (английский язык) - ";
    private static final String AREA = "Происхождение - ";
    private static final String CATEGORY = "Категория - ";

    private final TranslateClient client;
    private SendMessage sendMessage;

    public SendMessageBuilder() {
        this.sendMessage = new SendMessage();
        this.client = new TranslateClientImpl();
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

    public Answer buildMeal(ClassifiedUpdate update) {
        List<Meal> meals = update.getMeals();

        if (meals == null || meals.isEmpty()) {
            return createAnswer(NOT_FOUND_MESSAGE);
        }

        if (meals.size() > 1) {
            update.setBotState(BotState.WAITING_ID);
            return createAnswer(MEALS_MESSAGE, InlineKeyboard.mealsKeyboard(meals));
        } else {
            update.setBotState(BotState.DEFAULT);
            String recipe = createRecipeString(meals.get(0));
            return createAnswer(recipe);
        }
    }

    @SneakyThrows
    public Answer buildIngredients() {
        return createAnswer(INGREDIENT_MESSAGE);
    }

    @SneakyThrows
    public Answer buildName() {
        return createAnswer(NAME_MESSAGE);
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
        sendMessage.setReplyMarkup(ReplyKeyboardMaker.getMainMenuKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    private String createRecipeString(Meal meal) {
        StringBuilder builder = new StringBuilder();

        builder.append(meal.getStrMeal())
                .append("\n\n")
                .append(CATEGORY)
                .append(meal.getStrCategory())
                .append("\n\n")
                .append(AREA)
                .append(meal.getStrArea())
                .append("\n\n")
                .append(INGREDIENTS);

        List<String> ingredients = meal.getIngredients();
        List<String> measures = meal.getMeasures();

        for (int i = 0; i < ingredients.size(); i++) {
            builder.append(ingredients.get(i))
                    .append(" - ")
                    .append(measures.get(i))
                    .append("\n");
            if (i == ingredients.size() - 1) {
                builder.append("\n");
            }
        }

        builder.append(INSTRUCTION)
                .append(meal.getStrInstructions())
                .append("\n\n")
                .append(VIDEO)
                .append(meal.getStrYoutube());

        return client.translateText(builder.toString());
    }
}