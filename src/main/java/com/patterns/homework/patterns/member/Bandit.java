package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.util.PatternLogger;

public class Bandit extends Friend {
    private final MafiaBoss boss;

    public Bandit(MediatorService mediator, MafiaBoss boss) {
        super(mediator);
        this.boss = boss;
    }

    @Override
    public void receive(Message message) {
        PatternLogger.printReceived(this.getClass().getSimpleName(), message.message(), message.getClass().getSimpleName());
        PatternLogger.printDecoration("Bandit (Decorator) is forwarding info to MafiaBoss");
        boss.provideInfo(message.message());
        this.messages.add(message);
    }
}
