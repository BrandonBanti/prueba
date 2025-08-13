package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrdenCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idOrdenCompra")
	private OrdenCompra ordenCompra;
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;

}
