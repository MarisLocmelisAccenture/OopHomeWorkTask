package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.contract.MessageInterface;
import lombok.Getter;

@Getter
public abstract class AbstractMessage implements MessageInterface {
    private final String message;

    public AbstractMessage(String message) {
        this.message = message;
    }

}
