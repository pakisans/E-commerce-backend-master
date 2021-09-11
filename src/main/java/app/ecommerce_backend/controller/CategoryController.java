package app.ecommerce_backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.ecommerce_backend.model.Category;
import app.ecommerce_backend.model.dto.CategoryDTO;
import app.ecommerce_backend.model.dtoAdapters.CategoryDTOAdapter;
import app.ecommerce_backend.service.CategoryService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Iterable<CategoryDTO>> getCategories(){
		return new ResponseEntity<Iterable<CategoryDTO>>(CategoryDTOAdapter.convertToDTOs(categoryService.getCategories()),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Optional<Category> category= categoryService.getCategoryById(id);
        if(category.isPresent()) {
            return new ResponseEntity<CategoryDTO>(CategoryDTOAdapter.convertToDTO(category.get()), HttpStatus.OK);
        }
        return new ResponseEntity<CategoryDTO>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody Category category) {
    	categoryService.addCategory(category);
        return new ResponseEntity<CategoryDTO>(CategoryDTOAdapter.convertToDTO(category), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<CategoryDTO> removeCategory(@PathVariable Long id) {
        try {
        	categoryService.removeCategory(id);
        }catch (Exception e) {
            return new ResponseEntity<CategoryDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
    }
	

}
