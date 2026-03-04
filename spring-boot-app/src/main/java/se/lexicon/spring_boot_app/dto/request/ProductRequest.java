package se.lexicon.spring_boot_app.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "Product name is required")
        @Size(min = 2, max = 200, message = "Product name must be 2-200 characters")
        String name,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = true, message = "Price must be >= 0")//safer validation for BigDecimal
        BigDecimal price,

        @NotNull(message = "Category is required")
        Long categoryId) {
}
