package com.patterns.homework.patterns;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.patterns.homework.patterns.abstraction.AbstractChatMember;
import com.patterns.homework.patterns.contract.MediatorInterface;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class PatternsApplicationTests {

    @Test
    void contextLoads() {
        MediatorInterface mediator = MessageMediator.getInstance();
        MafiaBoss boss = new MafiaBoss();

        AbstractChatMember
                gangMember = new Bandit(mediator, boss),
                maris = new Maris(mediator),
                friend = new Friend(mediator);

        maris.send(FactoryMethod.createFromString("This Is Stolen", false));
        friend.send(FactoryMethod.createFromString("Your Info was stolen", true));
        maris.send(FactoryMethod.createFromString("I know", true));
        gangMember.send(FactoryMethod.createFromString("Why you whisper ?"));

        List<String> friendMessages = new ArrayList<>();
        friend.getMessages().forEach((msg) -> friendMessages.add(msg.getMessage()));
        List<String> marisMessage = new ArrayList<>();
        maris.getMessages().forEach((msg) -> marisMessage.add(msg.getMessage()));

        Assertions.assertThat(boss.getStolenInfo()).contains("This Is Stolen");
        Assertions.assertThat(boss.getStolenInfo()).doesNotContain("Why you whisper ?");

        Assertions.assertThat(friendMessages).contains("This Is Stolen");
        Assertions.assertThat(friendMessages).contains("Why you whisper ?");
        Assertions.assertThat(friendMessages).doesNotContain("Your Info was stolen");
        Assertions.assertThat(friendMessages).contains("I know");

        Assertions.assertThat(marisMessage).doesNotContain("This Is Stolen");
        Assertions.assertThat(marisMessage).contains("Why you whisper ?");
        Assertions.assertThat(marisMessage).contains("Your Info was stolen");
        Assertions.assertThat(marisMessage).doesNotContain("I know");
    }

}
