package com.patterns.homework.patterns;

import com.patterns.homework.patterns.member.Bandit;
import com.patterns.homework.patterns.member.Friend;
import com.patterns.homework.patterns.member.MafiaBoss;
import com.patterns.homework.patterns.member.Maris;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.patterns.homework.patterns.member.AbstractChatMember;
import com.patterns.homework.patterns.contract.MediatorService;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

import java.util.ArrayList;
import java.util.List;


class PatternsApplicationTests {

    @Test
    void contextLoads() {
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

        List<String> friendMessages = new ArrayList<>();
        friend.getMessages().forEach((msg) -> friendMessages.add(msg.message()));
        List<String> marisMessage = new ArrayList<>();
        maris.getMessages().forEach((msg) -> marisMessage.add(msg.message()));

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
