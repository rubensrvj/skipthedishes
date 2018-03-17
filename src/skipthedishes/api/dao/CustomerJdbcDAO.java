package skipthedishes.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerJdbcDAO {
	
	private Connection conexao;
	
	public CustomerJdbcDAO(Connection conexao) {
		super();
		this.conexao = conexao;
	}
	
	
	public Boolean getAuth(String email, String password) throws Exception {
		Boolean retorno = false;

		StringBuffer sql = new StringBuffer();
		sql.append(" select 1 from public.tb_customer c "
				+ "  where 1=1 "
				+ "  and c.email = " +"'" +email+"'"
				+ "  and c.password = "+"'" + password+"'");

		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		
		while (rs.next()) {
			retorno = true;
			break;
		}


		return retorno;

	}

}
