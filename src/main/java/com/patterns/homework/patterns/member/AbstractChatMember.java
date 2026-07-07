package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.util.PatternLogger;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractChatMember implements ChatMember {
    private final MediatorService mediator;
    protected final List<Message> messages = new ArrayList<>();

    public AbstractChatMember(MediatorService mediator) {
        this.mediator = mediator;
        mediator.addMember(this);
    }

    public void send(Message message) {
        PatternLogger.printSent(this.getClass().getSimpleName(), message.message());
        PatternLogger.printMediation("Routing message (type: " + message.getClass().getSimpleName() + ") through mediator");
        mediator.send(message, this);
    }

    public abstract void receive(Message message);
}
