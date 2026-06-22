package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.member.AbstractChatMember;
import com.patterns.homework.patterns.interfaces.MediatorService;
import com.patterns.homework.patterns.interfaces.Message;
import java.util.ArrayList;
import java.util.List;

public final class MessageMediatorServiceImpl implements MediatorService {
    //Singleton
    public static MessageMediatorServiceImpl instance;
    public static MessageMediatorServiceImpl getInstance() {
        if (instance == null) {
            instance = new MessageMediatorServiceImpl();
        }

        return instance;
    }

    private MessageMediatorServiceImpl() {

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
