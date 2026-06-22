package com.patterns.homework.patterns.component;

import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.contract.Message;

//Decorator or Proxy
public class BanditImpl extends FriendImpl {
    private final MafiaBoss boss;
    public BanditImpl(Mediator mediator, MafiaBoss boss) {
        super(mediator);
        this.boss = boss;
    }

    @Override
    public void receive(Message message) {
        boss.provideInfo(message.message());
        super.receive(message);
    }
}
