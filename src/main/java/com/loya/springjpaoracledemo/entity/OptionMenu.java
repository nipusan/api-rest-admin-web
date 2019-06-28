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
@Table(name = "OPTION_MENU")
public class OptionMenu {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    
    @Column(name = "AUDIO_NAME", nullable = true, length = 255)
    private String audioName;
    
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "ID_ACTION_OPTION", nullable = true)
    private ActionOption idActionOption;
    
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
    
    protected OptionMenu() {
    }


    public OptionMenu(Integer id, String name, String audioName, String description, ActionOption idActionOption, LocalDateTime creationDate, LocalDateTime modificationDate, String find) {
        this.id = id;
        this.name = name;
        this.audioName = audioName;
        this.description = description;
        this.idActionOption = idActionOption;
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

    public String getAudioName() {
        return this.audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActionOption getIdActionOption() {
        return this.idActionOption;
    }

    public void setIdActionOption(ActionOption idActionOption) {
        this.idActionOption = idActionOption;
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

    public OptionMenu id(Integer id) {
        this.id = id;
        return this;
    }

    public OptionMenu name(String name) {
        this.name = name;
        return this;
    }

    public OptionMenu audioName(String audioName) {
        this.audioName = audioName;
        return this;
    }

    public OptionMenu description(String description) {
        this.description = description;
        return this;
    }

    public OptionMenu idActionOption(ActionOption idActionOption) {
        this.idActionOption = idActionOption;
        return this;
    }

    public OptionMenu creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public OptionMenu modificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public OptionMenu find(String find) {
        this.find = find;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OptionMenu)) {
            return false;
        }
        OptionMenu optionMenu = (OptionMenu) o;
        return Objects.equals(id, optionMenu.id) && Objects.equals(name, optionMenu.name) && Objects.equals(audioName, optionMenu.audioName) && Objects.equals(description, optionMenu.description) && Objects.equals(idActionOption, optionMenu.idActionOption) && Objects.equals(creationDate, optionMenu.creationDate) && Objects.equals(modificationDate, optionMenu.modificationDate) && Objects.equals(find, optionMenu.find);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, audioName, description, idActionOption, creationDate, modificationDate, find);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", audioName='" + getAudioName() + "'" +
            ", description='" + getDescription() + "'" +
            ", idActionOption='" + getIdActionOption() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", find='" + getFind() + "'" +
            "}";
    }


}