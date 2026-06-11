package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.contract.MediatorInterface;
import com.patterns.homework.patterns.contract.MessageInterface;

//Decorator or Proxy
public class Bandit extends Friend {
    private final MafiaBoss boss;
    public Bandit(MediatorInterface mediator, MafiaBoss boss) {
        super(mediator);
        this.boss = boss;
    }

    @Override
    public void receive(MessageInterface message) {
        boss.provideInfo(message.getMessage());
        super.receive(message);
    }
}
