package com.usercard.error;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageAccessor {
    private final MessageSource messageSource;

    public String getMessage(String code, List<Object> params) {
        String message;
        try {
            message = buildMessage(code, params);
            if (message.equals(code)) {
                buildMessage(MessageConstants.UNEXPECTED_ERROR, params);
            }
        } catch (NoSuchMessageException ex) {
            message = buildMessage(MessageConstants.UNEXPECTED_ERROR, params);
        }
        return message;
    }

    private String buildMessage(String code, List<Object> params) {
        return messageSource.getMessage(
            code,
            parseParams(params),
            new Locale("pt", "BR")
        );
    }

    private Object[] parseParams(List<Object> params) {
        if (CollectionUtils.isEmpty(params)) {
            return new Object[]{};
        }
        return new Object[]{params};
    }
}
