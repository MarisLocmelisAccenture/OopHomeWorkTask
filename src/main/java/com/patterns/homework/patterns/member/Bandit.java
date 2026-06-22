package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.interfaces.service.MediatorService;
import com.patterns.homework.patterns.interfaces.Message;

//Decorator or Proxy
public class Bandit extends Friend {
    private final MafiaBoss boss;
    public Bandit(MediatorService mediator, MafiaBoss boss) {
        super(mediator);
        this.boss = boss;
    }

    @Override
    public void receive(Message message) {
        boss.provideInfo(message.message());
        super.receive(message);
    }
}
