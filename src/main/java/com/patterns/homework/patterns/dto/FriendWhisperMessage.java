package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.member.ChatMember;
import com.patterns.homework.patterns.member.Bandit;

public record FriendWhisperMessage(String message) implements Message {

    @Override
    public boolean canReceive(ChatMember<?> potentialReceiver) {
        return !(potentialReceiver instanceof Bandit);
    }
}
