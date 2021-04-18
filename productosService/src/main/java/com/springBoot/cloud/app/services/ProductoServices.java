package com.springBoot.cloud.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springBoot.cloud.app.entities.Producto;
import com.springBoot.cloud.app.repositories.ProductoRepository;

@Service
public class ProductoServices {
	@Autowired 
	private ProductoRepository productoRepository;
	
	//Lo usamos para obtener el puerto del balanceador
	@Autowired
	private Environment environment;
	public List<Producto> obtenerListaProductos(){
		List<Producto> listaProductos = productoRepository.findAll();
		listaProductos.stream().map(producto ->{
			producto.setPuerto_balanceo(Integer.parseInt(environment.getProperty("local.server.port")));
			return producto;
		})
		.collect(Collectors.toList());
		return listaProductos;
	}
	
	public Producto obtenerProducto(Long idproducto) throws Exception {
		Optional<Producto> productoDB = productoRepository.findById(idproducto);
		if(productoDB.isPresent()) {
			productoDB.get().setPuerto_balanceo(Integer.parseInt(environment.getProperty("local.server.port")));
			return productoDB.get();
		}
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
