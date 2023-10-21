package org.sionnach.bot.keyboard;

import org.sionnach.bot.model.Recipe;
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
        inlineKeyboardButton1.setText("Поиск по ингредиентам");
        inlineKeyboardButton1.setCallbackData("/ingredients");
        rowInline1.add(inlineKeyboardButton1);
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Поиск по названию блюда");
        inlineKeyboardButton2.setCallbackData("/name");
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Популярные рецепты");
        inlineKeyboardButton3.setCallbackData("/popular");
        rowInline2.add(inlineKeyboardButton3);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup popularKeyboard(List<Recipe> recipes) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        for (Recipe recipe : recipes) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(recipe.getName());
            button.setCallbackData("/recipe " + recipe.getId());
            rowInline.add(button);

            if (rowInline.size() == 2) {
                rowsInline.add(rowInline);
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