package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.member.AbstractChatMember;

public interface MediatorService {
    void send(Message message, AbstractChatMember sender);

    void addMember(AbstractChatMember member);
}
