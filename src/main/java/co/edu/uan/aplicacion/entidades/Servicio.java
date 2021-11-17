package co.edu.uan.aplicacion.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
	private long id;
	private String servicio;
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", servicio=" + servicio + "]";
	}
	
	
}