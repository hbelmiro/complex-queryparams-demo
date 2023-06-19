package com.thegreatapi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@ApplicationScoped
public interface Client {

    @GET
    @Path("/get")
    @Produces({"application/json"})
    String get(@BeanParam Person person);

    @PATCH
    @Path("/patch")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    void patch(Person person);
}