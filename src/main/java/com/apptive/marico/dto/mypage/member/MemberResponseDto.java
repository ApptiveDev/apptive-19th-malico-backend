package com.apptive.marico.dto.mypage.member;

import com.apptive.marico.entity.Member;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String userId;
    private String nickname;

// 코드의 재사용성과 가독성을 위한 Member 객체를 Dto 객체로 변환하는 일종의 캡슐화 전략
    public static MemberResponseDto toDto(Member member) {
        return MemberResponseDto.builder()
                .userId(member.getUsername())
                .nickname(member.getNickname()).build();
    }

}
