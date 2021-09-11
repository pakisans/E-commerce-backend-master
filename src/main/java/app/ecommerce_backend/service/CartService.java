package app.ecommerce_backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.ecommerce_backend.model.Cart;
import app.ecommerce_backend.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
//	public Iterable<Cart> getCart(){
//		return cartRepo.findAll();
//	}
	
	public Optional<Cart> getCartById(Long id){
		return cartRepo.findById(id);
	}
	
	public void addCart(Cart cart) {
		cartRepo.save(cart);
	}
	
	public void removeCart(Long id) {
		Optional<Cart> ca = cartRepo.findById(id);
		if(ca.isPresent()) {
			ca.get().setDeleted(true);
			cartRepo.save(ca.get());
		}
	}
//	public void updateCart(Long id,Cart cart) {
//		Optional<Cart> ca = cartRepo.findById(id);
//		if(ca.isPresent()) {
//			cart.setId(ca.get().getId());
//			cartRepo.save(cart);
//		}
//	}
	

}
