package com.ficha.repository;


import com.ficha.Entity.Resistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResistenciaRepository extends JpaRepository<Resistencia, Integer> {

}
