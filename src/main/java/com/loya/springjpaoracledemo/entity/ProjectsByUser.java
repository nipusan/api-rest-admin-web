package com.loya.springjpaoracledemo.entity;

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
    private Projects idProject;
    
    @ManyToOne
    @JoinColumn(name = "ID_USER", nullable = true)
    private User idUser;
    
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

    public ProjectsByUser(Integer id, Projects idProject, User idUser, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.idProject = idProject;
        this.idUser = idUser;
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

    public Projects getIdProject() {
        return this.idProject;
    }

    public void setIdProject(Projects idProject) {
        this.idProject = idProject;
    }

    public User getIdUser() {
        return this.idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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

    public ProjectsByUser idProject(Projects idProject) {
        this.idProject = idProject;
        return this;
    }

    public ProjectsByUser idUser(User idUser) {
        this.idUser = idUser;
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
        return Objects.equals(id, projectsByUser.id) && Objects.equals(idProject, projectsByUser.idProject) && Objects.equals(idUser, projectsByUser.idUser) && Objects.equals(creationDate, projectsByUser.creationDate) && Objects.equals(modificationDate, projectsByUser.modificationDate) && Objects.equals(find, projectsByUser.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProject, idUser, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idProject='" + getIdProject() + "'" +
            ", idUser='" + getIdUser() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }
    

}