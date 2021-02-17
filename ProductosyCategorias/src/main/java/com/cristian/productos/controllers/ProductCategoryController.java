package com.cristian.productos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cristian.productos.models.Category;
import com.cristian.productos.models.Product;
import com.cristian.productos.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	
	private final ProductCategoryService proServ;
	
	public ProductCategoryController(ProductCategoryService proServ) {
		this.proServ = proServ;
	}

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/newProduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product product) {
		proServ.createProduct(product);
		return "redirect:/products/"+ product.getId();
	}
	
	@RequestMapping("/products/{id}")
	public String detailProduct(Model model, @PathVariable("id") Long id) {
		Product product = proServ.infoProduct(id);
		List<Category> categories = new ArrayList<>();
		for(Category category : proServ.allCategories()) {
			if(product.getCategories().contains(category) == false) {
				categories.add(category);
			}
		}
		model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		model.addAttribute("added", product.getCategories());
		return "/infoProduct.jsp";
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.POST)
	public String addCategory(Model model, @RequestParam("categoryId") Long categoryId, @PathVariable("id") Long productId) {
		Product product = proServ.infoProduct(productId);
		proServ.add(proServ.infoCategory(categoryId), product);
		return "redirect:/products/"+ product.getId();
	}
	
	@RequestMapping("/categories/new")
	public String newCategory() {
		return "/newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@RequestParam("name") String name) {
		Category category = new Category(name);
		proServ.createCategory(category);
		return "redirect:/categories/"+ category.getId();
		
	}
	
	@RequestMapping("/categories/{id}")
	public String infoCategory(Model model, @PathVariable("id") Long id) {
		Category category = proServ.infoCategory(id);
		List<Product> products = new ArrayList<>();
		for(Product product : proServ.allProducts()) {
			if(category.getProducts().contains(product) == false) {
				products.add(product);
			}
		}
		model.addAttribute("products", products);
		model.addAttribute("category", category);
		model.addAttribute("added", category.getProducts());
		return "/infoCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String addProduct(Model model, @RequestParam("productId") Long idProduct, @PathVariable("id") Long idCategory) {
		Category category = proServ.infoCategory(idCategory);
		proServ.add(category, proServ.infoProduct(idProduct));
		return "redirect:/categories/"+ category.getId();
	}
}
