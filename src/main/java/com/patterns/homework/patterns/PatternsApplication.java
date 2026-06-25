package com.patterns.homework.patterns;

import com.patterns.homework.patterns.member.*;
import com.patterns.homework.patterns.service.MediatorService;
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

        maris.send(FactoryMethod.createFromString("Observer Boss is informed Bandit and Friend heard", false));
        friend.send(FactoryMethod.createFromString("Maris only heard", true));
        maris.send(FactoryMethod.createFromString("Friend only heard", true));
        gangMember.send(FactoryMethod.createFromString("Observer boss should not hear Maris and Friend heard"));
    }

}
