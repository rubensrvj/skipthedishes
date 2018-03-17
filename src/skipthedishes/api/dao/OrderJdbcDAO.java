package skipthedishes.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import skipthedishes.api.pojo.Order;
import skipthedishes.api.pojo.Product;

public class OrderJdbcDAO {
	private Connection conexao;

	public OrderJdbcDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}

	 
	
	public Order getOrderId(Integer orderId) throws Exception {
		Order retorno = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" select id, date,customerId,deliveryAddress, contact, total, status,lastUpdate      " 
				+ " from public.tb_order o " + "  where 1=1 "
				+ "  and o.id = " + orderId);

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			retorno = new Order();
			retorno.setId(rs.getInt("id"));
			retorno.setDate(rs.getString("date"));
			retorno.setCustomerId(rs.getInt("customerId"));
			retorno.setDeliveryAddress(rs.getString("deliveryAddress"));
			retorno.setContact(rs.getString("deliveryAddress"));
			retorno.setTotal(rs.getDouble("total"));
			retorno.setStatus(rs.getString("status"));
			retorno.setLastUpdate(rs.getString("lastUpdate"));
		}

		return retorno;

	}
}

//public.tb_order
