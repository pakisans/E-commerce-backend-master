package app.ecommerce_backend.model.dtoAdapters;

import app.ecommerce_backend.model.Cart;
import app.ecommerce_backend.model.dto.CartDTO;

import java.util.ArrayList;

public class CartDTOAdapter {
	
	public static CartDTO convertToDTO(Cart cart) {
		CartDTO dto = new CartDTO();
//		dto.setId(cart.getId());
//		dto.setUserDTO(UserDTOAdapter.convertToDTO(cart.getUser()));
		
		return dto;
		
	}
	
	public static Cart convertFromDTO(CartDTO dto) {
		Cart cart = new Cart();
//		cart.setId(dto.getId());
//		cart.setUser(UserDTOAdapter.convertFromDTO(dto.getUserDTO()));
		
		return cart;
		
	}
	
	public static ArrayList<Cart> convertFromDTOs(ArrayList<CartDTO> dtos){
		ArrayList<Cart> result = new ArrayList<Cart>();
		
		for(CartDTO dto:dtos) {
			result.add(CartDTOAdapter.convertFromDTO(dto));
			
		}
		return result;
	}
	

}
