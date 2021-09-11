package app.ecommerce_backend.model.dtoAdapters;

import java.util.ArrayList;

import app.ecommerce_backend.model.CartItem;
import app.ecommerce_backend.model.dto.CartItemDTO;


public class CartItemDTOAdapter {
	
	public static CartItemDTO convertToDTO(CartItem cartItem) {
		CartItemDTO dto = new CartItemDTO();
		dto.setId(cartItem.getId());
		dto.setQuantity(cartItem.getQuantity());
		dto.setProductDTO(ProductDTOAdapter.convertToDTO(cartItem.getProduct()));
		dto.setCartDTO(CartDTOAdapter.convertToDTO(cartItem.getCart()));
		
		
		return dto;
		
	}
	
	public static CartItem convertFromDTO(CartItemDTO dto) {
		CartItem cartItem = new CartItem();
		cartItem.setId(dto.getId());
		cartItem.setQuantity(dto.getQuantity());
		cartItem.setProduct(ProductDTOAdapter.convertFromDTO(dto.getProductDTO()));
		cartItem.setCart(CartDTOAdapter.convertFromDTO(dto.getCartDTO()));
		
		return cartItem;
		
	}
	
	public static ArrayList<CartItem> convertFromDTOs(ArrayList<CartItemDTO> dtos){
		ArrayList<CartItem> result = new ArrayList<CartItem>();
		
		for(CartItemDTO dto:dtos) {
			result.add(CartItemDTOAdapter.convertFromDTO(dto));
		}
		return result;
	}
	
	public static Iterable<CartItemDTO> convertToDTOs(Iterable<CartItem> cartItems){
		ArrayList<CartItemDTO> result = new ArrayList<CartItemDTO>();
		
		for(CartItem cartItem:cartItems) {
			result.add(CartItemDTOAdapter.convertToDTO(cartItem));
		}
		return result;
	}

}
