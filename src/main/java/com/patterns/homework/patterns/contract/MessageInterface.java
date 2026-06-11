package com.patterns.homework.patterns.contract;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;

public interface MessageInterface {
    String getMessage();
    boolean canReceive(AbstractChatMember potentialReceiver);
}
