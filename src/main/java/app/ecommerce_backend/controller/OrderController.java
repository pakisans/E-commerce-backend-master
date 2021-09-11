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

import app.ecommerce_backend.model.Order;
import app.ecommerce_backend.model.dto.OrderDTO;
import app.ecommerce_backend.model.dtoAdapters.OrderDTOAdapter;
import app.ecommerce_backend.service.OrderService;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping()
	public ResponseEntity<Iterable<OrderDTO>> getOrders(){
		return new ResponseEntity<Iterable<OrderDTO>>(OrderDTOAdapter.convertToDTOs(orderService.getOrders()),HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
		
        Optional<Order> order= orderService.getOrderById(id);
        if(order.isPresent()) {
            return new ResponseEntity<OrderDTO>(OrderDTOAdapter.convertToDTO(order.get()), HttpStatus.OK);
        }
        return new ResponseEntity<OrderDTO>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) {
		orderService.addOrder(order);
        return new ResponseEntity<OrderDTO>(OrderDTOAdapter.convertToDTO(order), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<OrderDTO> removeOrder(@PathVariable Long id) {
        try {
        	orderService.removeOrder(id);
        }catch (Exception e) {
            return new ResponseEntity<OrderDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<OrderDTO>(HttpStatus.NO_CONTENT);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody Order order) {
		orderService.updateOrder(id, order);
        return new ResponseEntity<OrderDTO>(OrderDTOAdapter.convertToDTO(order), HttpStatus.CREATED);
    }

}
