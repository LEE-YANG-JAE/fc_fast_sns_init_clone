package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;

public record MemberDto(
        Long id,
        String eamil,
        String nickname,
        LocalDate birthday
) {
}
