package com.avaya.springjpaoracledemo.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PROJECTS_BY_USER")
public class ProjectsByUser {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_PROJECT", nullable = true)
    private Projects project;
    
    @ManyToOne
    @JoinColumn(name = "ID_USER", nullable = true)
    private User user;
    
    @Column(name = "CREATION_DATE", nullable = true)
    private LocalDateTime creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = true)
    private LocalDateTime modificationDate;
    
    @Transient
    private String find;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
    }



    public ProjectsByUser() {
    }

    public ProjectsByUser(Integer id, Projects project, User user, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.project = project;
        this.user = user;
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

    public Projects getProject() {
        return this.project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public ProjectsByUser id(Integer id) {
        this.id = id;
        return this;
    }

    public ProjectsByUser project(Projects project) {
        this.project = project;
        return this;
    }

    public ProjectsByUser user(User user) {
        this.user = user;
        return this;
    }

    public ProjectsByUser creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ProjectsByUser modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public ProjectsByUser find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProjectsByUser)) {
            return false;
        }
        ProjectsByUser projectsByUser = (ProjectsByUser) o;
        return Objects.equals(id, projectsByUser.id) && Objects.equals(project, projectsByUser.project) && Objects.equals(user, projectsByUser.user) && Objects.equals(creationDate, projectsByUser.creationDate) && Objects.equals(modificationDate, projectsByUser.modificationDate) && Objects.equals(find, projectsByUser.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, project, user, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", project='" + getProject() + "'" +
            ", user='" + getUser() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }
   
    

}