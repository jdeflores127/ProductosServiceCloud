package com.springBoot.cloud.app;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springBoot.cloud.app.entities.Categoria;
import com.springBoot.cloud.app.entities.Producto;
import com.springBoot.cloud.app.repositories.ProductoRepository;

@DataJpaTest
public class ProductoRepositoryMockTest {
	@Autowired
	private ProductoRepository productorepository;
	
	@Test
	private void iniciarTestRepositorios() {
		Producto productoBuscar= Producto.builder()
				.nombre("Aceitunas en salmuera")
				.precio(13.50)
				.descripcion("aceitunas en salmuera provenientes de españa")
				.existencias(12)
				.categoria(Categoria.builder().idCategoria(2L).build())
				.fecharegistro(new Date())
				.build();
		
		productoBuscar=productorepository.save(productoBuscar);
		System.out.println(productoBuscar.toString());
		assertThat(productoBuscar).isNotNull();
	}
}
