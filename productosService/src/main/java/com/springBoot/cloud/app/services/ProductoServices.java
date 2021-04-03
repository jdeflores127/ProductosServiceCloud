package com.springBoot.cloud.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.cloud.app.entities.Producto;
import com.springBoot.cloud.app.repositories.ProductoRepository;

@Service
public class ProductoServices {
	@Autowired 
	private ProductoRepository productoRepository;
	
	public List<Producto> obtenerListaProductos(){
		List<Producto> listaProductos = productoRepository.findAll();
		return listaProductos;
	}
	
	public Producto obtenerProducto(Long idproducto) throws Exception {
		Optional<Producto> productoDB = productoRepository.findById(idproducto);
		if(productoDB.isPresent())
			return productoDB.get();
		else
			throw new Exception("Persona no encontrada en base de datos"); 
	}
	
	public void registrarProducto(Producto producto) {
		try {
			producto = producto.toBuilder()
			.idProducto(0L)
			.fecharegistro(new Date())
			.build();
			
			productoRepository.save(producto);
		}catch(IllegalArgumentException e) {
			throw new RuntimeException("la entidad no puede ser nula");
		}catch(Exception e) {
			throw new RuntimeException("Error desconocido al insertar el registro: "+e.getMessage());
		}
	}
}
