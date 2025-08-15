package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DetailOrdenCompra;
import com.example.demo.repository.DatailOrdenCompraRepository;

@Service
public class DetalleOrdenCompraServiceImp implements DetalleOrdenCompraService {
	
	private DatailOrdenCompraRepository repository;
	
	public DetalleOrdenCompraServiceImp(DatailOrdenCompraRepository repository) {
		this.repository = repository;
	}

	@Override
	public DetailOrdenCompra crearDetalleCompra(DetailOrdenCompra detailOrdenCompra) {
		repository.save(detailOrdenCompra);
		return detailOrdenCompra;
	}

}
