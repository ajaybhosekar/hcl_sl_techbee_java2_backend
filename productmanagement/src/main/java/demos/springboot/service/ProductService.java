package demos.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import demos.springboot.exception.ResourceNotFoundException;
import demos.springboot.model.Category;
import demos.springboot.model.Product;
import demos.springboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts() {
		Iterable<Product> products = repository.findAll();
		List<Product> prodList = new ArrayList<Product>();
		
		for(Product p: products) {
			prodList.add(p);
		}
		
		return prodList;
	}
	
	public Product getById(int prodId) {
		Product prod = null;
		Optional<Product> opt = repository.findById(prodId);
		if(opt.isPresent()) {
			prod = opt.get();
		}
		return prod;
	}
	
	/*public List<Product> findAllByCategoryCategoryId(int catId){
		return repository.findAllByCategoryCategoryId(catId);
	}*/
	
	public List<Product> findAllByBrand(String brand){
		return repository.findAllByBrand(brand);
	}
	
	

	
	public Product addProduct(Product p) {
		if(p == null) {
			throw new NullPointerException("Product object is null in class - ProdutService and method: addProduct");
		}
		return repository.save(p);
	}
	
	public Product updateProduct(Product p) {
		if(p == null) {
			throw new NullPointerException("Product object is null in class - ProdutService and method: updateProduct");
		}
		
		Product product = null;
		Optional<Product> opt = repository.findById(p.getProdId());
		if(opt.isPresent()) {
			product = opt.get();
		}
		else {
			throw new ResourceNotFoundException("Product", "ProductId", p.getProdId());
		}
		return repository.save(p);
	}
	
	public void deleteProduct(int prodId) {
		
		
		Optional<Product> opt = repository.findById(prodId);
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException("Product", "ProductId", prodId);
		}
		repository.deleteById(prodId);
	}

}
