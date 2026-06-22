package com.patterns.homework.patterns.contract;

import com.patterns.homework.patterns.component.AbstractChatMember;

public interface Mediator {
    void send(Message message, AbstractChatMember sender);

    void addMember(AbstractChatMember member);
}
