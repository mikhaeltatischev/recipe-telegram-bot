package org.sionnach.bot.model;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.*;

@Setter
@Getter
public class ClassifiedUpdate {

    private TelegramType telegramType;
    private final Long userId;
    private String name;
    private String commandName;
    private final Update update;
    private final List<String> args;
    private String userName;
    private List <Meal> meals;
    private BotState botState;

    public ClassifiedUpdate(Update update) {
        this.update = update;
        this.telegramType = handleTelegramType();
        this.userId = handleUserId();
        this.args = handleArgs();
        this.commandName = handleCommandName();
    }

    public String handleCommandName() {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().startsWith("/")) {
                    return update.getMessage().getText().split(" ")[0];
                } else return update.getMessage().getText();
            }
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getData().split(" ")[0];
        }
        return "";
    }

    private TelegramType handleTelegramType() {

        if (update.hasCallbackQuery()) {
            return TelegramType.CallBack;
        }

        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().startsWith("/"))
                    return TelegramType.Command;
                else
                    return TelegramType.Text;
            } else if (update.getMessage().hasSuccessfulPayment()) {
                return TelegramType.SuccessPayment;
            } else if (update.getMessage().hasPhoto())
                return TelegramType.Photo;
        } else if (update.hasPreCheckoutQuery()) {
            return TelegramType.PreCheckoutQuery;
        } else if (update.hasChatJoinRequest()) {
            return TelegramType.ChatJoinRequest;
        } else if (update.hasChannelPost()) {
            return TelegramType.ChannelPost;
        } else if (update.hasMyChatMember()) {
            return TelegramType.MyChatMember;
        }
        if (update.getMessage().hasDocument()) {
            return TelegramType.Text;
        }
        return TelegramType.Unknown;
    }

    private Long handleUserId() {
        if (telegramType == TelegramType.PreCheckoutQuery) {
            name = getNameByUser(update.getPreCheckoutQuery().getFrom());
            userName = update.getPreCheckoutQuery().getFrom().getUserName();
            return update.getPreCheckoutQuery().getFrom().getId();
        } else if (telegramType == TelegramType.ChatJoinRequest) {
            name = getNameByUser(update.getChatJoinRequest().getUser());
            userName = update.getChatJoinRequest().getUser().getUserName();
            return update.getChatJoinRequest().getUser().getId();
        } else if (telegramType == TelegramType.CallBack) {
            name = getNameByUser(update.getCallbackQuery().getFrom());
            userName = update.getCallbackQuery().getFrom().getUserName();
            return update.getCallbackQuery().getFrom().getId();
        } else if (telegramType == TelegramType.MyChatMember) {
            name = update.getMyChatMember().getChat().getTitle();
            userName = update.getMyChatMember().getChat().getUserName();
            return update.getMyChatMember().getFrom().getId();
        } else {
            name = getNameByUser(update.getMessage().getFrom());
            userName = update.getMessage().getFrom().getUserName();
            return update.getMessage().getFrom().getId();
        }
    }

    private List<String> handleArgs() {
        List<String> list = new LinkedList<>();

        if (telegramType == TelegramType.Command) {
            String[] args = getUpdate().getMessage().getText().split(" ");
            Collections.addAll(list, args);
            list.remove(0);

            return list;
        } else if (telegramType == TelegramType.Text) {
            String[] args = getUpdate().getMessage().getText().split(" ");

            list.addAll(Arrays.asList(args));

            return list;
        } else if (telegramType == TelegramType.CallBack) {
            String[] args = getUpdate().getCallbackQuery().getData().split(" ");
            Collections.addAll(list, args);
            list.remove(0);

            return list;
        }
        return new ArrayList<>();
    }

    private String getNameByUser(User user) {
        if (user.getIsBot()) {
            return "BOT";
        }

        if (!user.getFirstName().isBlank() || !user.getFirstName().isEmpty()) {
            return user.getFirstName();
        }

        if (!user.getUserName().isBlank() || !user.getUserName().isEmpty()) {
            return user.getUserName();
        }

        return "noname";
    }

    //Лог
    public String getLog() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("USER_ID : " + getUserId());
        stringBuilder.append("\nUSER_NAME : " + getName());
        stringBuilder.append("\nTYPE : " + getTelegramType());
        stringBuilder.append("\nARGS : " + getArgs().toString());
        stringBuilder.append("\nCOMMAND_NAME : " + getCommandName());

        return stringBuilder.toString();
    }

}