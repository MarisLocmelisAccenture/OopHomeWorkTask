package com.patterns.homework.patterns.member;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//Observer
@Getter
public class MafiaBoss {
    private final List<String> stolenInfo = new ArrayList<>();

    public void provideInfo(String stolenMessage) {
        stolenInfo.add(stolenMessage);
        System.out.printf("Mafia Boss as observer heard information (%s)%n", stolenMessage);
    }

}
