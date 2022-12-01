package ru.library.domain;

import ru.library.domain.enums.UserAccessType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usrs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;
    private int points;
//    @Enumerated
//    @Column(name = "access_type_id",columnDefinition = "enum")
//    private UserAccessType userAccessType;
    private String email;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    private Set<UserAccessType> userAccessType;

    public String getUsername() {
        return username;
    }

    public Set<UserAccessType> getUserAccessType() {
        return userAccessType;
    }

    public void setUsername(String username) {
        this.username = username;
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
