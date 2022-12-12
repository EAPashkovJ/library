package ru.library.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    private int points;


    @CollectionTable(name = "access_type", joinColumns = @JoinColumn(name = "id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "access"}, name = "user_access")})
    @Column(name = "access")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Enumerated(EnumType.STRING)
    private Set<UserAccessType> userAccessType;

    private String email;
    private String password;

    public User(long id, String username, int points, String email, String password, Set<UserAccessType> userAccessType) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.email = email;
        this.password = password;
        this.userAccessType = userAccessType;
    }

    public User() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
