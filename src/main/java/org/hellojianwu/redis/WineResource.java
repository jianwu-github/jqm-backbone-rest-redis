package org.hellojianwu.redis;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hellojianwu.redis.data.Wine;

@Path("/wines")
public class WineResource {

    RedisDataManager dao = new RedisDataManager();

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Wine> findAll() {
        System.out.println("findAll");
        return dao.findAll();
    }

    /*
    @GET @Path("search/{query}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Wine> findByName(@PathParam("query") String query) {
        System.out.println("findByName: " + query);
        return dao.findByName(query);
    } // */

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine findById(@PathParam("id") String id) {
        System.out.println("findById " + id);
        return dao.getWine(Long.parseLong(id));
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine create(Wine wine) {
        return dao.saveWine(wine);
    }

    /*
    @PUT @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine update(Wine wine) {
        System.out.println("Updating wine: " + wine.getName());
        dao.update(wine);
        return wine;
    } // */

    /*
    @DELETE @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void remove(@PathParam("id") int id) {
        dao.remove(id);
    } // */

}
