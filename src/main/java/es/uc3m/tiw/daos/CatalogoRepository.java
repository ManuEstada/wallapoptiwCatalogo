package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominios.Producto;

public interface CatalogoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByClienteID(long clienteID);
}
