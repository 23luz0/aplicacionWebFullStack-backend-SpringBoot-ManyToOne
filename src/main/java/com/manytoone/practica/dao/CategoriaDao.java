package com.manytoone.practica.dao;

import com.manytoone.practica.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
}
