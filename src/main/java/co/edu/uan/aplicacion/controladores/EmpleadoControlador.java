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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.Servicio;
import conector.Conexion;

@CrossOrigin
@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
	public List<Empleado> empleados = new ArrayList();
	
	@GetMapping
	public List<Empleado> getEmpleados() throws SQLException {
		empleados.clear();
		Conexion conexion = new Conexion();
		
		String sql = "SELECT * from empleado";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		
		PS.execute();
		
		ResultSet resultado = PS.getResultSet();
		
		Empleado empleado = new Empleado();
				
		while(resultado.next()) {
			long cedula = Long.parseLong(resultado.getString("cedula"));
			long servicio = Long.parseLong(resultado.getString("id_servicio"));
			long gerencia = Long.parseLong(resultado.getString("id_gerencia"));
			String nombre = resultado.getString("nombre");
			long genero = Long.parseLong(resultado.getString("id_genero"));
			LocalDate fecha = LocalDate.parse(resultado.getString("fecha_ingreso"));
			
			empleado.setCedula(cedula);
			empleado.setIdServicio(servicio);
			empleado.setIdGerencia(gerencia);
			empleado.setNombre(nombre);
			empleado.setGenero(genero);
			empleado.setFechaIngreso(fecha);
			
			empleados.add(empleado);
		}
		
		return empleados;
	}
	
	@GetMapping("/{cedula}")
	public Empleado getEmpleado(@PathVariable String cedula) throws SQLException {

		Conexion conexion = new Conexion();
		
		String sql = "SELECT * from empleado where cedula = "+cedula+"";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		
		PS.execute();
		
		ResultSet resultado = PS.getResultSet();
				
		while(resultado.next()) {
			Empleado empleado = new Empleado();
			
			long servicio = Long.parseLong(resultado.getString("id_servicio"));
			long gerencia = Long.parseLong(resultado.getString("id_gerencia"));
			String nombre = resultado.getString("nombre");
			long genero = Long.parseLong(resultado.getString("id_genero"));
			LocalDate fecha = LocalDate.parse(resultado.getString("fecha_ingreso"));
			
			empleado.setCedula(Long.parseLong(cedula));
			empleado.setIdServicio(servicio);
			empleado.setIdGerencia(gerencia);
			empleado.setNombre(nombre);
			empleado.setGenero(genero);
			empleado.setFechaIngreso(fecha);
			
			return empleado;
		}
		
		return null;
	}
	
	@PutMapping("/{cedula}")
	public Empleado modificarEmpleado(@RequestBody Empleado empleado, @PathVariable String cedula) throws SQLException {
		Conexion conexion = new Conexion();
		
		String sql = "DELETE from empleado where cedula = "+cedula+"";
		PreparedStatement PS = conexion.conectar().prepareStatement(sql);
		PS.execute();
		
		long servicio = empleado.getIdServicio();
		long gerencia = empleado.getIdGerencia();
		String nombre = empleado.getNombre();
		long genero = empleado.getGenero();
		LocalDate fecha = empleado.getFechaIngreso(); 
		
		sql = "INSERT into empleado(cedula, id_servicio, id_gerencia, nombre, id_genero, fecha_ingreso) values"
				+ "("+cedula+", "+servicio+", "+gerencia+", '"+nombre+"', "+genero+", '"+fecha+"')";
		PS = conexion.conectar().prepareStatement(sql);
		
		PS.execute();
				
		return empleado;
	}
	
	@PutMapping
	public void actualizarEmpleado(@RequestBody Empleado empleado) {
		for (Empleado empleadoActual : empleados) {
			if(true) {
				empleados.remove(empleadoActual);
				break;
			}
		}

		empleados.add(empleado);
	}
	
}
