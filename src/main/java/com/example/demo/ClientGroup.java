package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class ClientGroup {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;
    private Date createdDate;
    private Date modifiedDate;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    protected ClientGroup() {}

    public ClientGroup(String name) {
        this.name = name;
        this.active = true;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }
    public ClientGroup(long id, String name, Boolean active, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
    public Date setModifiedDate() {
        modifiedDate = new Date();
        return null;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
