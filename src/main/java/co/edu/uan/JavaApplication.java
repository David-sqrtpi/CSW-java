package co.edu.uan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
=======
import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.Servicio;
import conector.Conexion;
>>>>>>> a39f21c9ce2c3fa3a000e0730f1738ecd041bcaa

@SpringBootApplication
public class JavaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		Conexion conexion = new Conexion();
		conexion.conectar();
	}

}
