package com.apptive.marico.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    //400 BAD_REQUEST 잘못된 요청
    PASSWORD_NOT_MATCH(400, "잘못된 비밀번호입니다."),
    CODE_NOT_MATCH(400, "인증 번호가 잘못되었습니다."),

    VERIFICATION_CODE_INVAILD(401, "발급 코드가 유효하지 않습니다."),
    EMAIL_DOES_NOT_MATCH(401, "이메일이 일치하지 않습니다."),

    //404 NOT_FOUND 잘못된 리소스 접근
    EMAIL_NOT_FOUND(404, "존재하지 않는 이메일입니다."),
    USER_NOT_FOUND(404, "존재하지 않는 회원입니다."),
    STYLIST_NOT_FOUND(404, "존재하지 않는 스타일리스트입니다."),

    //409 CONFLICT 중복된 리소스
    ALREADY_SAVED_EMAIL(409, "이미 저장된 이메일입니다."),

    //419 Authentication Timeout
    VERIFICATION_CODE_TIMEOUT(419, "발급 코드의 인증 시간이 초과 되었습니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버 팀에 연락주세요!"),
    ROLE_NOT_FOUND(500, "존재하지 않는 ROLE입니다.");

    private final int status;
    private final String message;
}
