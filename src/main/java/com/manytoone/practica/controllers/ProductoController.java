package com.manytoone.practica.controllers;

import com.manytoone.practica.models.Categoria;
import com.manytoone.practica.models.Producto;
import com.manytoone.practica.services.CategoriaService;
import com.manytoone.practica.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService; //iyeccion de dependencias
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping ("/listar") //para obtener datos de nuestro base de datos o todos los productos que se tenga ahí
    public ResponseEntity<List<Producto>> listarProductos(){
        return  new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return  new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") //para poder ver u obtener un producto solo por su id
    public  ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
        return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/crear") //es para crear o registrar un producto nuevo
    //@RequestBody= esta anotacion convierte este clase jeison a una clase pojo o clase producto
    public  ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return  new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}") //para editar o actualizar un producto; el id de abajo tiene que ser igual a este id
    public  ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,@RequestBody Producto producto){
        Producto productoEncontrado = productoService.findById(id);

        if (productoEncontrado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try{
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setPrecio(producto.getPrecio());
            productoEncontrado.setImagen(producto.getImagen());
            productoEncontrado.setCategoria(producto.getCategoria());
            return new ResponseEntity<>(productoService.save(productoEncontrado), HttpStatus.CREATED);
        }catch (DataAccessException e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/eliminar/{id}") //para eliminar datos o productos registrados en la BD
    public  ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        productoService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);

    }

}
