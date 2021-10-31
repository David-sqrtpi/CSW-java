package co.edu.uan.aplicacion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Empleado;

@RestController
public class empleadoControlador {
	@GetMapping("/empleado")
	public Empleado getEmpleado(@RequestBody Empleado empleado) {
		return empleado;
	}
	
	@GetMapping("hola")
	public String decirHola() {
		return "Hola";
	}
	
}
