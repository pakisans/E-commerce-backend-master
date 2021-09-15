package app.ecommerce_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce_backend.model.Product;
import app.ecommerce_backend.model.dto.ProductDTO;
import app.ecommerce_backend.repository.CategoryRepository;
import app.ecommerce_backend.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	
	public List<Product> getProducts(){
		List<Product> allProducts = productRepo.findAll();
		List<Product> products = new ArrayList<Product>();
		for(Product p: allProducts) {
			if(!p.isDeleted()) {
				products.add(p);
			}
		}
		return products;
	}
	
	public Product getProductById(Long id){
		Optional<Product> opt = productRepo.findById(id);
		if(opt.isPresent()) {
			return productRepo.findById(id).get();
		}
		return null;
	}
	
	public Product addProduct(ProductDTO productDto) {
		Product newProduct = new Product();
		newProduct.setDescription(productDto.getDescription());
		newProduct.setImage(productDto.getImage());
		newProduct.setName(productDto.getName());
		newProduct.setPrice(productDto.getPrice());
		newProduct.setCategory(categoryRepo.findById(productDto.getCategoryId()).get());
		return productRepo.save(newProduct);
	}
	
	public Product removeProduct(Long id) {
		Product pr = productRepo.findById(id).get();
		if(pr != null) {
			pr.setDeleted(true);
			return productRepo.save(pr);
		}
		return null;
	}
	
	public Product updateProduct(Long id,ProductDTO productDto) {
		Product pr = productRepo.findById(id).get();
		if(pr != null) {
			pr.setName(productDto.getName());
			pr.setPrice(productDto.getPrice());
			pr.setDescription(productDto.getDescription());
			pr.setImage(productDto.getImage());
			return productRepo.save(pr);
		}
		return null;
	}

}
