package com.codegym.md4_webshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String userName;
    @JsonIgnore
    private String userPassword;
    private String email;
    private String phone;
    private int userStatus;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long userId, String userName, String userPassword, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.authorities = authorities;
    }

    // Map từ thông tin user chuyển sang thông tin user CustomUserDetails
    public static CustomUserDetails mapUserToUserDetail(User user) {
        List<GrantedAuthority> listAuthorities = user.getAdvertisementSet().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        return new CustomUserDetails(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getStatus(),
                listAuthorities
        );
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
