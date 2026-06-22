package com.patterns.homework.patterns.contract;

import com.patterns.homework.patterns.component.AbstractChatMember;

public interface Message {
    String message();
    boolean canReceive(AbstractChatMember potentialReceiver);
}
