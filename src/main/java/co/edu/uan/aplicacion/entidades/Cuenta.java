package co.edu.uan.aplicacion.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cuenta {
	private long id;
	private long id_rol;
	private String correo;
	private String contrasena;
	private String nombre;
	
}
