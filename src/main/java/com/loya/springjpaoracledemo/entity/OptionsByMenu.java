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
@Table(name = "OPTIONS_BY_MENU")
public class OptionsByMenu {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_MENU", nullable = true)
    private Menu idMenu;
    
    @ManyToOne
    @JoinColumn(name = "ID_OPTION_MENU", nullable = true)
    private OptionMenu idOptionMenu;
    
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

    public OptionsByMenu() {
    }

    public OptionsByMenu(Integer id, Menu idMenu, OptionMenu idOptionMenu, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.idMenu = idMenu;
        this.idOptionMenu = idOptionMenu;
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

    public Menu getIdMenu() {
        return this.idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public OptionMenu getIdOptionMenu() {
        return this.idOptionMenu;
    }

    public void setIdOptionMenu(OptionMenu idOptionMenu) {
        this.idOptionMenu = idOptionMenu;
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

    public OptionsByMenu id(Integer id) {
        this.id = id;
        return this;
    }

    public OptionsByMenu idMenu(Menu idMenu) {
        this.idMenu = idMenu;
        return this;
    }

    public OptionsByMenu idOptionMenu(OptionMenu idOptionMenu) {
        this.idOptionMenu = idOptionMenu;
        return this;
    }

    public OptionsByMenu creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public OptionsByMenu modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public OptionsByMenu find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OptionsByMenu)) {
            return false;
        }
        OptionsByMenu optionsByMenu = (OptionsByMenu) o;
        return Objects.equals(id, optionsByMenu.id) && Objects.equals(idMenu, optionsByMenu.idMenu) && Objects.equals(idOptionMenu, optionsByMenu.idOptionMenu) && Objects.equals(creationDate, optionsByMenu.creationDate) && Objects.equals(modificationDate, optionsByMenu.modificationDate) && Objects.equals(find, optionsByMenu.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMenu, idOptionMenu, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idMenu='" + getIdMenu() + "'" +
            ", idOptionMenu='" + getIdOptionMenu() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }


}