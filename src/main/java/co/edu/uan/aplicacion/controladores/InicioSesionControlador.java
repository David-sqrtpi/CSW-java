package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Cuenta;
import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.InicioSesion;
import conector.Conexion;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class InicioSesionControlador {
	PreparedStatement pst= null;
	ResultSet rs=null;
	
	@PostMapping
	public long iniciarSesion(@RequestBody InicioSesion inicio) throws SQLException
	{
		Conexion conexion = new Conexion();
		String email = inicio.getEmail();
		String key = inicio.getContrasena();
		String sql = "SELECT id_rol FROM empresa.cuenta where email='"+email+"'and contrasena='"+key+"';";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		if (conexion.resultado.next()) {
			System.out.println("okey");
		}
		Long = Long.parseLong(PS.setString(1, sql);) 
		return ;
		
		
	}
	
	
}
