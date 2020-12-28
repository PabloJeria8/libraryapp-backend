package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escalab.model.Editorial;

public interface IEditorialRepo extends JpaRepository<Editorial, Integer> {

}
