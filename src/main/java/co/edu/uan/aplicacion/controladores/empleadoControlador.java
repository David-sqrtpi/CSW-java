package co.edu.uan.aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Empleado;

@RestController
public class empleadoControlador {
	public List<Empleado> empleados = new ArrayList<Empleado>();
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleado() {
		return empleados;
	}
	
	@PostMapping("/empleados")
	public void crearEmpleado(@RequestBody Empleado empleado) {
		empleados.add(empleado);
	}
	
	@PutMapping("/empleados/{idEmpleado}")
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
