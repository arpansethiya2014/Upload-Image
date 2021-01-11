package com.arpan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpan.beans.Product;
import com.arpan.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;

	public List<Product> getAllProducts() {
		return pr.findAll();
	}

	public void saveProduct(Product product) {
		pr.save(product);
	}

	public Product getProduct(int id) {
		return pr.findById(id).get();
	}

	public void deleteProduct(int id) {
		pr.deleteById(id);
	}
}
