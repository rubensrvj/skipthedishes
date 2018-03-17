package skipthedishes.api.service;

import java.sql.Connection;
import java.sql.DriverManager;

import skipthedishes.api.dao.CustomerJdbcDAO;

public class ServiceCustomer {
	Connection conexao;
	

	public ServiceCustomer(Connection c) {
		super();
		conexao = c;

	}
	


	public Boolean getAuth(String email, String password) throws Exception {
		CustomerJdbcDAO customerJdbcDAO = new  CustomerJdbcDAO(conexao);
		Boolean retorno = customerJdbcDAO.getAuth(email, password);
		return retorno;
	}


	
}
