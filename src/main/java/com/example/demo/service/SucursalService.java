package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Sucursal;

public interface SucursalService {
	
	public Sucursal crearSucursal(Sucursal sucursal );
	public Sucursal mostrarSucursalID(Long id);
	public List<Sucursal> mostrarSucursales();

}
