package org.java.back_mangashow.security;

import java.util.HashSet;
import java.util.Set;

import org.java.back_mangashow.model.Role;
import org.java.back_mangashow.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {
    
    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = new HashSet<GrantedAuthority>();

        for (Role usRole : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(usRole.getName()));
        }
    }
    
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    //CON QUESTI METODI CONTROLLANO I CASI PARTICOLARI DI CREDENZIALI SCADUTE, O PROFILO DISATTIVATO. IN QUESTO CASO NON LI GESTIAMO!
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
