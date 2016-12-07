package es.uc3m.tiw.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	

}
