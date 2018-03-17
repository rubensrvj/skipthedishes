package skipthedishes.api.tdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionTest {

	public static void main(String[] args) {

		System.out.println("iniciando");
		try {

			String url = "jdbc:postgresql://localhost:5432/skipthedishes";
			String usuario = "postgres";
			String senha = "postgres";

			Class.forName("org.postgresql.Driver");

			Connection con = null;

			con = DriverManager.getConnection(url, usuario, senha);

			System.out.println("Conexão realizada com sucesso.");

		} catch (Exception e) {
			System.out.println(
					"Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \n Recompile e execute novamente.");

		}

	}
}
