package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.contract.ChatMember;
import com.patterns.homework.patterns.contract.MediatorService;
import com.patterns.homework.patterns.contract.Message;

public class Friend extends AbstractChatMember implements ChatMember {
    public Friend(MediatorService mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        this.messages.add(message);
    }
}
