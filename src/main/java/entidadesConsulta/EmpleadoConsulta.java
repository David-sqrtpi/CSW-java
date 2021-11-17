package entidadesConsulta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoConsulta {
	private long cedula;
	private long idServicio;
	private long idGerencia;
	private String nombre;
	private long idGenero;
	private LocalDate fechaIngreso;
	private String servicio;
	private String gerencia;
	private String genero;
}
