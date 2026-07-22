package com.patterns.homework.patterns.service;

import com.patterns.homework.patterns.member.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverServiceImpl implements ObserverService {
    List<Observer> observers = new ArrayList<>();

    public void notifyObservers(String event) {
        observers.forEach(observer -> observer.update(event));
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
