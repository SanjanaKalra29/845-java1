package com.lti.resources;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloResource {
	//URL used for each method
	//http://localhost:8181/RESTApp/api/hello?
	/*@GET
	public String hello() {
		return "Hello from JAX-RS";
	}*/
	
	//http://localhost:8181/RESTApp/api/hello?name=Sanjana
	/*@GET
	public String hello(@QueryParam("name") String name) {
		return "Hello " + name + ". Welcome to JAX-RS";
	}*/
	
	//http://localhost:8181/RESTApp/api/hello/Sanjana
	/*@Path("/{name}")
	@GET
	public String hello(@PathParam("name") String name) {
		return "Hello " + name + ". Welcome to JAX-RS";
	}*/
	
	//Matrix Param Approach
	//http://localhost:8181/RESTApp/api/hello;name=Sanjana
	@GET
	public String hello(@MatrixParam("name") String name) {
		return "Hello " + name + ". Welcome to JAX-RS";
	}
}
