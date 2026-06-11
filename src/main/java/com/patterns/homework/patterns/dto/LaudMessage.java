package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;

public class LaudMessage extends AbstractMessage {

    public LaudMessage(String message) {
        super(message);
    }

    @Override
    public boolean canReceive(AbstractChatMember potentialReceiver) {
        return true;
    }
}
