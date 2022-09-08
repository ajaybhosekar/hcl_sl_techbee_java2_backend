package demos.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demos.springboot.exception.ResourceNotFoundException;
import demos.springboot.model.Category;
import demos.springboot.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> getAllCategories() {
		Iterable<Category> categories = repository.findAll();
		List<Category> categoryList = new ArrayList<Category>();
		
		for(Category c: categories) {
			categoryList.add(c);
		}
		
		return categoryList;
	}
	
	public Category getById(int catId) {
		Category category = null;
		Optional<Category> opt = repository.findById(catId);
		if(opt.isPresent()) {
			category = opt.get();
		}
		return category;
	}
	
	public Category addCategory(Category c) {
		if(c == null) {
			throw new NullPointerException("Category object is null in class - CategoryService and method: addCategory");
		}
		return repository.save(c);
	}
	
	public Category updateCategory(Category c) {
		if(c == null) {
			throw new NullPointerException("Category object is null in class - CategoryService and method: updateCategory");
		}
		
		Category category = null;
		Optional<Category> opt = repository.findById(c.getCategoryId());
		if(opt.isPresent()) {
			category = opt.get();
		}
		else {
			throw new ResourceNotFoundException("Category", "CategoryId", c.getCategoryId());
		}
		
		
		return repository.save(c);
	}
	
	public void deleteCategory(int catId) {
		
		
		Optional<Category> opt = repository.findById(catId);
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException("Category", "CategoryId", catId);
		}
		
		repository.deleteById(catId);
	}

}
