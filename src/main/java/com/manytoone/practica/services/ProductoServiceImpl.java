package com.manytoone.practica.services;

import com.manytoone.practica.dao.ProductoDao;
import com.manytoone.practica.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao; //iyeccion de dependencias


    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);

    }
}
