package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.dto.Message;

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
        System.out.println("Bandit as Decorated friend heard and shared information with Boss");
        this.messages.add(message);
    }
}
