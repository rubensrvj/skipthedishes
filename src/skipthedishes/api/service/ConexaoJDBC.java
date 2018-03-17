package skipthedishes.api.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJDBC {



	private static Connection _instancia;
	

	public ConexaoJDBC() {
		

	}

	public static Connection getInstance() throws Exception {
		if (_instancia == null)
			_instancia = getConexao();

		return _instancia;
	}

	private static Connection getConexao() throws Exception {
		Class.forName("org.postgresql.Driver");

		String usr = "postgres";
		String senha = "postgres";
		String url = "jdbc:postgresql://localhost:5432/skipthedishes";

		Connection conexao = DriverManager.getConnection(url, usr, senha);

		return conexao;
	}



}
