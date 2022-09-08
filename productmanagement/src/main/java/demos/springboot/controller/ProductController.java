package demos.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demos.springboot.exception.ResourceNotFoundException;
import demos.springboot.model.Category;
import demos.springboot.model.Product;
import demos.springboot.repository.ProductRepository;
import demos.springboot.service.ProductService;
import net.bytebuddy.implementation.bind.annotation.Default;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products =  service.getAllProducts();
		ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id")int prodId) {
		Product product =  service.getById(prodId);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/products/brand/{brand}") //http://localhost:9090/products/brand/abc
	public ResponseEntity<List<Product>> findAllByBrand(@PathVariable("brand")String brand){
		List<Product> products =  service.findAllByBrand(brand);
		ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		return response;
	}
	
	
	
	
	/*
	@GetMapping("/categories/{catId}/products")
	public ResponseEntity<List<Product>> findAllByCategoryCategoryId(@PathVariable("catId")int catId){
		List<Product> products =  service.findAllByCategoryCategoryId(catId);
		ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		return response;
	}
	*/
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		
		Product product =  service.addProduct(p);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.CREATED);
		return response;
	}
	
	
	/*
	@PostMapping("/categories/{catId}/products")
	public ResponseEntity<Product> addProduct(@PathVariable("catId")int catId, @RequestBody Product p) {
		p.setCategory(new Category(catId, "",""));
		Product product =  service.addProduct(p);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.CREATED);
		return response;
	}
	*/
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int prodId, @RequestBody Product p) {
		
		p.setProdId(prodId);
		Product product =  service.updateProduct(p);
		ResponseEntity<Product> response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id")int prodId) {
		service.deleteProduct(prodId);
		
	}
	
	

}
