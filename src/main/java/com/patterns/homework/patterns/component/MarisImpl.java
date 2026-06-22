package com.patterns.homework.patterns.component;

import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.contract.Message;

public class MarisImpl extends AbstractChatMember {
    public MarisImpl(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        this.messages.add(message);
    }
}
