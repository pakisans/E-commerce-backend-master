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

import app.ecommerce_backend.model.Cart;
import app.ecommerce_backend.model.dto.CartDTO;
import app.ecommerce_backend.model.dtoAdapters.CartDTOAdapter;
import app.ecommerce_backend.service.CartService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
		
        Optional<Cart> cart = cartService.getCartById(id);
        if(cart.isPresent()) {
            return new ResponseEntity<CartDTO>(CartDTOAdapter.convertToDTO(cart.get()), HttpStatus.OK);
        }
        return new ResponseEntity<CartDTO>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<CartDTO> addCart(@RequestBody Cart cart) {
    	cartService.addCart(cart);
        return new ResponseEntity<CartDTO>(CartDTOAdapter.convertToDTO(cart), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<CartDTO> removeCart(@PathVariable Long id) {
        try {
        	cartService.removeCart(id);
        }catch (Exception e) {
            return new ResponseEntity<CartDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CartDTO>(HttpStatus.NO_CONTENT);
    }
	
	
	
	

}
