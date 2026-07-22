package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.member.Observer;

public interface ObserverService {
    void notifyObservers(String event);

    void addObserver(Observer observer);
}
