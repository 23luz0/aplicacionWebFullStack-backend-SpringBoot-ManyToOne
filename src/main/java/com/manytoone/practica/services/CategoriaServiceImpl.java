package com.manytoone.practica.services;

import com.manytoone.practica.dao.CategoriaDao;
import com.manytoone.practica.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao; //iyeccion de dependencias

    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }
}
