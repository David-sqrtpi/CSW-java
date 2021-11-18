package co.edu.uan.aplicacion.entidades;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
	private long idServicio;
	private long idGerencia;
	private String nombre;
	private long cedula;
	private long idGenero;
	private LocalDate fechaIngreso;
	
	@Override
	public String toString() {
		return "Empleado [idServicio=" + idServicio + ", idGerencia=" + idGerencia + ", nombre=" + nombre + ", cedula="
				+ cedula + ", genero=" + idGenero + ", fechaIngreso=" + fechaIngreso + "]";
	}
}
