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

import com.gestionlivres.entities.Books;
import com.gestionpanier.entities.CartItem;
import com.gestionpanier.services.CartServices;

@RestController
public class CartItemController {

	@Autowired
	private CartServices cartServices;
	
	@GetMapping("/panier/users/{user_id}")
	public CartItem GetCartByUser(@PathVariable long user_id) {
		return cartServices.GetCartByUser(user_id);
	}
	@GetMapping("/panier/users/{user_id}/quantite")
	public int GetQuantiteByUser(@PathVariable long user_id) {
		CartItem cartItem = cartServices.GetCartByUser(user_id);
		return cartItem != null ? cartItem.getQuantity() : 0;
		}
	
	
	@PostMapping("/panier/add")
	public CartItem AddItem(@RequestBody CartItem item) {
		return cartServices.AddItem(item);
	}
	
	@PutMapping("/panier")
	public CartItem UpdateItem(@RequestBody CartItem item) {
		return cartServices.UpdateItem(item);
	}
	
	@DeleteMapping("/panier/delete/{id}")
	public String deleteCartITem(@PathVariable long id) {
		return cartServices.deleteCartITem(id);
	}
	@GetMapping("/nombre")
	public String getlivres(long id) {
		return cartServices.getLivres(id);
		
		
	}
}

