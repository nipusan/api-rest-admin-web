package com.loya.springjpaoracledemo.entity;

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
@Table(name = "ACTION_OPTION")
public class ActionOption {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    private String description;
    
    @Column(name = "VDN", nullable = true, length = 255)
    private Integer vdn;
    
    @Column(name = "URL", nullable = true, length = 255)
    private String url;
    
    @Column(name = "TYPE_ACTION", nullable = true, length = 255)
    private String typeAction;
    
    @Column(name = "ACTION_DEFAULT", nullable = true, length = 255)
    private String actiondefault;

    
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
    

    public ActionOption() {
    }

    public ActionOption(Integer id, String name, String description, Integer vdn, String url, String typeAction, String actiondefault, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.vdn = vdn;
        this.url = url;
        this.typeAction = typeAction;
        this.actiondefault = actiondefault;
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

    public Integer getVdn() {
        return this.vdn;
    }

    public void setVdn(Integer vdn) {
        this.vdn = vdn;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTypeAction() {
        return this.typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }

    public String getActiondefault() {
        return this.actiondefault;
    }

    public void setActiondefault(String actiondefault) {
        this.actiondefault = actiondefault;
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

    public ActionOption id(Integer id) {
        this.id = id;
        return this;
    }

    public ActionOption name(String name) {
        this.name = name;
        return this;
    }

    public ActionOption description(String description) {
        this.description = description;
        return this;
    }

    public ActionOption vdn(Integer vdn) {
        this.vdn = vdn;
        return this;
    }

    public ActionOption url(String url) {
        this.url = url;
        return this;
    }

    public ActionOption typeAction(String typeAction) {
        this.typeAction = typeAction;
        return this;
    }

    public ActionOption actiondefault(String actiondefault) {
        this.actiondefault = actiondefault;
        return this;
    }

    public ActionOption creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ActionOption modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public ActionOption find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ActionOption)) {
            return false;
        }
        ActionOption actionOption = (ActionOption) o;
        return Objects.equals(id, actionOption.id) && Objects.equals(name, actionOption.name) && Objects.equals(description, actionOption.description) && Objects.equals(vdn, actionOption.vdn) && Objects.equals(url, actionOption.url) && Objects.equals(typeAction, actionOption.typeAction) && Objects.equals(actiondefault, actionOption.actiondefault) && Objects.equals(creationDate, actionOption.creationDate) && Objects.equals(modificationDate, actionOption.modificationDate) && Objects.equals(find, actionOption.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, vdn, url, typeAction, actiondefault, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", vdn='" + getVdn() + "'" +
            ", url='" + getUrl() + "'" +
            ", typeAction='" + getTypeAction() + "'" +
            ", actiondefault='" + getActiondefault() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }
    
    
}