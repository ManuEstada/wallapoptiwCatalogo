package es.uc3m.tiw.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.CatalogoRepository;
import es.uc3m.tiw.dominios.Producto;

@CrossOrigin
@RestController
public class CatalogoController {
	
	@Autowired
	private CatalogoRepository repository;
	
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET)
	public List<Producto> getProductos(){
		return repository.findAll();
	}

	@RequestMapping(value="/findByID", method=RequestMethod.POST)
	public Producto findByID(@RequestBody long id){
		return repository.findOne(id);
	}

	@RequestMapping(value="/findByText", method=RequestMethod.POST)
	public List<Producto> findByText(@RequestBody String texto){
		String titulo, descripcion, textoUpper;
		List<Producto> resultado;
		if(texto != null) {
			resultado = new ArrayList<Producto>();
			textoUpper = texto.toUpperCase();
			List<Producto> lista = repository.findAll();
			for(Producto p : lista) {
				titulo = p.getTitulo().toUpperCase();
				descripcion = p.getDescripcion().toUpperCase();
				if (titulo.contains(textoUpper) || descripcion.contains(textoUpper)){
					resultado.add(p);
				}
			}
		} else {
			resultado = repository.findAll();
		}
		return resultado;
	}

	@RequestMapping(value="/findByClienteID", method=RequestMethod.POST)
	public List<Producto> findByClienteID(@RequestBody long clienteID){
		return repository.findByClienteID(clienteID);
	}

	@RequestMapping(value="/findByProduct", method=RequestMethod.POST)
	public List<Producto> findByProduct(@RequestBody Producto producto){
		List<Producto> resultado = new ArrayList<Producto>();
		List<Producto> lista = repository.findAll();
		for(Producto p : lista) {
			if((producto.getCategoria() == null || "".equals(producto.getCategoria())  || (p.getCategoria() != null && 
							p.getCategoria().toUpperCase().contains(producto.getCategoria().toUpperCase()))) &&
				(producto.getTitulo() == null || "".equals(producto.getTitulo()) || (p.getTitulo() != null && 
							p.getTitulo().toUpperCase().contains(producto.getTitulo().toUpperCase()))) &&
				(producto.getDescripcion() == null || "".equals(producto.getDescripcion()) || (p.getDescripcion() != null && 
							p.getDescripcion().toUpperCase().contains(producto.getDescripcion().toUpperCase())))){
				resultado.add(p);
			}
		}
		return resultado;
	}
	
	
	@RequestMapping(value="/anadirProducto", method=RequestMethod.POST)
	public void saveProducto(@RequestBody Producto producto){
		repository.saveAndFlush(producto);
	}

	@RequestMapping(value="/modificar", method=RequestMethod.POST)
	public boolean modificar(@RequestBody Producto producto){
		repository.saveAndFlush(producto);
		return true;
	}

	@RequestMapping(value="/eliminar", method=RequestMethod.POST)
	public boolean eliminar(@RequestBody long id){
		repository.delete(id);
		return true;
	}
}
