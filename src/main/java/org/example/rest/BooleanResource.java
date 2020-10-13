package org.example.rest;

import org.example.jpa.TableRepository;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@RequestScoped
public class BooleanResource {

    private TableRepository tableRepository;

    public BooleanResource() {
        // hack to allow constructor injection in JAX-RS endpoints.
        this(null);
    }

    @Inject
    public BooleanResource(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GET
    @Path("/")
    @Produces("text/plain")
    public Response getBooleanAction() {
        final TableRepository repo = this.getTableRepository();
        Boolean hasHelloContent = repo.hasFieldValue("hello");

        return Response.status(Response.Status.OK)
                .entity(hasHelloContent)
                .build();
    }

    public TableRepository getTableRepository() {
        return this.tableRepository;
    }
}
