package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

public class MemberTest {
    
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    public void testChangeName() {
        // Object mother 패턴 이용
        var member = MemberFixtureFactory.create();
        var toChangeName = "pnu";

        member.changeNickname(toChangeName);

        Assertions.assertEquals(toChangeName, member.getNickname());
    }

    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
        // Object mother 패턴 이용
        var member = MemberFixtureFactory.create();
        var overMaxLength = "pnupnupnupnu";

        Assertions.assertThrows(IllegalArgumentException.class, ()-> member.changeNickname(overMaxLength));
    }
}
