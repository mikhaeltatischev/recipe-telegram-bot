package org.sionnach.bot.builder;

import lombok.SneakyThrows;
import org.sionnach.bot.keyboard.InlineKeyboard;
import org.sionnach.bot.model.Answer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class SendMessageBuilder {

    private static final String START_MESSAGE = "Hello";

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

    private void checkChatId(String chatId) throws Exception {
        if (chatId == null) {
            throw new Exception("Id must be not null");
        }
    }
}