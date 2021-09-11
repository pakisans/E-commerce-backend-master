package app.ecommerce_backend.model.dtoAdapters;

import app.ecommerce_backend.model.Product;
import app.ecommerce_backend.model.dto.ProductDTO;


import java.util.ArrayList;

public class ProductDTOAdapter {
	
	public static  ProductDTO convertToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setDescription(product.getDescription());
		dto.setImage(product.getImage());
		
		
		
		
		return dto;
		
	}
	
	public static Product convertFromDTO(ProductDTO dto) {
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());
		product.setImage(dto.getImage());
		
		return product;
	}
	
	public static ArrayList<Product> convertFromDTOs(ArrayList<ProductDTO> dtos){
		ArrayList<Product> result = new ArrayList<Product>();
		
		for(ProductDTO dto:dtos) {
			result.add(ProductDTOAdapter.convertFromDTO(dto));
			
		}
		
		return result;
		
	}
	
	public static Iterable<ProductDTO> convertToDTOs(Iterable<Product> products){
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		
		for(Product product:products) {
			result.add(ProductDTOAdapter.convertToDTO(product));
		}
		return result;
	}

}
