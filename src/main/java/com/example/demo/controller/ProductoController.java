package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestProductoPrecioDTO;
import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {
	
	private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProduct (){
		List<Producto> listProductos = productoService.mostrarProductos();
		return ResponseEntity.ok(listProductos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getAllProduct(@PathVariable Long id ){
		Producto product = productoService.mostrarProducto(id);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<?> postProduct(@RequestBody Producto producto){
		productoService.crearProducto(producto);
		return ResponseEntity.ok(producto);
		
	}
	
	@PutMapping
	public ResponseEntity<?> putProduct(@RequestBody Producto producto){
		productoService.actualizarProducto(producto);
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/precio")
	public ResponseEntity<?> putProductPrice(@RequestBody RequestProductoPrecioDTO producto){
		Producto productoResult = productoService.actualizarProductoPrecio(producto);
		return ResponseEntity.ok(productoResult);
	}

}
