package com.springBoot.cloud.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//definiciones JPA
@Entity
@Table(name="tbl_Producto")
//Definiciones de lombok
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder(toBuilder = true) 
@ToString
public class Producto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name="nombre")
	@NotEmpty(message = "Nombre no puede ir vacio")
	private String nombre;
	
	@Column(name="precio")
	@Positive(message="el precio no puede ser menor a 0")
	private double precio;
	
	@Column(name="descripcion")
	@Size(min = 1, max = 200, message="la descripción debe contener entre 1 y 200 caracteres")
	private String descripcion;
	
	@Column(name="existencias")
	@Positive(message = "las existencias deben ser igual o mayores a 0")
	private int existencias;
	
	@Column(name="fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;
	
	@NotNull(message="la categoria no puede ser vacía")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	//Atributo que indica en que puerto del balanceo de carga se procesó
	@Transient
	private int puerto_balanceo;
}
