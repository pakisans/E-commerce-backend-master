package app.ecommerce_backend.model.dtoAdapters;

import java.util.ArrayList;

import app.ecommerce_backend.model.Category;
import app.ecommerce_backend.model.dto.CategoryDTO;

public class CategoryDTOAdapter {
	
	public static CategoryDTO convertToDTO(Category category) {
		
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		
		return dto;
		
	}
	
	
	public static Category convertFromDTO(CategoryDTO dto) {
		
		Category category = new Category();
		category.setId(dto.getId());
		category.setName(dto.getName());
		
		return category;
		
	}
	
	public static ArrayList<Category> convertFromDTOs(ArrayList<CategoryDTO> dtos) {
		ArrayList<Category> result = new ArrayList<Category>();
		
		for(CategoryDTO dto:dtos) {
			result.add(CategoryDTOAdapter.convertFromDTO(dto));
		}
		
		return result;
	}
	
	public static Iterable<CategoryDTO> convertToDTOs(Iterable<Category> categories){
		ArrayList<CategoryDTO> result = new ArrayList<CategoryDTO>();
		
		for(Category category:categories) {
			result.add(CategoryDTOAdapter.convertToDTO(category));
		}
		return result;
	}
}
