package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @JsonManagedReference
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClientGroup> clientGroups = new ArrayList<>();

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
