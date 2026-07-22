package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.member.ChatMember;

public interface MediatorService<T> {
    void send(Message message, ChatMember<?> sender);

    T addMember(ChatMember<?> member);
    void clearMembers();
}
