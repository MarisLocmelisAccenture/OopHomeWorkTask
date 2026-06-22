package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.contract.Message;
import com.patterns.homework.patterns.member.AbstractChatMember;

public record LaudMessage(String message) implements Message {

    @Override
    public boolean canReceive(AbstractChatMember potentialReceiver) {
        return true;
    }
}
