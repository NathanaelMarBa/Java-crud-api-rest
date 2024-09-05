package com.nael.apirest.simple_apirest.Controllers;

import com.nael.apirest.simple_apirest.Entities.Product;
import com.nael.apirest.simple_apirest.Repositories.IproductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class productoController {

    @Autowired
    private IproductoRepository iproductoRepository;

    @GetMapping
    public List <Product> obtenerProductos(){
        return iproductoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product obtenerOroductoPorId(@PathVariable Long id){
        return iproductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));
    }

    @PostMapping
    public Product crearProducto(@RequestBody Product product){
        return iproductoRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product actualizarProducto(@PathVariable Long id, @RequestBody Product detailsProduct){
       Product product = iproductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));

        product.setNombre(detailsProduct.getNombre());
        product.setPrecio(detailsProduct.getPrecio());

        return iproductoRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public Product borrarProducto(@PathVariable Long id){
        Product product = iproductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));

        iproductoRepository.delete(product);
        return product;
    }


}
