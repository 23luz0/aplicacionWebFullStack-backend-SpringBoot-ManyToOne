package com.manytoone.practica.dao;

import com.manytoone.practica.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {
}
