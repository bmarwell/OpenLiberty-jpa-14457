package org.example.rest;

import org.junit.jupiter.api.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JpaBooleanSelectIT extends AbstractLibertyIT {

    @Test
    public void getBooleanTest() {
        final WebTarget target = this.getClient().target(this.getBaseUrl());
        final Response response = target.request()
                .accept("*/*")
                .get();

        assertAll(
                () -> assertEquals(200, response.getStatus()),
                () -> assertEquals("false", response.readEntity(String.class))
        );
    }
}
