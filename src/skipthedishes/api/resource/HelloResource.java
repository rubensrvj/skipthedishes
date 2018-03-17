package skipthedishes.api.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloResource {

	@Context
	UriInfo uriInfo;
	@Context
	ServletContext context;

	@GET
	@Path("/saudade")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHello() {
		return  Response.ok("Ok").build();
		
	}
}
