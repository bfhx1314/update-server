package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2017/11/29.
 */

@Entity
@Table(name = "person")
public class PersonEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_name")
    private String user_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
