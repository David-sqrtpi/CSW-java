package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.Servicio;
import conector.Conexion;

@CrossOrigin
@RestController
@RequestMapping("/servicios")
public class ServicioControlador {	
	@GetMapping
	public List<Servicio> getServicios() throws SQLException {
		List<Servicio> servicios = new ArrayList<>();
		Conexion conexion = new Conexion();
		
		String sql = "SELECT * from servicio";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		
		PS.execute();
		
		ResultSet resultado = PS.getResultSet();
		
		
		
		while(resultado.next()) {
			long id = Long.parseLong(resultado.getString("id"));
			String servicioColumna = resultado.getString("servicio");
			
			Servicio servicio = new Servicio(id, servicioColumna);
			
			servicios.add(servicio);
		}
	
		return servicios;
	}
}
