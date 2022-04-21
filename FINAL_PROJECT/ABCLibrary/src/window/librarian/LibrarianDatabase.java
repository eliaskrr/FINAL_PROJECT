package window.librarian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constant.Database;

/**
 * BBDD para acceder a la tabla del profesor 
 * @author Ilyasse Essadak Samaali
 */
public class LibrarianDatabase {

	private String userName;
	private String userPassword;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public LibrarianDatabase() {}
	
	public LibrarianDatabase(String userName, String userPassword) {
		connection();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	private void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Conexión con base de datos
			con = DriverManager.getConnection(Database.URL.getString(), Database.USERNAME.getString(), 
					Database.PASSWORD.getString());
			
			// Sentencia SQL
			stmt = con.prepareStatement("SELECT * FROM BIBLIOTECARIO");
			// Ejecución sentencia
			rs = stmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists() {
		boolean isUser = false;
		
		try {
			while (rs.next()) {
				// Devuelve true si existe usuario
				if (userName.equals(rs.getString(1)) && userPassword.equals(rs.getString(2))) {
					isUser = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUser;
	}
}
