package skipthedishes.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import skipthedishes.api.pojo.Product;

public class ProductJdbcDAO {
	private Connection conexao;

	public ProductJdbcDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}

	public Product getProductId(Integer productId) throws Exception {
		Product retorno = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" select id, storeId, name, description, price " 
				+ " from public.tb_produc p " + "  where 1=1 "
				+ "  and p.id = " + productId);

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			retorno = new Product();
			retorno.setId(rs.getInt("id"));
			retorno.setStoreId(rs.getInt("storeId"));
			retorno.setName(rs.getString("name"));
			retorno.setDescription(rs.getString("description"));
			retorno.setPrice(rs.getDouble("price"));
		}

		return retorno;

	}

	public List<Product> getProductDescription(String description) throws Exception {
		List<Product> retorno = new ArrayList<Product>();

		StringBuffer sql = new StringBuffer();
		sql.append(" select id, storeId, name, description, price " 
				+ " from public.tb_produc p " + "  where 1=1 "
				+ "  and p.description like " + description + "%");

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Product _product = new Product();
			_product.setId(rs.getInt("id"));
			_product.setStoreId(rs.getInt("storeId"));
			_product.setName(rs.getString("name"));
			_product.setDescription(rs.getString("description"));
			_product.setPrice(rs.getDouble("price"));

			retorno.add(_product);
		}

		return retorno;

	}

}
