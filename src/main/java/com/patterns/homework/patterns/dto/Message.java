package com.patterns.homework.patterns.dto;

import com.patterns.homework.patterns.member.ChatMember;

public interface Message {
    String message();

    boolean canReceive(ChatMember<?> potentialReceiver);
}
