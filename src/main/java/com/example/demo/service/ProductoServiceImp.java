package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestProductoPrecioDTO;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Sucursal;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService  {
	
	private ProductoRepository productoRepository;
	
	public ProductoServiceImp (ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public List<Producto> mostrarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto mostrarProducto(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Producto> productoOptional = productoRepository.findById(id);
		if(productoOptional.isPresent()) {
			return productoOptional.get();
		}
		
		throw new IllegalArgumentException("No existe el producto");
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// Actuaslizar Producto
		productoRepository.save(producto);
		return producto;
	}

	@Override
	public Producto crearProducto(Producto producto) {
		// crear producto
		productoRepository.save(producto);
		return producto;
	}

	@Override
	public Producto actualizarProductoPrecio(RequestProductoPrecioDTO producto) {
		// TODO Auto-generated method stub
		Optional<Producto> productoBD = productoRepository.findById(producto.getId());
		
		if(productoBD.isPresent())
		{
			Producto productoResult = productoBD.get();
			productoResult.setPrecio(producto.getPrecio());
			productoRepository.save(productoResult);
			return productoResult;
		}
		
		throw new IllegalArgumentException("No existe el Producto");
	}

}
