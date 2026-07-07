package com.patterns.homework.patterns;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.member.*;
import com.patterns.homework.patterns.service.MediatorService;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

public class PatternsApplication {

    static void main() {
        System.out.println("this will be mediator example");
        mediatorExample();

        System.out.println();
        System.out.println();
        System.out.println("this will be observer example");
        observerExample();

        System.out.println();
        System.out.println();
        System.out.println("this will be decorator example");
        decoratorExample();
    }

    private static void mediatorExample() {
        MediatorService mediator = MessageMediatorServiceImpl.getInstance();// mediator + Singleton
        MafiaBoss boss = new MafiaBoss();// primitive Observer

        AbstractChatMember
                gangMember = new Bandit(mediator, boss),//Decorator
                maris = new Maris(mediator),
                friend = new Friend(mediator);

        maris.send(FactoryMethod.createFromString("Observer Boss is informed Bandit and Friend heard", false));// Factory method
        friend.send(FactoryMethod.createFromString("Maris only heard", true));
        maris.send(FactoryMethod.createFromString("Friend only heard", true));
        gangMember.send(FactoryMethod.createFromString("Observer boss should not hear Maris and Friend heard"));
    }

    private static void observerExample() {
        MediatorService mediator = MessageMediatorServiceImpl.getInstance();
        MafiaBoss boss = new MafiaBoss();

        AbstractChatMember
                gangMember = new Bandit(mediator, boss);

        gangMember.receive(FactoryMethod.createFromString("Bandit will do something and Observer will interact with necessary information without changing the flow", false));
    }

    private static void decoratorExample() {
        MediatorService mediator = MessageMediatorServiceImpl.getInstance();
        MafiaBoss boss = new MafiaBoss();

        AbstractChatMember
                gangMember = new Bandit(mediator, boss),
                friend = new Friend(mediator);

        Message message = FactoryMethod.createFromString("this method is decorated with different behaviour", false);
        gangMember.receive(message);
        friend.receive(message);
    }
}
