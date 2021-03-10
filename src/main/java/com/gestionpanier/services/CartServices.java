package com.gestionpanier.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gestionpanier.dao.CartItemRepository;
import com.gestionpanier.entities.CartItem;


@Service
public class CartServices {
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	public List<CartItem> GetCartByUser(long user_id) {
		return cartItemRepo.findByUserId(user_id);
	}
	
	public String getLivres()
	{
	    final String uri = "http://localhost:9091/livres/1";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
	    return result;
	}
	
	public CartItem AddItem(CartItem item) {
		return cartItemRepo.save(item);
	}
	
	public String deleteCartITem(long id) {
		cartItemRepo.deleteById(id);
		return "supprimé";
	}
	
	public CartItem UpdateItem(CartItem item) {
		return cartItemRepo.save(item);
	}
} 
