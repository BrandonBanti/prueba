package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RequestProductoPrecioDTO;
import com.example.demo.entity.Producto;


public interface ProductoService {
	
	public List<Producto> mostrarProductos();
	public Producto mostrarProducto(Long id);
	public Producto actualizarProducto(Producto producto);
	public Producto actualizarProductoPrecio(RequestProductoPrecioDTO producto);
	public Producto crearProducto(Producto producto);
}
