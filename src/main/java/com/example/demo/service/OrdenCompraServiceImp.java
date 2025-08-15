package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OrdenRequestDTO;
import com.example.demo.dto.ProductoCantidadDTO;
import com.example.demo.entity.DetailOrdenCompra;
import com.example.demo.entity.OrdenCompra;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Sucursal;
import com.example.demo.repository.OrdenCompraRepository;

@Service
public class OrdenCompraServiceImp implements OrdenCompraService {
	
	private OrdenCompraRepository ordenCompraRepository;
	private ProductoService productoService;
	private SucursalService sucursalService;
	private DetalleOrdenCompraService detalleOrdenService;
	
	public OrdenCompraServiceImp(OrdenCompraRepository ordenCompraRepository,
			ProductoService productoService,
			SucursalService sucursalService,
			DetalleOrdenCompraService detalleOrdenService) {
		this.ordenCompraRepository = ordenCompraRepository;
		this.sucursalService = sucursalService;
		this.productoService = productoService;
		this.detalleOrdenService = detalleOrdenService;
	}

	@Override
	public OrdenCompra mostrarOrdenCompraID(Long id) {
		return ordenCompraRepository.findById(id).get();
	}

	@Override
	public List<OrdenCompra> mostrarOrdenCompraTodas() {
		return ordenCompraRepository.findAll();
	}

	@Override
	@Transactional
	public OrdenCompra crearOrdenCompra(OrdenRequestDTO ordenCompra) {
		//Validar Sucursal
		Sucursal sucursal = sucursalService.mostrarSucursalID(ordenCompra.getSucursalId());
		
		//Crear Oden de compra
		OrdenCompra ordenCompraRegistrada = new OrdenCompra();
		ordenCompraRegistrada.setFecha(new Date());
		ordenCompraRegistrada.setSucursal(sucursal);
		
		ordenCompraRepository.save(ordenCompraRegistrada);
		
		//Guardar Productos en DetailOrdenCompra
		List<DetailOrdenCompra> detalles = new ArrayList<>();
		for (ProductoCantidadDTO producto : ordenCompra.getProductos()){
			Producto productoBD = productoService.mostrarProducto(producto.getProductoId());
			
			DetailOrdenCompra detalleNuevo = new DetailOrdenCompra();
			detalleNuevo.setCantidad(producto.getCantidad());
			detalleNuevo.setOrdenCompra(ordenCompraRegistrada);
			detalleNuevo.setProducto(productoBD);
			
			detalleOrdenService.crearDetalleCompra(detalleNuevo);
			detalles.add(detalleNuevo);
		}
		
		ordenCompraRegistrada.setListaDetalle(detalles);
		
		return ordenCompraRegistrada;
	}



}
