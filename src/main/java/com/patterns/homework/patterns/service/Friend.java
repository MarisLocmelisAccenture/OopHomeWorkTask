package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;
import com.patterns.homework.patterns.contract.MediatorInterface;
import com.patterns.homework.patterns.contract.MessageInterface;

public class Friend extends AbstractChatMember {
    public Friend(MediatorInterface mediator) {
        super(mediator);
    }

    @Override
    public void receive(MessageInterface message) {
        this.messages.add(message);
    }
}
