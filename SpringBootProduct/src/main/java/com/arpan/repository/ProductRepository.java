package com.arpan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpan.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
