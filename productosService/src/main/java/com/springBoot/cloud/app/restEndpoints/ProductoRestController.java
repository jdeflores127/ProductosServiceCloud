package com.springBoot.cloud.app.restEndpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springBoot.cloud.app.entities.Producto;
import com.springBoot.cloud.app.services.ProductoServices;
import com.springBoot.cloud.app.utils.Utilidades;

@RestController
@RequestMapping("/productosServices")
public class ProductoRestController {
	
	@Autowired 
	private ProductoServices productoServices;
	
	@GetMapping("/productos")
	public List<Producto> obtenerListaPersonas(){
		return productoServices.obtenerListaProductos();	
	}
	
	@GetMapping("/productos/{idProducto}")
	public Producto obtenerPersona(@PathVariable("idProducto") Long idPersona) throws Exception {
		return productoServices.obtenerProducto(idPersona);
	}
	
	@PostMapping("/productos")
	public String registraProducto(@Valid @RequestBody Producto producto, BindingResult result){
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utilidades.getFormatoErrorBindingResult(result)); 
		}
		productoServices.registrarProducto(producto);
		return "producto registrado con exito";
	}
}
