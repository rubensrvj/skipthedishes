package skipthedishes.api.resource;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import skipthedishes.api.pojo.Product;
import skipthedishes.api.service.ConexaoJDBC;
import skipthedishes.api.service.ServiceProduct;

@Path("/product")
public class ProductResource {

	@Context
	UriInfo uriInfo;
	@Context
	ServletContext context;

	@GET
	@Path("/search/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductId(@PathParam("productId") Integer productId) throws Exception {
		Response retorno = null;

		ServiceProduct service = new ServiceProduct(ConexaoJDBC.getInstance());
		try {
			Product product = service.getProductId(productId);
			if (product!=null) {
				retorno = Response.status(200).entity(product).type("application/json").build();
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
	@Path("/search/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductDescription(@PathParam("description") String description) throws Exception {
		Response retorno = null;
		
		ServiceProduct service = new ServiceProduct(ConexaoJDBC.getInstance());
		try {
			List<Product> products = service.getProductDescription(description);
			if (products!=null) {
				retorno = Response.status(200).entity(products).type("application/json").build();
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
