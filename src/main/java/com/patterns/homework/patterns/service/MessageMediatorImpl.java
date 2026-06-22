package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.component.AbstractChatMember;
import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.contract.Message;
import java.util.ArrayList;
import java.util.List;

public final class MessageMediatorImpl implements Mediator {
    //Singleton
    public static MessageMediatorImpl instance;
    public static MessageMediatorImpl getInstance() {
        if (instance == null) {
            instance = new MessageMediatorImpl();
        }

        return instance;
    }

    private MessageMediatorImpl() {

    }

    private final List<AbstractChatMember> members = new ArrayList<>();
    @Override
    public void send(Message message, AbstractChatMember sender) {
        members.forEach((receiver) -> {
            if (receiver == sender) {
                return;
            }

            if (! message.canReceive(receiver)) {
                return;
            }

            receiver.receive(message);
        });
    }

    @Override
    public void addMember(AbstractChatMember member) {
        members.add(member);
    }
}
