package ua.pipsme.telegram.models.mapper;

import java.util.Map;

public class OrderStatusMapper {

    private static final Map<String, String> STATUS_MAP = Map.of(
            "new", "🆕 Новый заказ",
            "in_progress", "⏳ В работе",
            "transferred_to_production", "Очікує відправлення",
            "shipped", "🚚 Отправлен",
            "delivered", "📦 Доставлен",
            "canceled", "❌ Отменён"
    );

    public static String map(String status) {
        return STATUS_MAP.getOrDefault(status, status);
    }
}