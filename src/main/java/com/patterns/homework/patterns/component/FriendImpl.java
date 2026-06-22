package com.patterns.homework.patterns.component;

import com.patterns.homework.patterns.contract.ChatMember;
import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.contract.Message;

public class FriendImpl extends AbstractChatMember implements ChatMember {
    public FriendImpl(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        this.messages.add(message);
    }
}
