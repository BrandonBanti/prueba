package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrdenRequestDTO;
import com.example.demo.entity.OrdenCompra;
import com.example.demo.service.OrdenCompraService;

@RestController
@RequestMapping("/v1/ordencompra")
public class OrdenCompraController {
	
	private OrdenCompraService ordenCompraService;
	
	public OrdenCompraController (OrdenCompraService ordenCompraService) {
		this.ordenCompraService = ordenCompraService;
	}
	
	@GetMapping
	public ResponseEntity<List<OrdenCompra>> getAllOrden (){
		List<OrdenCompra> listOrdenes = ordenCompraService.mostrarOrdenCompraTodas();
		return ResponseEntity.ok(listOrdenes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdenCompra> getAllOrden (@PathVariable Long id ){
		OrdenCompra orden = ordenCompraService.mostrarOrdenCompraID(id);	
		return ResponseEntity.ok(orden);
	}
	
	@PostMapping
	public ResponseEntity<?> postOrden(@RequestBody OrdenRequestDTO orden){
		ordenCompraService.crearOrdenCompra(orden);
		return ResponseEntity.ok(orden);
		
	}

}
