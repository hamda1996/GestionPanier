package com.gestionpanier.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestionpanier.entities.CartItem;
import com.gestionpanier.services.CartServices;

@RestController
public class CartItemController {

	@Autowired
	private CartServices cartServices;
	
	@GetMapping("/cart/{user_id}")
	public List<CartItem>GetCartByUser(@PathVariable long user_id) {
		return cartServices.GetCartByUser(user_id);
	}
	
	@PostMapping("/cart")
	public CartItem AddItem(@RequestBody CartItem item) {
		return cartServices.AddItem(item);
	}
	
	@PutMapping("/cart")
	public CartItem UpdateItem(@RequestBody CartItem item) {
		return cartServices.UpdateItem(item);
	}
	
	@DeleteMapping("/cart/{id}")
	public String deleteCartITem(@PathVariable long id) {
		return cartServices.deleteCartITem(id);
	}
	
	
}

