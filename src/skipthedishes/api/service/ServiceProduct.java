package skipthedishes.api.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import skipthedishes.api.dao.ProductJdbcDAO;
import skipthedishes.api.pojo.Product;

public class ServiceProduct {
	Connection conexao;
	

	public ServiceProduct(Connection c) {
		super();
		conexao = c;
		
		
	}
	

	
	public Product getProductId(Integer productId) throws Exception {
		ProductJdbcDAO productJdbcDAO = new  ProductJdbcDAO(conexao);
		Product retorno = productJdbcDAO.getProductId(productId);
		return retorno;
	}
	
	public List<Product> getProductDescription(String  description) throws Exception{
		ProductJdbcDAO productJdbcDAO = new  ProductJdbcDAO(conexao);
		List<Product> retorno = productJdbcDAO.getProductDescription(description);
		return retorno;
	}

}
