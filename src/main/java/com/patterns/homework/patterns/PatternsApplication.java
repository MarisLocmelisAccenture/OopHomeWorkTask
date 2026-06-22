package com.patterns.homework.patterns;

import com.patterns.homework.patterns.member.*;
import com.patterns.homework.patterns.interfaces.MediatorService;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

public class PatternsApplication {

    static void main() {
        MediatorService mediator = MessageMediatorServiceImpl.getInstance();
        MafiaBoss boss = new MafiaBoss();

        AbstractChatMember
                gangMember = new Bandit(mediator, boss),
                maris = new Maris(mediator),
                friend = new Friend(mediator);

        maris.send(FactoryMethod.createFromString("This Is Stolen", false));
        friend.send(FactoryMethod.createFromString("Your Info was stolen", true));
        maris.send(FactoryMethod.createFromString("I know", true));
        gangMember.send(FactoryMethod.createFromString("Why you whisper ?"));
    }

}
