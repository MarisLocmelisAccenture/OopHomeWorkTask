package com.patterns.homework.patterns.factory;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.dto.FriendWhisperMessage;
import com.patterns.homework.patterns.dto.LaudMessage;
import com.patterns.homework.patterns.util.PatternLogger;

public class FactoryMethod {
    public static Message createFromString(String message) {
        return createFromString(message, false);
    }

    public static Message createFromString(String message, boolean whisper) {
        if (whisper) {
            PatternLogger.printFactoryCreation("FriendWhisperMessage", message);
            return new FriendWhisperMessage(message);
        }
        PatternLogger.printFactoryCreation("LaudMessage", message);
        return new LaudMessage(message);
    }
}
