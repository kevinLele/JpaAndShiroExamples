package com.kevin.examples.restful;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 11/21/2016.
 */
@Component
@Path("/hello")
public class HelloRestful {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateResource")
    public String updateResource() {
        return "{hello:1}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("updateResource2") 不设置path的情况下如果要调用该方法直接访问/hello
    public String updateResource2() {
        return "{hello:2}";
    }
}
