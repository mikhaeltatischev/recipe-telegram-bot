package org.sionnach.bot.keyboard;

import org.sionnach.bot.model.Meal;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboard {

    public static InlineKeyboardMarkup mainKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Поиск по основному ингредиенту");
        inlineKeyboardButton1.setCallbackData("/ingredient");
        rowInline1.add(inlineKeyboardButton1);
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Поиск по названию блюда");
        inlineKeyboardButton2.setCallbackData("/name");
        rowInline1.add(inlineKeyboardButton2);

        rowsInline.add(rowInline1);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup mealsKeyboard(List<Meal> meals) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        for (Meal meal : meals) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(meal.getStrMeal());
            button.setCallbackData("/meal " + meal.getIdMeal());
            rowInline.add(button);

            if (rowInline.size() == 2) {
                rowsInline.add(List.copyOf(rowInline));
                rowInline.clear();
            }
        }

        if (rowsInline.isEmpty()) {
            rowsInline.add(rowInline);
        }

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }
}