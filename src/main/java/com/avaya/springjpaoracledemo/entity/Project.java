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
@Table(name = "PROJECTS")
public class Project {
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
    private Menu menu;
    
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


    public Project() {
    }

    public Project(Integer id, String name, String description, Menu menu, String parameters, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.menu = menu;
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

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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

    public Project id(Integer id) {
        this.id = id;
        return this;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    public Project description(String description) {
        this.description = description;
        return this;
    }

    public Project menu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public Project parameters(String parameters) {
        this.parameters = parameters;
        return this;
    }

    public Project creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Project modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public Project find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Project)) {
            return false;
        }
        Project projects = (Project) o;
        return Objects.equals(id, projects.id) && Objects.equals(name, projects.name) && Objects.equals(description, projects.description) && Objects.equals(menu, projects.menu) && Objects.equals(parameters, projects.parameters) && Objects.equals(creationDate, projects.creationDate) && Objects.equals(modificationDate, projects.modificationDate) && Objects.equals(find, projects.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, menu, parameters, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", menu='" + getMenu() + "'" +
            ", parameters='" + getParameters() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }
   

}