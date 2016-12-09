package es.uc3m.tiw;

import java.io.File;
import java.io.FileInputStream;

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
		
		
		
		File file1 = new File("images/cajones.jpg");
		File file2 = new File("images/bici.jpg");
		File file3 = new File("images/sofa.jpg");
		File file4 = new File("images/iphone.JPG");
		File file5 = new File("images/bolso.jpg");
		File file6 = new File("images/cachimba.jpg");
		
		byte[] File1 = new byte[(int) file1.length()];
		byte[] File2 = new byte[(int) file2.length()];
		byte[] File3 = new byte[(int) file3.length()];
		byte[] File4 = new byte[(int) file4.length()];
		byte[] File5 = new byte[(int) file5.length()];
		byte[] File6 = new byte[(int) file6.length()];
		
		try {
            FileInputStream fileInputStream1 = new FileInputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            FileInputStream fileInputStream3 = new FileInputStream(file3);
            FileInputStream fileInputStream4 = new FileInputStream(file4);
            FileInputStream fileInputStream5 = new FileInputStream(file5);
            FileInputStream fileInputStream6 = new FileInputStream(file6);
            
            fileInputStream1.read(File1);
            fileInputStream2.read(File2);
            fileInputStream3.read(File3);
            fileInputStream4.read(File4);
            fileInputStream5.read(File5);
            fileInputStream6.read(File6);
            
            fileInputStream1.close();
            fileInputStream2.close();
            fileInputStream3.close();
            fileInputStream4.close();
            fileInputStream5.close();
            fileInputStream6.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Producto producto1 = new Producto("Cajonera Blanca IKEA" , "Mobiliario" , "Mueble blanco de IKEA con cinco cajones", "45" , "Vendido", 1, File1 );
		Producto producto2 = new Producto("Bicicleta de carretera" , "Vehiculos" , "Bicicleta de carretera Elektra Race", "340" , "Disponible", 2, File2);
		Producto producto3 = new Producto("Sofa de esquina" , "Mobiliario" , "Sofa blanco de esquina con almacenaje", "190" , "Disponible", 1, File3);
		Producto producto4 = new Producto("Iphone 4s" , "Electrónica" , "Iphone 4s con cargador y auriculares incluidos", "120" , "Disponible", 3, File4);
		Producto producto5 = new Producto("Bolso Miau" , "Moda y belleza" , "Bolso de piel de serpiente valorado en 750 euros", "180" , "Vendido", 1, File5);
		Producto producto6 = new Producto("Cachimba" , "Otros" , "Cachimba de 50cm traida de Marruecos", "65" , "Disponible", 2, File6);
		
		repository.saveAndFlush(producto1);
		repository.saveAndFlush(producto2);
		repository.saveAndFlush(producto3);
		repository.saveAndFlush(producto4);
		repository.saveAndFlush(producto5);
		repository.saveAndFlush(producto6);
		
	}
}
