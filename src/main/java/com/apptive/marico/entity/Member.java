package com.apptive.marico.entity;

import com.apptive.marico.entity.token.VerificationToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members", schema = "marico")
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    // 사용자 이름
    @Column(nullable = false)
    private String name;

    // userdatails의 username에 사용자의 email 값을 저장하고 싶은데, 변수명을 바꿔도 될까?
    @Column(updatable = false,unique = true,nullable = false)
    private String email;

    @Column(updatable = false, unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String residence;

    @Column(nullable = true)
    private String profileImage;


    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "members_roles",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
//    Collectors.toList() 메서드를 이용하여 반환되는 Stream 객체를 List 형태로 변환
                .collect(Collectors.toList());
    }


    @Override //userEmail을 리턴한다.
    public String getUsername() {
        return this.email;
    }
//    GrantedAuthority 객체를 생성할 때 문자열 변환이 필요하지 않기 때문에 유연성이 높아지며, roles 필드를 추가적으로 변경해야 할 경우, 해당 필드만 수정하면 되므로 유지보수가 용이


    // 계정이 만료됐는지 리턴 -> true는 만료X를 의미
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //  계정이 잠겨있는지 리턴 -> true는 잠기지 않음
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료됐는지 리턴 -> true는 만료X를 의미
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화돼 있는지 리턴 -> true는 활성화O 의미
    @Override
    public boolean isEnabled() {
        return enabled;
    }

}