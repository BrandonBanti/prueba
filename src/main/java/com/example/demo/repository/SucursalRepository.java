package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
