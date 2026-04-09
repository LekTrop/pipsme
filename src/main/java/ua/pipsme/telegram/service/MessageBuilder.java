package ua.pipsme.telegram.service;

import org.springframework.stereotype.Component;
import ua.pipsme.telegram.models.dto.AssignedUser;
import ua.pipsme.telegram.models.dto.KeyCrmOrder;
import ua.pipsme.telegram.models.dto.Product;
import ua.pipsme.telegram.models.dto.Property;

import java.util.List;
import java.util.Optional;

@Component
public class MessageBuilder {

    public String buildMessage(final KeyCrmOrder order) {

        final StringBuilder products = new StringBuilder();

        for (Product p : order.getProducts()) {

            String size = "";
            String color = "";

            if (p.getProperties() != null) {
                for (final Property prop : p.getProperties()) {

                    if ("Розмір".equalsIgnoreCase(prop.getName())) {
                        size = prop.getValue();
                    }

                    if ("Колір".equalsIgnoreCase(prop.getName())) {
                        color = prop.getValue();
                    }
                }
            }

            products.append("• ")
                    .append(p.getName())
                    .append(" | ").append(size)
                    .append(" | ").append(color)
                    .append(" | ").append(p.getPrice()).append(" грн")
                    .append(" x").append(p.getQuantity())
                    .append("\n");
        }

        return String.format("""
                        
                        🚚 ТТН: %s
                        
                        📝 Комментарий:
                        %s
                        
                        📦 Товары:
                        %s
                        
                        👨‍💼 Менеджер: %s
                        
                        👤 Получатель: %s
                        📞 %s
                        
                        💰 Сумма: %.0f грн
                        """,
//                order.getId().intValue() + 197,

                order.getShipping().getTrackingCode(),

                order.getManagerComment(),

                products,

                Optional.ofNullable(order.getAssigned())
                        .filter(assignedUsers ->  !assignedUsers.isEmpty())
                        .map(List::getFirst)
                        .map(AssignedUser::getFullName)
                        .orElse(order.getManager().getFullName()),

                order.getShipping().getRecipientFullName(),
                order.getShipping().getRecipientPhone(),

                order.getGrandTotal()
        );
    }
}
