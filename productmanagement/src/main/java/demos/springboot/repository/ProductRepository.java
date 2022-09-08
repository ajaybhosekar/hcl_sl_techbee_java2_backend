package demos.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import demos.springboot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	//public List<Product> findAllByCategoryCategoryId(int catId);
	
	public Product findByProdName(String name);
	
	public List<Product> findAllByBrand(String brand);
	
	

}
