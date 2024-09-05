package com.nael.apirest.simple_apirest.Repositories;

import com.nael.apirest.simple_apirest.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IproductoRepository extends JpaRepository<Product, Long> {
}
