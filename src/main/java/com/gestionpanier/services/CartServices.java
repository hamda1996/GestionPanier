package com.gestionpanier.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestionlivres.entities.Books;
import com.gestionpanier.dao.CartItemRepository;
import com.gestionpanier.entities.CartItem;


@Service
public class CartServices {
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	public List<CartItem>GetCartByUser(long user_id) {
		return cartItemRepo.findAll();
	}
	
	public CartItem AddItem(CartItem item) {
		// String uriToCall = "http://localhost:9091/livre?bookId=1&stockToRemove=3";
		String BASE_URL = "http://localhost:9091";
		 RestTemplate restTemplate = new RestTemplate();
		 System.out.print("passage 1");
		 URI targetUrl= UriComponentsBuilder.fromUriString(BASE_URL)  // Build the base link
				    .path("/livre")                                          // Add path
				    .queryParam("bookId", 1)  
				    .queryParam("stockToRemove", 3)                                // Add one or more query params
				    .build()                                                 // Build the URL
				    .encode()                                                // Encode any URI items that need to be encoded
				    .toUri(); 
		 boolean result = restTemplate.getForObject(targetUrl, boolean.class);
		 System.out.print(result);
		 System.out.print("passage 2");
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
