package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.member.ChatMember;

public record LaudMessage(String message) implements Message {

    @Override
    public boolean canReceive(ChatMember<?> potentialReceiver) {
        return true;
    }
}
