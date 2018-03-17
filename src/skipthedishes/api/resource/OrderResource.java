package skipthedishes.api.resource;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import skipthedishes.api.pojo.Order;
import skipthedishes.api.service.ConexaoJDBC;
import skipthedishes.api.service.ServiceOrder;

@Path("/order")
public class OrderResource {

	@Context
	UriInfo uriInfo;
	@Context
	ServletContext context;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderId(@PathParam("orderId") Integer orderId) throws Exception {
		Response retorno = null;

		ServiceOrder service = new ServiceOrder(ConexaoJDBC.getInstance());
		try {
			Order order = service.getOrderId(orderId);
			if (order!=null) {
				retorno = Response.status(200).entity("Sucess").type("application/json").build();
			}else {
				retorno = Response.status(200).entity("Not Found").type("application/json").build();
			}	
		} catch (Exception e) {
			// Logger
			retorno = Response.status(202).entity("Err - Problem").type("application/json").build();

		}

		return retorno;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderStatus(@PathParam("orderId") Integer orderId) throws Exception {
		Response retorno = null;

		ServiceOrder service = new ServiceOrder(ConexaoJDBC.getInstance());
		try {
			Order order = service.getOrderId(orderId);
			if (order!=null) {
				retorno = Response.status(200).entity("Sucess" + order.getStatus()).type("application/json").build();
			}else {
				retorno = Response.status(200).entity("Not Found").type("application/json").build();
			}	
		} catch (Exception e) {
			// Logger
			retorno = Response.status(202).entity("Err - Problem").type("application/json").build();

		}

		return retorno;
	}

	

}
