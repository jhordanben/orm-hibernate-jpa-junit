package TestConnection;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import org.junit.jupiter.api.Test;

	public class TestConnection {
	    public static void main(String[] args) {
	        String url = "jdbc:postgresql://localhost:5432/posjavahibernate";
	        String user = "postgres";
	        String password = "admin";
	        
	        try (Connection conn = DriverManager.getConnection(url, user, password)) {
	            if (conn != null) {
	                System.out.println("Conexão estabelecida com sucesso!");
	            } else {
	                System.out.println("Falha ao conectar.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



