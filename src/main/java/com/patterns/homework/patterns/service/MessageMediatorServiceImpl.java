package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.member.ChatMember;
import com.patterns.homework.patterns.util.PatternLogger;

import java.util.ArrayList;
import java.util.List;

public final class MessageMediatorServiceImpl implements MediatorService<MessageMediatorServiceImpl> {
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

    private final List<ChatMember<?>> members = new ArrayList<>();

    @Override
    public void send(Message message, ChatMember<?> sender) {
        members.forEach((receiver) -> {
            if (receiver == sender) {
                return;
            }

            if (!message.canReceive(receiver)) {
                PatternLogger.printWarning("Message blocked from reaching " + receiver.getClass().getSimpleName() + " (access denied by message filter)");
                return;
            }

            PatternLogger.printMediation("Routing message from " + sender.getClass().getSimpleName() + " to " + receiver.getClass().getSimpleName());
            receiver.receive(message);
        });
    }

    @Override
    public MessageMediatorServiceImpl addMember(ChatMember<?> member) {
        members.add(member);
        PatternLogger.printInfo("✓ Member registered: " + member.getClass().getSimpleName() + " [Total: " + members.size() + "]");
        return this;
    }
}
