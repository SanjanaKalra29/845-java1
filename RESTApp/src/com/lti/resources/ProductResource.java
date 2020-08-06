package com.lti.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

@Path("/product")
public class ProductResource {
	
	@Path("/{id}")  //dynamic
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Product get(@PathParam("id") int id) {
		ProductDao dao = new ProductDao();
		return dao.select(id);
	}

	@Path("/all")  //static
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll() {
		ProductDao dao = new ProductDao();
		return dao.selectAll();
		
		//http://localhost:8181/RESTApp/api/product/all
		//run this in REST advanced client app, and see output of all products
		
		//http://localhost:8181/RESTApp/api/product/111
		//run this in REST advanced client app, and see output of specific product
	}
	
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) //can be JSON
	//whatever json client will be stored , we will dynamically receive it as Product object
	public String post(Product product) {
		ProductDao dao = new ProductDao();
		dao.insert(product);
		return "Product added successfully!"; //actually we should reply in json format again, that is not good
		
		//http://localhost:8181/RESTApp/api/product/add
		//POST and in Body. application/json, and add
		//{"id":444,"name":"Redmi Note 9","price":12000}
		
		//http://localhost:8181/RESTApp/api/product/all
		//then by this GET, it will be visible
	}
	
}



