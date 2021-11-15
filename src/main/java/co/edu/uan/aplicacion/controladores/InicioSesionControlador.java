package co.edu.uan.aplicacion.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
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

@CrossOrigin
@RestController
@RequestMapping("login")
public class InicioSesionControlador {
	PreparedStatement pst= null;
	ResultSet rs=null;

	public List<Cuenta> cuentas;
	@PostConstruct
	public void init() {
		cuentas = Stream.of(
				new Cuenta(1, 1, "admin@gmail.com","12345", "pepito"),
				new Cuenta(1, 2, "gerente@gmail.com","12345", "pepe")
		).collect(Collectors.toList());
		
	}
	
	@PostMapping
	public long iniciarSesion(@RequestBody InicioSesion inicio)
	{
		String sql = "select from cuenta where email = ? and contrasena = ?";
		String email = inicio.getEmail();
		String key = inicio.getContrasena();
		for(int i = 0;i<cuentas.size();i++) {
			if(email.equals(cuentas.get(i).getCorreo())) {
				if(key.equals(cuentas.get(i).getContrasena())) {
					return cuentas.get(i).getId();
				}else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	
}
