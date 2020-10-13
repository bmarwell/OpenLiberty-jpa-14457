package org.example.rest;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Objects;

public abstract class AbstractLibertyIT {

    private Client client;

    private String baseUrl;

    @BeforeEach
    public void createClient() {
        // system properties
        final String hostname = System.getProperty("liberty.hostname", "localhost");
        final String port = System.getProperty("liberty.http.port", "9080");
        this.baseUrl = "http://" + hostname + ":" + port + "/";

        // client setup
        final ClientConfig config = new ClientConfig();
        this.client = ClientBuilder.newClient(config);
    }

    public Client getClient() {
        return Objects.requireNonNull(this.client);
    }

    public String getBaseUrl() {
        return Objects.requireNonNull(this.baseUrl);
    }
}
