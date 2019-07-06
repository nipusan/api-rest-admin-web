package com.avaya.springjpaoracledemo.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USERS")
public class User {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FULLNAME", nullable = true, length = 255)
    private String fullName;

    @Column(name = "USER_NAME", nullable = true, length = 255)
    private String username;

    @Column(name = "PASSWORD", nullable = true, length = 255)
    private String password;

    @Column(name = "PROFILE", nullable = true, length = 255)
    private Integer profile;

    @Column(name = "CREATION_DATE", nullable = true)
    private LocalDateTime creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = true)
    private LocalDateTime modificationDate;

    @Transient
    private String find;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
        if (profile == null) {
            profile = 3;
        }
    }

    public User() {
    }

    public User(Integer id, String fullName, String username, String password, Integer profile, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.find = find;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getProfile() {
        return this.profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getFind() {
        return this.find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public User id(Integer id) {
        this.id = id;
        return this;
    }

    public User fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User profile(Integer profile) {
        this.profile = profile;
        return this;
    }

    public User creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public User modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public User find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(profile, user.profile) && Objects.equals(creationDate, user.creationDate) && Objects.equals(modificationDate, user.modificationDate) && Objects.equals(find, user.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, username, password, profile, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", profile='" + getProfile() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }


}