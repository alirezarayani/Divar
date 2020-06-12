package io.rayani.divar.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.rayani.divar.entity.Role;
import io.rayani.divar.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;

    }
    public static UserDetailsImpl build(User user){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRole()) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getUserRole());
            authorities.add(simpleGrantedAuthority);
        }
        return new UserDetailsImpl(user.getId(),user.getEmail(),user.getPassword(),authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
