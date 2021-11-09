package co.edu.uan.aplicacion.controladores;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uan.aplicacion.entidades.Servicio;

@CrossOrigin
@RestController
@RequestMapping("/servicios")
public class ServicioControlador {
	public List<Servicio> servicios;
	
	@PostConstruct
	public void init() {			
		servicios = Stream.of(
				new Servicio(0, "Staff"),
				new Servicio(1, "Castilla")
		).collect(Collectors.toList());
	}
	
	@GetMapping
	public List<Servicio> getServicios() {
		return servicios;
	}
}
