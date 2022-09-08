package demos.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import demos.springboot.model.Product;
import demos.springboot.repository.ProductRepository;

@SpringBootApplication
public class ProductmanagementApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Category c1 = new Category(0, "Electronics", "All Electronic Products");
		Category c2 = new Category(0, "Furniture", "All Furniture Products");
		categoryRepository.save(c1);
		categoryRepository.save(c2);*/
		
		Product p1 = new Product(0, "Washing Machine", "Samsung", 40000.0);
		Product p2 = new Product(0, "Inverter AC", "Samsung", 50000.0);
		productRepository.save(p1);
		productRepository.save(p2);
		
		/*(User user = new User(0, "Admin", "admin@hcl.com", "123456");
		userRepository.save(user);*/
		
	}

}
