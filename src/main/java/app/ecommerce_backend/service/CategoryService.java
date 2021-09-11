package app.ecommerce_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce_backend.model.Category;
import app.ecommerce_backend.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public Iterable<Category> getCategories(){
		return categoryRepo.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id){
		return categoryRepo.findById(id);
	}
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public void removeCategory(Long id) {
		Optional<Category> ca = categoryRepo.findById(id);
		if(ca.isPresent()) {
			ca.get().setDeleted(true);
			categoryRepo.save(ca.get());
			
		}
	}
	
	

}
