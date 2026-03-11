package se.lexicon.spring_boot_app.dto.response;

public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        AddressResponse addressResponse
        ) {
}
