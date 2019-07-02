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
@Table(name = "PROJECTS")
public class Projects {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "ID_MENU_DEFAULT", nullable = true)
    private Menu idMenuDefault;
    
    @Column(name = "PARAMETERS", nullable = true, length = 255)
    private String parameters;

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


    public Projects() {
    }

    public Projects(Integer id, String name, String description, Menu idMenuDefault, String parameters, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idMenuDefault = idMenuDefault;
        this.parameters = parameters;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getIdMenuDefault() {
        return this.idMenuDefault;
    }

    public void setIdMenuDefault(Menu idMenuDefault) {
        this.idMenuDefault = idMenuDefault;
    }

    public String getParameters() {
        return this.parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
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

    public Projects id(Integer id) {
        this.id = id;
        return this;
    }

    public Projects name(String name) {
        this.name = name;
        return this;
    }

    public Projects description(String description) {
        this.description = description;
        return this;
    }

    public Projects idMenuDefault(Menu idMenuDefault) {
        this.idMenuDefault = idMenuDefault;
        return this;
    }

    public Projects parameters(String parameters) {
        this.parameters = parameters;
        return this;
    }

    public Projects creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Projects modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public Projects find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Projects)) {
            return false;
        }
        Projects projects = (Projects) o;
        return Objects.equals(id, projects.id) && Objects.equals(name, projects.name) && Objects.equals(description, projects.description) && Objects.equals(idMenuDefault, projects.idMenuDefault) && Objects.equals(parameters, projects.parameters) && Objects.equals(creationDate, projects.creationDate) && Objects.equals(modificationDate, projects.modificationDate) && Objects.equals(find, projects.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, idMenuDefault, parameters, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", idMenuDefault='" + getIdMenuDefault() + "'" +
            ", parameters='" + getParameters() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }
   

}