package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;
import com.patterns.homework.patterns.service.Friend;
import com.patterns.homework.patterns.service.Maris;

public class FriendWhisperMessage extends AbstractMessage {

    public FriendWhisperMessage(String message) {
        super(message);
    }

    @Override
    public boolean canReceive(AbstractChatMember potentialReceiver) {
        return potentialReceiver instanceof Friend || potentialReceiver instanceof Maris;
    }
}
