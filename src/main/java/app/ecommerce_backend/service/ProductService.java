package app.ecommerce_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce_backend.model.Product;
import app.ecommerce_backend.model.dto.ProductDTO;
import app.ecommerce_backend.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id){
		Optional<Product> opt = productRepo.findById(id);
		if(opt.isPresent()) {
			return productRepo.findById(id).get();
		}
		return null;
	}
	
	public Product addProduct(ProductDTO productDto) {
//		Product newProduct = ProductDTOAdapter.convertFromDTO(productDto);
		Product newProduct = new Product();
		newProduct.setDescription(productDto.getDescription());
		newProduct.setImage(productDto.getImage());
		newProduct.setName(productDto.getName());
		newProduct.setPrice(productDto.getPrice());
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
