package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.interfaces.service.MediatorService;
import com.patterns.homework.patterns.interfaces.Message;

public class Maris extends AbstractChatMember {
    public Maris(MediatorService mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        System.out.printf("Maris received message (%s)%n", message.message());
        this.messages.add(message);
    }
}
