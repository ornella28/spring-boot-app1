package se.lexicon.spring_boot_app.dto.response;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, BigDecimal price, String categoryName) {
}
