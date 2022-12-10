package ru.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.library.domain.enums.UserAccessType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "usrs")
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    private int points;

    @ElementCollection(targetClass = UserAccessType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "access_type", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "access")
//@ManyToMany(fetch = FetchType.EAGER)
//@JoinTable(name = "access_type",
//        joinColumns = @JoinColumn(name = "id"),
//        inverseJoinColumns = @JoinColumn(name = "id"))

    private Set<UserAccessType> userAccessType;

    private String email;
    private String password;

    public long getId() {
        return id;
    }


    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public Set<UserAccessType> getUserAccessType() {
        return userAccessType;
    }

    public void setUserAccessType(Set<UserAccessType> userAccessType) {
        this.userAccessType = userAccessType;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
