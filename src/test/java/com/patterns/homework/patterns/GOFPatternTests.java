package com.patterns.homework.patterns;

import com.patterns.homework.patterns.dto.FriendWhisperMessage;
import com.patterns.homework.patterns.dto.LaudMessage;
import com.patterns.homework.patterns.factory.FactoryMethod;
import com.patterns.homework.patterns.interfaces.service.MediatorService;
import com.patterns.homework.patterns.member.*;
import com.patterns.homework.patterns.service.MessageMediatorServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GOFPatternTests {
    @Test
    void testMediator() {
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

    @Test
    void testFactoryMethod() {
        Assertions.assertThat(FactoryMethod.createFromString("test")).isInstanceOf(LaudMessage.class);
        Assertions.assertThat(FactoryMethod.createFromString("test", true)).isInstanceOf(FriendWhisperMessage.class);
    }

    //Wrapper on Bandit to send necessary information to observer.
    @Test
    void testObserverAndWrapper() {
        MafiaBoss boss = new MafiaBoss();

        MediatorService mediatorMock = Mockito.mock(MediatorService.class);
        AbstractChatMember gangMember = new Bandit(mediatorMock, boss);

        LaudMessage testMessage = new LaudMessage("test message");
        gangMember.receive(testMessage);

        Assertions.assertThat(boss.getStolenInfo()).contains("test message");
    }

    @Test
    void testSingleton() {
        Assertions.assertThat(MessageMediatorServiceImpl.getInstance()).isInstanceOf(MessageMediatorServiceImpl.class);
    }
}
