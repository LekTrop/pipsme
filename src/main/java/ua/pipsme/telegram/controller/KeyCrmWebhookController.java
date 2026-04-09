package ua.pipsme.telegram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.pipsme.telegram.TelegramBotImpl;
import ua.pipsme.telegram.models.dto.KeyCrmOrder;
import ua.pipsme.telegram.service.KeyCrmService;
import ua.pipsme.telegram.service.MessageBuilder;

import java.util.Map;

@RestController
@RequestMapping("/webhook/keycrm")
@RequiredArgsConstructor
public class KeyCrmWebhookController {

    private final KeyCrmService keyCrmService;
    private final MessageBuilder messageBuilder;
    private final TelegramBotImpl telegramBot;

    @PostMapping
    public ResponseEntity<Void> handleWebhook(@RequestBody Object body) throws TelegramApiException {
        final Map<String, Object> context = (Map<String, Object>) ((Map<String, Object>) body).get("context");
        final Integer orderId = (Integer) context.get("id");

        final KeyCrmOrder order = keyCrmService.findOrderById(orderId);
        final String telegramMessage = messageBuilder.buildMessage(order);

        telegramBot.execute(
                SendMessage.builder()
                        .text(telegramMessage)
                        .chatId("-1003380541425")
                        .build()
        );

        return ResponseEntity.ok().build();
    }
}