package se.lexicon.spring_boot_app.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequest(
        @NotNull(message = "Product Id is required")
        Long id,

        @Min(value = 1, message = "Quantity must be at least 1")
        int quantity
) {
}
