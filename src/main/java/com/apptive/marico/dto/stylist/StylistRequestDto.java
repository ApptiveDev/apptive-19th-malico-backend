package com.apptive.marico.dto.stylist;

import com.apptive.marico.entity.Member;
import com.apptive.marico.entity.Stylist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StylistRequestDto {

    private String name;
    private String userId;
    private String email;
    private String password;

    private String nickname;
    private char gender;
    private LocalDate birthDate;
    private String profile_image;


    //변환 메서드는 역시 따로 매퍼 클래스를 만들어서 구현하는것이 좋은지
    //DTO에는 오직 로직을 넣지않고 데이터전송에만 사용해야할지
    public Stylist toStylist(PasswordEncoder passwordEncoder) {
        return Stylist.builder()
                .name(name)
                .userId(userId)
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .gender(gender)
                .birthDate(birthDate)
                .profileImage(profile_image)
                .build();
    }


}
