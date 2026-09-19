package com.ficha.repository;

import com.ficha.Entity.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributoRepository extends JpaRepository<Atributo, Integer> {

}
