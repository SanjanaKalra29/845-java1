package com.lti.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resources.Passenger.Gender;
import com.lti.resources.Passenger.Status;

//http://localhost:8181/RESTApp/api/pnr?pnrNo=1234567890  (URL to run the code)

//assume you're working for IRCTC & responsible for developing the PNR API
@Path("/pnr")
public class PnrResource {
	
	@GET
	//@Produces("application/json")  ---spelling mistake possible
	@Produces(MediaType.APPLICATION_JSON) //indicates what this code will generate-here it produces JSON
	//can also be written as @Produces("application/json")
	
	public Pnr checkStatus(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response){
		//enabling CORS
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Origin", "*");
	
		
		//for the time being we will return some hard coded data
		//in a real app, from here we will hit the DB and fetch the data dynamically
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2020, 12, 25));
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger("Sanjana", Gender.FEMALE, Status.RAC));
		passengers.add(new Passenger("Saumya", Gender.FEMALE, Status.CONFIRMED));
		passengers.add(new Passenger("Shubhi", Gender.MALE, Status.RAC));
		pnr.setPassengers(passengers);

		return pnr;
	}
}