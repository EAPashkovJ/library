package ru.library.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.library.domain.enums.UserAccessType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    private int points;
    @Enumerated
    @Column(name = "access_type_id",columnDefinition = "enum")
    private UserAccessType userAccessType;
    private String email;
    private String password;

    // Конструктор для теста функциональности запросов
    public User(long id, String username, int points, UserAccessType userAccessType, String email, String password) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.userAccessType = userAccessType;
        this.email = email;
        this.password = password;

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


    @Column(name = "access")
    @ElementCollection(targetClass = UserAccessType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "access_type", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "access")
   private Set<UserAccessType> userAccessTypeSet;

    public String getUsername() {
        return username;
    }

    public UserAccessType getUserAccessType() {
        return userAccessType;
    }

    public Set<UserAccessType> getUserAccessTypeSet() {
        return userAccessTypeSet;
    }

    public void setUserAccessType(UserAccessType userAccessType) {
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
