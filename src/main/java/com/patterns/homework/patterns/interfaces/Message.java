package com.patterns.homework.patterns.interfaces;

import com.patterns.homework.patterns.member.AbstractChatMember;

public interface Message {
    String message();
    boolean canReceive(AbstractChatMember potentialReceiver);
}
