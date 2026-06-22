package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.interfaces.ChatMember;
import com.patterns.homework.patterns.interfaces.MediatorService;
import com.patterns.homework.patterns.interfaces.Message;

public class Friend extends AbstractChatMember implements ChatMember {
    public Friend(MediatorService mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        this.messages.add(message);
    }
}
