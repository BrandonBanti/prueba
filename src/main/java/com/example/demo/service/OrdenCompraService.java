package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrdenRequestDTO;
import com.example.demo.entity.OrdenCompra;

public interface OrdenCompraService {
	
	public OrdenCompra mostrarOrdenCompraID(Long id);
	
	public List<OrdenCompra> mostrarOrdenCompraTodas();
	
	public OrdenCompra crearOrdenCompra(OrdenRequestDTO ordenCompra);

}
