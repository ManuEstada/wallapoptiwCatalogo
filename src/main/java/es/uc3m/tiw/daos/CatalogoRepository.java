package es.uc3m.tiw.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominios.Producto;

public interface CatalogoRepository extends JpaRepository<Producto, Long> {

}
