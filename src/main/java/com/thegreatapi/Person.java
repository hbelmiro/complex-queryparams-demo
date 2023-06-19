package com.thegreatapi;

import jakarta.ws.rs.QueryParam;

public class Person {

    @QueryParam("id")
    private String id;

    @QueryParam("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}