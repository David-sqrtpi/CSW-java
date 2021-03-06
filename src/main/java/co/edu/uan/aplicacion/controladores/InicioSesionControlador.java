package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.InicioSesion;
import conector.Conexion;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class InicioSesionControlador {
	PreparedStatement pst= null;
	
	@PostMapping
	public long iniciarSesion(@RequestBody InicioSesion inicio) throws SQLException
	{
		Conexion conexion = new Conexion();
		String email = inicio.getEmail();
		String key = inicio.getContrasena();
		String sql = "SELECT id_rol FROM empresa.cuenta where email='"+email+"'and contrasena='"+key+"';";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);

		PS.execute();
		
		ResultSet rs = PS.getResultSet();
		if(rs.next()) {
			return Long.parseLong(rs.getString("id_rol"));
		} 
		
		return -1;
	}
	
	
}
