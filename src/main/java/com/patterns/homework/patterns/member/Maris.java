package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.contract.MediatorService;
import com.patterns.homework.patterns.contract.Message;

public class Maris extends AbstractChatMember {
    public Maris(MediatorService mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        this.messages.add(message);
    }
}
