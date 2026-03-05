package se.lexicon.spring_boot_app.dto.response;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long productId,
        String productName,
        int quantity,
        BigDecimal priceAtPurchase
) {
}
