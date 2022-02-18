package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;
    private Date createdDate;
    private Date modifiedDate;


    protected Client() {}

    public Client(String name) {
        this.name = name;
        this.active = true;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }
    public Client(long id, String name, Boolean active, Date createdDate, Date modifiedDate) {
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
