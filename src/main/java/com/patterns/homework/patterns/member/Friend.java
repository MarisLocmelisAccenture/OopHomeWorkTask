package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.util.PatternLogger;

public class Friend extends AbstractChatMember<Friend> {
    public Friend(MediatorService<?> mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        PatternLogger.printReceived(this.getClass().getSimpleName(), message.message(), message.getClass().getSimpleName());
        this.messages.add(message);
    }
}
