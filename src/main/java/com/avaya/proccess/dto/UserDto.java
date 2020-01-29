package com.avaya.proccess.dto;


import java.time.LocalDateTime;
import java.util.Objects;

public class UserDto {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private Integer profile;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private String find;

    public UserDto(Integer id, String fullName, String username, String password, Integer profile, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
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

    public UserDto id(Integer id) {
        this.id = id;
        return this;
    }

    public UserDto fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserDto username(String username) {
        this.username = username;
        return this;
    }

    public UserDto password(String password) {
        this.password = password;
        return this;
    }

    public UserDto profile(Integer profile) {
        this.profile = profile;
        return this;
    }

    public UserDto creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserDto modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public UserDto find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto UserDto = (UserDto) o;
        return Objects.equals(id, UserDto.id) && Objects.equals(fullName, UserDto.fullName) && Objects.equals(username, UserDto.username) && Objects.equals(password, UserDto.password) && Objects.equals(profile, UserDto.profile) && Objects.equals(creationDate, UserDto.creationDate) && Objects.equals(modificationDate, UserDto.modificationDate) && Objects.equals(find, UserDto.find);
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