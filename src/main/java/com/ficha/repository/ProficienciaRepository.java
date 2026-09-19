package com.ficha.repository;

import com.ficha.Entity.Proficiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficienciaRepository extends JpaRepository<Proficiencia, Integer> {
}
