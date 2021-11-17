package co.edu.uan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import conector.Conexion;


@SpringBootApplication
public class JavaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		Conexion conexion = new Conexion();
		conexion.conectar();
	}

}
