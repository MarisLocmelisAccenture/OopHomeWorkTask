package com.patterns.homework.patterns.abstraction;

import com.patterns.homework.patterns.contract.MediatorInterface;
import com.patterns.homework.patterns.contract.MessageInterface;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstractChatMember {
    private final MediatorInterface mediator;
    protected final List<MessageInterface> messages = new ArrayList<>();

    public AbstractChatMember(MediatorInterface mediator) {
        this.mediator = mediator;
        mediator.addMember(this);
    }

    public void send(MessageInterface message) {
        mediator.send(message, this);
    }

    public abstract void receive(MessageInterface message);
}
