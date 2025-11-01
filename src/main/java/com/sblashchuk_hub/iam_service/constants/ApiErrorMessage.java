package com.sblashchuk_hub.iam_service.constants;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {
    POST_NOT_FOUND_BY_ID("Post with ID: %s was not found"),
    ;

    private String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
