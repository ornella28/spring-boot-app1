package se.lexicon.spring_boot_app.dto.response;

import se.lexicon.spring_boot_app.dto.request.OrderItemRequest;
import se.lexicon.spring_boot_app.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public record OrderResponse(
        Long id,
        Instant orderDate,
        OrderStatus status,
        Long customerId,
        List<OrderItemResponse> items
) {
}
