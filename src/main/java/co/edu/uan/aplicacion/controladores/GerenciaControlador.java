package co.edu.uan.aplicacion.controladores;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uan.aplicacion.entidades.Gerencia;


@CrossOrigin
@RestController
@RequestMapping("/gerencias")
public class GerenciaControlador {
	public List<Gerencia> gerencias;
	
	@PostConstruct
	public void init() {			
		gerencias = Stream.of(
				new Gerencia(0, "Staff"),
				new Gerencia(1, "Castilla")
		).collect(Collectors.toList());
	}
	
	@GetMapping
	public List<Gerencia> getGerencias() {
		return gerencias;
	}
}
