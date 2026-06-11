package com.patterns.homework.patterns.contract;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;

public interface MediatorInterface {
    void send(MessageInterface message, AbstractChatMember sender);

    void addMember(AbstractChatMember member);
}
