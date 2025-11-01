package com.sblashchuk_hub.iam_service.constants;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiLogMessage {
    POST_INFO_BY_ID("Receiving post with ID: %s"),
    ;

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
