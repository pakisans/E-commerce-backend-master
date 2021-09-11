package app.ecommerce_backend.model.dtoAdapters;

import app.ecommerce_backend.model.User;
import app.ecommerce_backend.model.dto.UserDTO;
import java.util.ArrayList;


public class UserDTOAdapter {
	
	public static UserDTO convertToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setRole(user.getRole());
		
		return dto;
	}
	
	public static User convertFromDTO(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setRole(dto.getRole());
		
		return user;
		
	}
	
	public static ArrayList<User> convertFromDTOs(ArrayList<UserDTO> dtos){
		ArrayList<User> result = new ArrayList<User>();
		
		for(UserDTO dto:dtos) {
			result.add(UserDTOAdapter.convertFromDTO(dto));
		}
		return result;
	}
	
	public static Iterable<UserDTO> convertToDTOs(Iterable<User> users){
		ArrayList<UserDTO> result = new ArrayList<UserDTO>();
		
		for(User user:users) {
			result.add(UserDTOAdapter.convertToDTO(user));
		}
		return result;
	}
}
