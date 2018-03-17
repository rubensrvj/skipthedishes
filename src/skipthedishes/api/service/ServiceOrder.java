package skipthedishes.api.service;

import java.sql.Connection;

import skipthedishes.api.dao.OrderJdbcDAO;
import skipthedishes.api.pojo.Order;

public class ServiceOrder {
	Connection conexao;
	

	public ServiceOrder(Connection c) {
		super();
		conexao = c;

	}
	
	public Order getOrderId(Integer orderId) throws Exception {
		OrderJdbcDAO orderJdbcDAO = new  OrderJdbcDAO(conexao);
		Order retorno = orderJdbcDAO.getOrderId(orderId);
		return retorno;
	}
	
	public String geStatus(Integer orderId) throws Exception {
		OrderJdbcDAO orderJdbcDAO = new  OrderJdbcDAO(conexao);
		Order retorno = orderJdbcDAO.getOrderId(orderId);
		return retorno.getStatus();
	}


}
