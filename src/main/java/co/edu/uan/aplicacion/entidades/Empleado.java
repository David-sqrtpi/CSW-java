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
	private long genero;
	private LocalDate fechaIngreso;
}
