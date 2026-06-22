package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.interfaces.Message;
import com.patterns.homework.patterns.member.AbstractChatMember;
import com.patterns.homework.patterns.member.Friend;
import com.patterns.homework.patterns.member.Maris;

public record FriendWhisperMessage(String message) implements Message {

    @Override
    public boolean canReceive(AbstractChatMember potentialReceiver) {
        return potentialReceiver instanceof Friend || potentialReceiver instanceof Maris;
    }
}
