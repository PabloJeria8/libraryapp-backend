package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escalab.model.Autor;

public interface IAutorRepo extends JpaRepository<Autor, Integer> {

}
