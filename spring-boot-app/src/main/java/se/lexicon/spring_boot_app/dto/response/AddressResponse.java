package se.lexicon.spring_boot_app.dto.response;

public record AddressResponse(
        String street,
        String city,
        String zipcode
) {}
