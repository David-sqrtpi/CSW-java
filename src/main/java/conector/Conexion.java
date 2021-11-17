package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;


public class Conexion {
	public static final String Controlador = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/empresa";
	public static final String USUARIO = "root";
	public static final String CLAVE = "1234";
    public ResultSet resultado;
	public Connection conectar() {
		Connection conexion = null;
		try {
		Class.forName(Controlador);
		conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		System.out.println("ok");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no");
		}
		return conexion;
	}
	

}
