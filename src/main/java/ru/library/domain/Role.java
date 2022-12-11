package ru.library.domain;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "access_type")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "access")
    private AccessType role;

    public Role() {
    }

    public Role(long id, AccessType access) {
        this.id = id;
        this.role = access;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccessType getAccess() {
        return role;
    }

    public void setAccess(AccessType access) {
        this.role = access;
    }
}
