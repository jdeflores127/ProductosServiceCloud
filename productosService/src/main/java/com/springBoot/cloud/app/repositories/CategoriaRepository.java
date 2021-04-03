package com.springBoot.cloud.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.cloud.app.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
}
