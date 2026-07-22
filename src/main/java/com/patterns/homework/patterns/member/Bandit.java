package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.service.ObserverService;
import com.patterns.homework.patterns.util.PatternLogger;

public class Bandit extends Friend {
    private final ObserverService observerService;

    public Bandit(MediatorService mediator, ObserverService observerService) {
        super(mediator);
        this.observerService = observerService;
    }

    @Override
    public void receive(Message message) {
        PatternLogger.printReceived(this.getClass().getSimpleName(), message.message(), message.getClass().getSimpleName());
        PatternLogger.printDecoration("Bandit (Decorator) is forwarding info to MafiaBoss");
        observerService.notifyObservers(message.message());
        this.messages.add(message);
    }
}
