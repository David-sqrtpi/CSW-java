package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import conector.Conexion;


@CrossOrigin
@RestController
@RequestMapping("/gerencias")
public class GerenciaControlador {
	public List<Gerencia> gerencias = new ArrayList<>();
	
	@GetMapping
	public List<Gerencia> getGerencias() throws SQLException {
		gerencias.clear();
		Conexion conexion = new Conexion();
		
		String sql = "SELECT * from gerencia";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		
		PS.execute();
		
		ResultSet resultado = PS.getResultSet();
		
		Gerencia gerencia = new Gerencia();
		
		while(resultado.next()) {
			long id = Long.parseLong(resultado.getString("id"));
			String gerenciaColumna = resultado.getString("gerencia");
			
			gerencia.setId(id);
			gerencia.setGerencia(gerenciaColumna);
			
			gerencias.add(gerencia);
		}
		
		return gerencias;
	}
}
