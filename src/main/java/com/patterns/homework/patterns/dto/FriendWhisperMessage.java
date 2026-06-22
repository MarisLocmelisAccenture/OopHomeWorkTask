package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.contract.Message;
import com.patterns.homework.patterns.component.AbstractChatMember;
import com.patterns.homework.patterns.component.FriendImpl;
import com.patterns.homework.patterns.component.MarisImpl;

public record FriendWhisperMessage(String message) implements Message {

    @Override
    public boolean canReceive(AbstractChatMember potentialReceiver) {
        return potentialReceiver instanceof FriendImpl || potentialReceiver instanceof MarisImpl;
    }
}
