package demos.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demos.springboot.exception.ResourceNotFoundException;
import demos.springboot.model.Category;
import demos.springboot.model.Product;
import demos.springboot.repository.ProductRepository;
import demos.springboot.service.CategoryService;
import demos.springboot.service.ProductService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		
		List<Category> categories =  service.getAllCategories();
		ResponseEntity<List<Category>> response = new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
		String s = null;
		s = s.concat("Hello");
		
		return response;
	}
	
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getById(@PathVariable("id")int catId) {
		
		Category category = service.getById(catId);
		ResponseEntity<Category> response = new ResponseEntity<Category>(category, HttpStatus.OK);
		String s = null;
		s = s.concat("Hello");
		return response;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category c) {
		Category category = service.addCategory(c);
		ResponseEntity<Category> response = new ResponseEntity<Category>(category, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int catId, @RequestBody Category c) {
		c.setCategoryId(catId);
		Category category = service.updateCategory(c);
		ResponseEntity<Category> response = new ResponseEntity<Category>(category, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id")int catId) {
		service.deleteCategory(catId);
		ResponseEntity<String> response = new ResponseEntity<String>("Category successfully deleted", HttpStatus.OK);
		return response;
	}
	
	/*
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException e) {
		System.out.println("Inside handleNullPointerException");
		return e.getMessage();
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public String handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("Inside handleResourceNotFoundException");
		return e.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleGenericException(Exception e) {
		System.out.println("Inside handleGenericException");
		return e.getMessage();
	}
	*/
	
	

}
