package se.lexicon.spring_boot_app.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiErrorResponse(
        int status,
        String message,
        String errorDescription,
        LocalDateTime timestamp,
        Map<String, String> validationErrors) {


}
