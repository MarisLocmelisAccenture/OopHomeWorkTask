package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.dto.Message;

public interface ChatMember<T> {
    T send(Message message);

    void receive(Message message);
}
