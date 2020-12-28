package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escalab.model.Libro;

public interface ILibroRepo extends JpaRepository<Libro, Integer> {

}
