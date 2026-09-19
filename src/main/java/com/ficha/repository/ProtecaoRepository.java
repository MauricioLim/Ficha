package com.ficha.repository;

import com.ficha.Entity.Protecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtecaoRepository extends JpaRepository<Protecao, Integer> {
}
