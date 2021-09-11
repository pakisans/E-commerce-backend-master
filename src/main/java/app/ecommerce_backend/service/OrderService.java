package app.ecommerce_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.ecommerce_backend.model.Order;
import app.ecommerce_backend.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	
	
	public Iterable<Order> getOrders(){
		return orderRepo.findAll();
	}
	
	public Optional<Order> getOrderById(Long id){
		return orderRepo.findById(id);
	}
	
	public void addOrder(Order order) {
		orderRepo.save(order);
	}
	
	public void removeOrder(Long id) {
		Optional<Order> or = orderRepo.findById(id);
		if(or.isPresent()) {
			or.get().setDeleted(true);
			orderRepo.save(or.get());
		}
	}
	
	public void updateOrder(Long id,Order order) {
		Optional<Order> or = orderRepo.findById(id);
		if(or.isPresent()) {
			or.get().setPrice(order.getPrice());
			or.get().setUser(order.getUser());
			orderRepo.save(or.get());
		}
	}

}
