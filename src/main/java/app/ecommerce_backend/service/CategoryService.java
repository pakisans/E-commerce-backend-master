package app.ecommerce_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce_backend.model.Category;
import app.ecommerce_backend.model.Product;
import app.ecommerce_backend.model.dto.CategoryDTO;
import app.ecommerce_backend.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getCategories(){
		return categoryRepo.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id){
		return categoryRepo.findById(id);
	}
	
	public Category addCategory(CategoryDTO categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setProducts(new ArrayList<Product>());
		return categoryRepo.save(category);
	}
	
	public void removeCategory(Long id) {
		Optional<Category> ca = categoryRepo.findById(id);
		if(ca.isPresent()) {
			ca.get().setDeleted(true);
			categoryRepo.save(ca.get());
			
		}
	}
	
	

}
