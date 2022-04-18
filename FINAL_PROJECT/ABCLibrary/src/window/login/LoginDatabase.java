package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDatabase {

	// Usuario a loguearse
	private String userName;
	private String userPassword;
	private String userType;
	// Usuario y conexiones MySQL
	private final String DATABASE_NAME = "abclibrary";
	private final String USER_DATABASE = "root";
	private final String PASSWORD_DATABASE = "tfg-126ssX";
	private final String URL_DATABASE = "jdbc:mysql://localhost:3306/"+DATABASE_NAME;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public LoginDatabase(String userName, String userPassword) {
		connection();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	private void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Conexión con base de datos
			con = DriverManager.getConnection(URL_DATABASE, USER_DATABASE, PASSWORD_DATABASE);
			
			stmt = con.prepareStatement("SELECT * FROM USUARIO");
			rs = stmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUser() {
		boolean isUser = false;
		
		try {
			while (rs.next()) {
				// Devuelve true si existe usuario
				if (userName.equals(rs.getString(1)) && userPassword.equals(rs.getString(2))) {
					isUser = true;
					// Obtiene el tipo de usuario logueado
					userType = rs.getString(3);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUser;
	}
	
	public String getUserType() {
		return userType;
	}
	
}
