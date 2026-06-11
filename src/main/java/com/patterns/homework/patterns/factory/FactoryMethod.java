package com.patterns.homework.patterns.factory;

import com.patterns.homework.patterns.contract.MessageInterface;
import com.patterns.homework.patterns.dto.FriendWhisperMessage;
import com.patterns.homework.patterns.dto.LaudMessage;

public class FactoryMethod {
    public static MessageInterface createFromString(String message) {
        return createFromString(message, false);
    }


    public static MessageInterface createFromString(String message, boolean whisper) {
        if (whisper) {
            return new FriendWhisperMessage(message);
        }
        return new LaudMessage(message);
    }
}
