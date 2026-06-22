package com.patterns.homework.patterns.contract;

import com.patterns.homework.patterns.member.AbstractChatMember;

public interface MediatorService {
    void send(Message message, AbstractChatMember sender);

    void addMember(AbstractChatMember member);
}
