package com.cristian.productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.productos.models.Category;
import com.cristian.productos.models.Product;
import com.cristian.productos.repositories.CategoryRepository;
import com.cristian.productos.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	
	private final ProductRepository productRepo;
	private final CategoryRepository catRepo;

	
	public ProductCategoryService(ProductRepository productRepo, CategoryRepository catRepo) {
		this.productRepo = productRepo;
		this.catRepo = catRepo;
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product infoProduct(Long id) {
		Optional<Product> op = productRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	
	public Category infoCategory(Long id) {
		Optional<Category> op = catRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public List<Category> allCategories(){
		return catRepo.findAll();
	}

	public void add(Category category, Product product) {
		product.getCategories().add(category);
		productRepo.save(product);
		catRepo.save(category);
	}
	
}
