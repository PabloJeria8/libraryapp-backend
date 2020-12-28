package com.escalab.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.escalab.model.ConsultaLibros;

public interface IConsultaLibrosRepo extends JpaRepository<ConsultaLibros, Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO consulta_libros(id_autor, id_libro) VALUES (:idAutor, :idLibro)", nativeQuery = true)
	Integer registrar(@Param("idAutor") Integer idAutor, @Param("idLibro") Integer idLibro);
	
	@Query("from ConsultaLibros cl where LOWER(cl.autor.nombres) like %:nombreCompleto% or LOWER(cl.autor.apellidos) like %:nombreCompleto%")
	List<ConsultaLibros> buscarLibrosporAutor(@Param("nombreCompleto") String nombreCompleto);
	
	@Query("from ConsultaLibros cl where LOWER(cl.libro.titulo) like %:nombreLibro%")
	List<ConsultaLibros> buscarLibrosporNombre(@Param("nombreLibro") String nombreLibro);
	
}
