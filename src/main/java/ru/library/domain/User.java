package ru.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "usrs")
@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    private int points;

//
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "access_type_id", joinColumns = @JoinColumn(name = "id"))
//    @Enumerated(EnumType.STRING)
@Enumerated(EnumType.STRING)
@CollectionTable(name = "access_type", joinColumns = @JoinColumn(name = "id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "access_type"}, name = "uk_user_roles")})
@Column(name = "access")
@ElementCollection(fetch = FetchType.EAGER)
@JoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> userAccessType;

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

    public Set<Role> getUserAccessType() {
        return userAccessType;
    }

    public void setUserAccessType(Set<Role> userAccessType) {
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
