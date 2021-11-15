package co.edu.uan.aplicacion.entidades;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InicioSesion {
	
	private String email;
	private String contrasena;

}
