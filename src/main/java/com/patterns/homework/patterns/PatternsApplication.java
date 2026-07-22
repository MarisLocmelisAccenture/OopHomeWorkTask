package com.patterns.homework.patterns;

import com.patterns.homework.patterns.dto.Message;
import com.patterns.homework.patterns.member.*;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;
import com.patterns.homework.patterns.util.PatternLogger;

public class PatternsApplication {

    static void main() {
        PatternLogger.printSection("GoF Patterns Demonstration - Mafia Chat System");

        mediatorExample();
        observerExample();
        decoratorExample();
        fluentInterfaceExample();
        iteratorExample();

        PatternLogger.printSection("End of Demonstration");
    }

    private static void mediatorExample() {
        PatternLogger.printSection("Example 1: Mediator + Singleton Patterns");
        PatternLogger.printPatternInfo("MEDIATOR",
                "Centralizes complex communication logic between objects (chat members)");
        PatternLogger.printPatternInfo("SINGLETON",
                "Ensures only one instance of MessageMediatorService exists globally");

        MediatorService<?> mediator = MessageMediatorServiceImpl.getInstance();
        mediator.clearMembers();
        MafiaBoss boss = new MafiaBoss();
        ObserverService observer = new ObserverServiceImpl();
        observer.addObserver(boss);

        ChatMember<Friend> gangMember = new Bandit(mediator, observer);
        ChatMember<Maris> maris = new Maris(mediator);
        ChatMember<Friend> friend = new Friend(mediator);

        PatternLogger.printInfo("📋 Setup: 3 chat members + 1 boss (observer) registered with mediator\n");

        PatternLogger.printAction("Maris", "sends a public message");
        maris.send(FactoryMethod.createFromString("Observer Boss is informed Bandit and Friend heard", false));

        PatternLogger.printAction("Friend", "sends a whispered message");
        friend.send(FactoryMethod.createFromString("Maris only heard", true));

        PatternLogger.printAction("Maris", "sends a whispered message");
        maris.send(FactoryMethod.createFromString("Friend only heard", true));

        PatternLogger.printAction("Bandit", "sends a public message");
        gangMember.send(FactoryMethod.createFromString("Observer boss should not hear Maris and Friend heard"));
    }

    private static void observerExample() {
        PatternLogger.printSection("Example 2: Observer Pattern");
        PatternLogger.printPatternInfo("OBSERVER",
                "Notifies multiple observers about events without coupling them to the subject");

        MediatorService<?> mediator = MessageMediatorServiceImpl.getInstance();
        mediator.clearMembers();
        MafiaBoss boss = new MafiaBoss();
        ObserverService observer = new ObserverServiceImpl();
        observer.addObserver(boss);

        ChatMember<Friend> gangMember = new Bandit(mediator, observer);

        PatternLogger.printInfo("📋 Setup: Bandit with attached MafiaBoss observer\n");

        PatternLogger.printAction("Bandit", "receives a message");
        gangMember.receive(FactoryMethod.createFromString(
                "Bandit will do something and Observer will interact with necessary information without changing the flow", false));

        PatternLogger.printInfo("\n✓ Notice: MafiaBoss observed the action and collected information automatically");
    }

    private static void decoratorExample() {
        PatternLogger.printSection("Example 3: Decorator + Factory Patterns");
        PatternLogger.printPatternInfo("DECORATOR",
                "Adds behavior to objects dynamically (Bandit decorates Friend with boss notification)");
        PatternLogger.printPatternInfo("FACTORY METHOD",
                "Creates different message types without exposing creation logic");

        MediatorService<?> mediator = MessageMediatorServiceImpl.getInstance();
        mediator.clearMembers();
        MafiaBoss boss = new MafiaBoss();
        ObserverService observer = new ObserverServiceImpl();
        observer.addObserver(boss);

        ChatMember<Friend> gangMember = new Bandit(mediator, observer);
        ChatMember<Friend> friend = new Friend(mediator);

        Message message = FactoryMethod.createFromString("this method is decorated with different behaviour", false);

        PatternLogger.printInfo("📋 Setup: Same message received by regular Friend vs Decorated Bandit\n");

        PatternLogger.printAction("Bandit (Decorated Friend)", "receives message");
        gangMember.receive(message);

        PatternLogger.printAction("Friend (Regular)", "receives message");
        friend.receive(message);

        PatternLogger.printInfo("\n✓ Notice: Bandit (decorated) forwarded info to boss, Friend (regular) did not");
    }

    private static void fluentInterfaceExample() {
        PatternLogger.printSection("Example 4: Fluent Interface Pattern");

        PatternLogger.printPatternInfo("Fluent Interface",
                "Uses Fluent interface to send multiple messages");
        PatternLogger.printPatternInfo("FACTORY METHOD",
                "Creates different message types without exposing creation logic");

        MessageMediatorServiceImpl mediator = MessageMediatorServiceImpl.getInstance();
        mediator.clearMembers();
        Maris maris = new Maris(mediator);
        Friend friend = new Friend(mediator);

        mediator.addMember(maris)
                .addMember(friend);

        maris.send(FactoryMethod.createFromString("First message", false))
                .send(FactoryMethod.createFromString("Second message", true))
                .send(FactoryMethod.createFromString("Third message", false));
    }

    private static void iteratorExample() {
        PatternLogger.printSection("Example 4: Iterator Pattern");

        PatternLogger.printPatternInfo("Iterator",
                "Uses Iterator to traverse messages");
        PatternLogger.printPatternInfo("FACTORY METHOD",
                "Creates different message types without exposing creation logic");

        MessageMediatorServiceImpl mediator = MessageMediatorServiceImpl.getInstance();
        mediator.clearMembers();
        Maris maris = new Maris(mediator);
        Friend friend = new Friend(mediator);

        mediator.addMember(maris)
                .addMember(friend);

        maris.send(FactoryMethod.createFromString("First message", false))
                .send(FactoryMethod.createFromString("Second message", true))
                .send(FactoryMethod.createFromString("Third message", false));

        maris.getMessages().iterator().forEachRemaining(message -> PatternLogger.printInfo("[Iterator] Maris received: " + message.message()));
    }
}
