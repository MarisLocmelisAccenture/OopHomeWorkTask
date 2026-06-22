package com.patterns.homework.patterns;

import com.patterns.homework.patterns.component.*;
import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

public class PatternsApplication {

    static void main() {
        Mediator mediator = MessageMediatorImpl.getInstance();
        MafiaBoss boss = new MafiaBoss();

        AbstractChatMember
                gangMember = new BanditImpl(mediator, boss),
                maris = new MarisImpl(mediator),
                friend = new FriendImpl(mediator);

        maris.send(FactoryMethod.createFromString("This Is Stolen", false));
        friend.send(FactoryMethod.createFromString("Your Info was stolen", true));
        maris.send(FactoryMethod.createFromString("I know", true));
        gangMember.send(FactoryMethod.createFromString("Why you whisper ?"));
    }

}
