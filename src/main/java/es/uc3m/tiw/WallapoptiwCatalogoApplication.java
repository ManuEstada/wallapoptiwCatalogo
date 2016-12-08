package es.uc3m.tiw;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uc3m.tiw.daos.CatalogoRepository;
import es.uc3m.tiw.dominios.Producto;

@SpringBootApplication
public class WallapoptiwCatalogoApplication {
	
	@Autowired
	private CatalogoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WallapoptiwCatalogoApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		Producto producto1 = new Producto("Cajonera Blanca IKEA" , "Mobiliario" , "Mueble blanco de IKEA con cinco cajones", "45" , "Vendido", 1);
		Producto producto2 = new Producto("Bicicleta de carretera" , "Vehiculos" , "Bicicleta de carretera Elektra Race", "340" , "Disponible", 2);
		Producto producto3 = new Producto("Sofa de esquina" , "Mobiliario" , "Sofa blanco de esquina con almacenaje", "190" , "Disponible", 1);
		Producto producto4 = new Producto("Iphone 4s" , "Electrónica" , "Iphone 4s con cargador y auriculares incluidos", "120" , "Disponible", 3);
		Producto producto5 = new Producto("Bolso Miau" , "Moda y belleza" , "Bolso de piel de serpiente valorado en 750 euros", "180" , "Vendido", 1);
		Producto producto6 = new Producto("Cachimba" , "Otros" , "Cachimba de 50cm traida de Marruecos", "65" , "Disponible", 2);
		
		repository.saveAndFlush(producto1);
		repository.saveAndFlush(producto2);
		repository.saveAndFlush(producto3);
		repository.saveAndFlush(producto4);
		repository.saveAndFlush(producto5);
		repository.saveAndFlush(producto6);
		
	}
}
