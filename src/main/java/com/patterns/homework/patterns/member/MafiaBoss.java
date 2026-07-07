package com.patterns.homework.patterns.member;

import com.patterns.homework.patterns.util.PatternLogger;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MafiaBoss {
    private final List<String> stolenInfo = new ArrayList<>();

    public void provideInfo(String stolenMessage) {
        stolenInfo.add(stolenMessage);
        PatternLogger.printObservation("MafiaBoss collected info: \"" + stolenMessage + "\" [Total collected: " + stolenInfo.size() + "]");
    }
}
