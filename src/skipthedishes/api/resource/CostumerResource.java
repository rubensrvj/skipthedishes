package skipthedishes.api.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import skipthedishes.api.service.ConexaoJDBC;
import skipthedishes.api.service.ServiceCustomer;

@Path("/costumer")
public class CostumerResource {

	@Context
	UriInfo uriInfo;
	@Context
	ServletContext context;

	@POST
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public Response auth(@FormParam("email") String email, @FormParam("password") String password) throws Exception {
		Response retorno = null;
		
		ServiceCustomer service = new ServiceCustomer(ConexaoJDBC.getInstance());
		try {
			Boolean isFound = service.getAuth(email, password);
			
			if (isFound) {
				retorno = Response.status(200).entity("Sucess").type("application/json").build();	
			}else {
				retorno = Response.status(200).entity("Not Found").type("application/json").build();
			}
				
		} catch (Exception e) {
			//Logger
			retorno = Response.status(202).entity("Err - Problem").type("application/json")
					.build();

		}
		
		return retorno;

	}
	
	

}
