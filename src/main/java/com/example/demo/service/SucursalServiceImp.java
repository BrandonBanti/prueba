package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Sucursal;
import com.example.demo.repository.SucursalRepository;

@Service
public class SucursalServiceImp implements SucursalService {
	
	private SucursalRepository sucursalRepository;
	
	public SucursalServiceImp(SucursalRepository sucursalRepository) {
		this.sucursalRepository = sucursalRepository;
	}

	@Override
	public Sucursal crearSucursal(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
		return sucursal;
	}

	@Override
	public Sucursal mostrarSucursalID(Long id) {
		Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
		if(sucursalOptional.isPresent()) {
			return sucursalOptional.get();
		}
		
		throw new IllegalArgumentException("No existe la sucursal");
		
	}

	@Override
	public List<Sucursal> mostrarSucursales() {
		return sucursalRepository.findAll();
	}

}
