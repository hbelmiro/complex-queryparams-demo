package com.thegreatapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.patchRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@QuarkusTest
@QuarkusTestResource(WiremockClient.class)
class ClientTest {

    @Inject
    @RestClient
    Client client;

    WireMockServer wireMockServer;

    @Test
    void testGet() {
        var person = new Person();
        person.setId("42");
        person.setName("Ozzy Osbourne");

        client.get(person);

        wireMockServer.verify(getRequestedFor(urlEqualTo("/get?id=42&name=Ozzy+Osbourne")));
    }

    @Test
    void testPatch() {
        var person = new Person();
        person.setId("42");
        person.setName("Ozzy Osbourne");

        client.patch(person);

        wireMockServer.verify(patchRequestedFor(urlEqualTo("/patch"))
                .withHeader("Content-Type", equalTo("application/json"))
                .withRequestBody(equalToJson(" { \"id\": \"42\", \"name\": \"Ozzy Osbourne\" }")));
    }
}