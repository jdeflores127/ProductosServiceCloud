package com.springBoot.cloud.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.cloud.app.entities.Categoria;
import com.springBoot.cloud.app.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
	public List<Producto> findByCategoria(Categoria categoria);
}
