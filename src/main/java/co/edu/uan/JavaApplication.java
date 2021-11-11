package co.edu.uan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.uan.aplicacion.entidades.Empleado;
import co.edu.uan.aplicacion.entidades.Gerencia;
import co.edu.uan.aplicacion.entidades.Servicio;
import conector.Conexion;

@SpringBootApplication
public class JavaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
		Conexion conexion = new Conexion();
		conexion.conectar();
	}

}
