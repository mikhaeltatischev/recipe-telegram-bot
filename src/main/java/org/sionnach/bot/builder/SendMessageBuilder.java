package org.sionnach.bot.builder;

import lombok.SneakyThrows;
import org.sionnach.bot.keyboard.ReplyKeyboardMaker;
import org.sionnach.bot.model.Dates;
import org.sionnach.bot.model.Times;
import org.sionnach.bot.keyboard.InlineKeyboard;
import org.sionnach.bot.keyboard.Links;
import org.sionnach.bot.model.Answer;
import org.sionnach.bot.model.Master;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

public class SendMessageBuilder {

    private static final String START_MESSAGE = """
            Вас приветствует студия красоты Sionnach\s
            Создайте профиль, для того, чтобы получить возможность записи""";
    private static final String SERVICE_MESSAGE = "Ниже вы можете выбрать услугу, на которую хотели бы записаться";
    private static final String TYPE_MANICURE_MESSAGE = "Выберите тип маникюра";
    private static final String TYPE_MESSAGE = "Выберите тип услуги";
    private static final String TYPE_PEDICURE_MESSAGE = "Выберите тип педикюра";
    private static final String MANICURIST_CHOICE = "Выберите мастера маникюра";
    private static final String DATE_CHOICE = "Выберите дату";
    private static final String TIME_CHOICE = "Выберите время";
    private static final String DATE_NOT_FOUND = "У мастера нет окошек для этой услуги";
    private static final String MASTERS_NOT_FOUND = "К сожалению в данный момент нет мастера, который выполняет данную " +
            "услугу";

    private SendMessage sendMessage;

    public SendMessageBuilder() {
        this.sendMessage = new SendMessage();
    }

    public SendMessageBuilder chatId(Long chatId) {
        this.sendMessage.setChatId(chatId);
        return this;
    }

    @SneakyThrows
    public Answer buildStart() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(START_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.profileKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    public Answer buildSuccess(String text) {
        Answer answer = new Answer();
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(ReplyKeyboardMaker.getMainMenuKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildProfileCreate() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText("Введите настоящие фамилию, имя, номер телефона. \n" +
                "В формате \"Фамилия Имя 79999999999\"");
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildServices() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(SERVICE_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.serviceKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildManicureType() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(TYPE_MANICURE_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.manicureKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildBrowsType() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(TYPE_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.browsKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildPedicureType() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(TYPE_PEDICURE_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.pedicureKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildLashesType() {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        sendMessage.setText(TYPE_MESSAGE);
        sendMessage.setReplyMarkup(InlineKeyboard.lashesKeyboard());
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildManicuristChoice(String command, List<Master> masters) {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();

        if (masters == null) {
            sendMessage.setText(MASTERS_NOT_FOUND);
            sendMessage.setReplyMarkup(InlineKeyboard.manicuristKeyboard("/manicure"));
            answer.setBotApiMethod(sendMessage);
            return answer;
        }

        sendMessage.setText(MANICURIST_CHOICE);
        sendMessage.setReplyMarkup(InlineKeyboard.mastersKeyboard(masters, command));
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildDaysChoice(String command, Dates dates) {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();
        
        if (dates == null) {
            sendMessage.setText(DATE_NOT_FOUND);
            sendMessage.setReplyMarkup(InlineKeyboard.manicuristKeyboard(Links.EXTENSION_MANICURE.getValue()));
            answer.setBotApiMethod(sendMessage);
            return answer;
        }

        sendMessage.setText(DATE_CHOICE);
        sendMessage.setReplyMarkup(InlineKeyboard.daysKeyboard(dates, command));
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    @SneakyThrows
    public Answer buildTimesChoice(String command, Times times) {
        checkChatId(sendMessage.getChatId());

        Answer answer = new Answer();

        if (times == null) {
            sendMessage.setText(DATE_NOT_FOUND);
            sendMessage.setReplyMarkup(InlineKeyboard.manicuristKeyboard(Links.EXTENSION_MANICURE.getValue()));
            answer.setBotApiMethod(sendMessage);
            return answer;
        }

        sendMessage.setText(TIME_CHOICE);
        sendMessage.setReplyMarkup(InlineKeyboard.timesKeyboard(times, command));
        answer.setBotApiMethod(sendMessage);

        return answer;
    }

    private void checkChatId(String chatId) throws Exception {
        if (chatId == null) {
            throw new Exception("Id must be not null");
        }
    }
}