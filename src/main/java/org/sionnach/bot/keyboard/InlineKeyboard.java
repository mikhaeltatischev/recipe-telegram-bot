package org.sionnach.bot.keyboard;

import org.sionnach.bot.model.Dates;
import org.sionnach.bot.model.Times;
import org.sionnach.bot.model.Master;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboard {

    private static final String DIKIDI_MESSAGE = "Запись через Dikidi";

    public static InlineKeyboardMarkup serviceKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(Keys.MANICURE.getValue());
        inlineKeyboardButton1.setCallbackData(Links.MANICURE.getValue());
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText(Keys.PEDICURE.getValue());
        inlineKeyboardButton2.setCallbackData(Links.PEDICURE.getValue());
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText(Keys.BROWS.getValue());
        inlineKeyboardButton3.setCallbackData(Links.BROWS.getValue());
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText(Keys.LASHES.getValue());
        inlineKeyboardButton4.setCallbackData(Links.LASHES.getValue());
        rowInline2.add(inlineKeyboardButton3);
        rowInline2.add(inlineKeyboardButton4);

        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        inlineKeyboardButton5.setText(DIKIDI_MESSAGE);
        inlineKeyboardButton5.setUrl("https://dikidi.ru/ru/profile/sionnach_829086");
        rowInline3.add(inlineKeyboardButton5);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup manicureKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(Keys.COMB_MANICURE.getValue());
        inlineKeyboardButton1.setCallbackData(Links.COMB_MANICURE.getValue());
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText(Keys.DESIGN_MANICURE.getValue());
        inlineKeyboardButton2.setCallbackData(Links.DESIGN_MANICURE.getValue());
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText(Keys.STRENGTH_MANICURE.getValue());
        inlineKeyboardButton3.setCallbackData(Links.STRENGTH_MANICURE.getValue());
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton4.setText(Keys.EXTENSION_MANICURE.getValue());
        inlineKeyboardButton4.setCallbackData(Links.EXTENSION_MANICURE.getValue());
        rowInline2.add(inlineKeyboardButton3);
        rowInline2.add(inlineKeyboardButton4);

        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        inlineKeyboardButton5.setText(Keys.PLAIN_MANICURE.getValue());
        inlineKeyboardButton5.setCallbackData(Links.PLAIN_MANICURE.getValue());
        rowInline3.add(inlineKeyboardButton5);

        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        rowInline4.add(createStartButton());

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup browsKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Коррекция бровей");
        inlineKeyboardButton1.setCallbackData("Коррекция бровей");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Коррекция бровей + окрашивание");
        inlineKeyboardButton2.setCallbackData("Коррекция бровей + окрашивание");
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Ламинирование бровей + окрашивание");
        inlineKeyboardButton3.setCallbackData("Ламинирование бровей + окрашивание");
        rowInline2.add(inlineKeyboardButton3);

        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        rowInline3.add(createStartButton());

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup pedicureKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Обработка пальчиков с покрытием");
        inlineKeyboardButton1.setCallbackData("Обработка пальчиков с покрытием");
        rowInline1.add(inlineKeyboardButton1);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Полный педикюр без покрытия");
        inlineKeyboardButton2.setCallbackData("Полный педикюр без покрытия");
        rowInline2.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton3.setText("Полный педикюр с покрытием");
        inlineKeyboardButton3.setCallbackData("Полный педикюр с покрытием");
        rowInline3.add(inlineKeyboardButton3);

        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        rowInline4.add(createStartButton());

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup lashesKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Ресницы");
        inlineKeyboardButton1.setCallbackData("Ресницы");
        rowInline1.add(inlineKeyboardButton1);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        rowInline2.add(createStartButton());

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup manicuristKeyboard(String data) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Дарья");
        inlineKeyboardButton1.setCallbackData(data + MasterName.DARIYA.getValue());
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Анна");
        inlineKeyboardButton2.setCallbackData(data + MasterName.ANNA.getValue());
        rowInline1.add(inlineKeyboardButton1);
        rowInline1.add(inlineKeyboardButton2);

        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        rowInline2.add(createManicureButton());

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup daysKeyboard(Dates dates, String data) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        for (String date : dates.getDatesTrue()) {
            if (row.size() == 4) {
                rowsInline.add(List.copyOf(row));
                row.clear();
            }

            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(date);
            inlineKeyboardButton.setCallbackData(data + "/" + date);
            row.add(inlineKeyboardButton);
        }

        List<InlineKeyboardButton> lastRow = new ArrayList<>();
        lastRow.add(createManicureButton());

        if (rowsInline.size() == 0) {
            rowsInline.add(row);
        }

        rowsInline.add(lastRow);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup timesKeyboard(Times times, String data) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        for (String time : times.getMaster()) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(time);
            inlineKeyboardButton.setCallbackData(data + "/" + time);
            row.add(inlineKeyboardButton);

            if (row.size() == 2) {
                rowsInline.add(List.copyOf(row));
                row.clear();
            }
        }

        List<InlineKeyboardButton> lastRow = new ArrayList<>();
        lastRow.add(createManicureButton());

        if (rowsInline.size() == 0) {
            rowsInline.add(row);
        }

        rowsInline.add(lastRow);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup mastersKeyboard(List<Master> masters, String data) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        for (Master master : masters) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(master.getRussianName());
            inlineKeyboardButton.setCallbackData(data + "/" + master.getName());
            rowsInline.add(List.of(inlineKeyboardButton));
        }

        List<InlineKeyboardButton> lastRow = new ArrayList<>();
        lastRow.add(createManicureButton());

        rowsInline.add(lastRow);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public static InlineKeyboardMarkup profileKeyboard() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Создать профиль");
        button.setCallbackData("/profile/create");
        row.add(button);

        rowsInline.add(row);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    private static InlineKeyboardButton createStartButton() {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Назад");
        inlineKeyboardButton.setCallbackData("/start");

        return inlineKeyboardButton;
    }

    private static InlineKeyboardButton createManicureButton() {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Назад");
        inlineKeyboardButton.setCallbackData("/manicure");

        return inlineKeyboardButton;
    }

    private static InlineKeyboardButton createMasterButton() {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Назад");
        inlineKeyboardButton.setCallbackData("/manicure/type");

        return inlineKeyboardButton;
    }
}