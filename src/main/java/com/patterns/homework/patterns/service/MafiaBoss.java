package com.patterns.homework.patterns.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//Observer
@Getter
public class MafiaBoss {
    private final List<String> stolenInfo = new ArrayList<>();

    public void provideInfo(String stolenMessage) {
        stolenInfo.add(stolenMessage);
    }

}
