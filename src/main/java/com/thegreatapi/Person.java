package com.thegreatapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.QueryParam;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @QueryParam("id")
    @JsonProperty("id")
    private String id;

    @QueryParam("name")
    @JsonProperty("name")
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