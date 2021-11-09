package co.edu.uan.aplicacion.controladores;

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
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.Servicio;

@CrossOrigin
@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
	public List<Empleado> empleados;
	public List<Servicio> servicios;
	public List<Gerencia> gerencias;
	
	@PostConstruct
	public void init() {
		empleados = Stream.of(
				new Empleado(0, 1, 1, "Empleado 1", 123, "F", LocalDate.of(2021, 11, 11)),
				new Empleado(1, 1, 1, "Empleado 2", 234, "M", LocalDate.of(2021, 11, 11))
		).collect(Collectors.toList());
		
		List<Gerencia> gerencias = Stream.of(
				new Gerencia(0, "Gestión de riesgos"),
				new Gerencia(1, "Programación y planificación")
		).collect(Collectors.toList());
	}
	
	@GetMapping
	public List<Empleado> getEmpleado() {
		return empleados;
	}
	
	@PostMapping
	public void crearEmpleado(@RequestBody Empleado empleado) {
		empleados.add(empleado);
	}
	
	@PutMapping("/{idEmpleado}")
	public void actualizarEmpleado(@PathVariable long idEmpleado, @RequestBody Empleado empleado) {
		for (Empleado empleadoActual : empleados) {
			if(empleadoActual.getId() == idEmpleado) {
				empleados.remove(empleadoActual);
				break;
			}
		}
		empleado.setId(idEmpleado);
		empleados.add(empleado);
	}
	
}
