package ua.pipsme.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ua.pipsme.telegram.config.TelegramBotConfiguration;


@Component
@Slf4j
public class TelegramBotImpl extends TelegramLongPollingBot {

    private final TelegramBotConfiguration telegramBotConfiguration;

    public TelegramBotImpl(final TelegramBotConfiguration telegramBotConfiguration,
                           final DefaultBotOptions defaultBotOptions) {
        super(defaultBotOptions, telegramBotConfiguration.getToken());
        this.telegramBotConfiguration = telegramBotConfiguration;
    }

    @Override
    public void onUpdateReceived(final Update update) {

    }

    @Override
    public String getBotUsername() {
        return telegramBotConfiguration.getName();
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        super.clearWebhook();
    }


}