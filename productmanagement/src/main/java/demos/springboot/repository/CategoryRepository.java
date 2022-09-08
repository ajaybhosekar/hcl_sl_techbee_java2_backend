package demos.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demos.springboot.model.Category;
import demos.springboot.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
