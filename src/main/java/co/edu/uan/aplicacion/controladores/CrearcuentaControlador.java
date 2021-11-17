package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Cuenta;
import co.edu.uan.aplicacion.entidades.Empleado;
import conector.Conexion;

@CrossOrigin
@RestController
@RequestMapping("/cuentas")
public class CrearcuentaControlador {

	@PostMapping
	public void crearCuenta(@RequestBody Cuenta cuenta) throws SQLException {
		ResultSet resultado;
		Conexion conexion = new Conexion();
		
		long  idRol = cuenta.getIdRol(); 
		String	email = cuenta.getCorreo();
		String  contrasena = cuenta.getContrasena();
		String  nombre = cuenta.getNombre();
		
		
		String sql = "INSERT INTO `empresa`.`cuenta` (`id_rol`, `email`, `contrasena`, `nombre`) VALUES ('"+idRol+"', '"+email+"', '"+contrasena+"', '"+nombre+"');";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
	
				PS.executeUpdate();
	
	}
}
