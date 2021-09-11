package app.ecommerce_backend.model.dtoAdapters;

import app.ecommerce_backend.model.Order;
import app.ecommerce_backend.model.dto.OrderDTO;

import java.util.ArrayList;

public class OrderDTOAdapter {
	
	public static OrderDTO convertToDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setId(order.getId());
		dto.setPrice(order.getPrice());
		dto.setUserDTO(UserDTOAdapter.convertToDTO(order.getUser()));
		return dto;
		
	}
	
	public static Order convertFromDTO(OrderDTO dto) {
		Order order = new Order();
		order.setId(dto.getId());
		order.setPrice(dto.getPrice());
		order.setUser(UserDTOAdapter.convertFromDTO(dto.getUserDTO()));
		
		return order;
	}
	
	public static ArrayList<Order> convertFromDTOs(ArrayList<OrderDTO> dtos){
		ArrayList<Order> result = new ArrayList<Order>();
		
		for(OrderDTO dto:dtos) {
			result.add(OrderDTOAdapter.convertFromDTO(dto));
		}
		return result;
	}
	
	public static Iterable<OrderDTO> convertToDTOs(Iterable<Order> orders){
		ArrayList<OrderDTO> result = new ArrayList<OrderDTO>();
		
		for(Order order:orders) {
			result.add(OrderDTOAdapter.convertToDTO(order));
		}
		return result;
	}

}
