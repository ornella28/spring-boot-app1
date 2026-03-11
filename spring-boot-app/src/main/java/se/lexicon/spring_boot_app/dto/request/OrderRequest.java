package se.lexicon.spring_boot_app.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(
        @NotNull(message = "Customer Id is required")
        Long customerId,

        @NotEmpty(message = "Order must contain at least one item")
        List<OrderItemRequest> items
        ) {
}
