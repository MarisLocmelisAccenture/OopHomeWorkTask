package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.interfaces.ChatMember;
import com.patterns.homework.patterns.interfaces.MediatorService;
import com.patterns.homework.patterns.interfaces.Message;
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
        mediator.send(message, this);
    }

    public abstract void receive(Message message);
}
