package com.patterns.homework.patterns;

import com.patterns.homework.patterns.component.BanditImpl;
import com.patterns.homework.patterns.component.FriendImpl;
import com.patterns.homework.patterns.component.MafiaBoss;
import com.patterns.homework.patterns.component.MarisImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.patterns.homework.patterns.component.AbstractChatMember;
import com.patterns.homework.patterns.contract.Mediator;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.service.*;

import java.util.ArrayList;
import java.util.List;


class PatternsApplicationTests {

    @Test
    void contextLoads() {
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
