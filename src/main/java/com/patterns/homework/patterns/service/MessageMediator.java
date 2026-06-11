package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;
import com.patterns.homework.patterns.contract.MediatorInterface;
import com.patterns.homework.patterns.contract.MessageInterface;
import java.util.ArrayList;
import java.util.List;

public final class MessageMediator implements MediatorInterface {
    //Singleton
    public static MessageMediator instance;
    public static MessageMediator getInstance() {
        if (instance == null) {
            instance = new MessageMediator();
        }

        return instance;
    }

    private MessageMediator() {

    }

    private final List<AbstractChatMember> members = new ArrayList<>();
    @Override
    public void send(MessageInterface message, AbstractChatMember sender) {
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
