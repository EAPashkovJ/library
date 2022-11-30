package ru.library.domain;

import org.springframework.security.core.userdetails.UserDetails;
import ru.library.domain.enums.UserAccessType;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int points;
    @Enumerated
    @Column(name = "access_type_id",columnDefinition = "enum")
    private UserAccessType userAccessType;
    private String email;
    private String password; // Не храним пароли в стринге. Будет переделано

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public UserAccessType getUserAccessType() {
        return userAccessType;
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
