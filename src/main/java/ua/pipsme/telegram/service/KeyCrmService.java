package ua.pipsme.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.pipsme.telegram.models.dto.KeyCrmOrder;
import ua.pipsme.telegram.models.dto.KeyCrmOrderResponse;

@Service
@RequiredArgsConstructor
public class KeyCrmService {

    private final RestTemplate restTemplate;

    private static final String TOKEN = "Y2E2MzdmNmQ5YzliYzY4YTBjZWZmNWFjOWMyYTc5MGRjNGY3MzE4Mw";

    public KeyCrmOrder findOrderById(Integer orderId) {

        final String url = "https://openapi.keycrm.app/v1/order/" + orderId +
                "?include=products.offer,manager,status,shipping.deliveryService,assigned";

        final HttpHeaders headers = getHttpHeaders();
        final HttpEntity<Void> entity = new HttpEntity<>(headers);

        final ResponseEntity<KeyCrmOrder> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                KeyCrmOrder.class
        );

        return response.getBody();
    }

    private static HttpHeaders getHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}