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
	
	public CartItem GetCartByUser(long user_id) {
		return cartItemRepo.findByUserId(user_id);
	}
	
	public String getLivres(long id)
	{
	    final String uri = "http://localhost:9091/livres/"+id;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result;
	}
	public int getStockLivre(long id)
	{
	    final String uri = "http://localhost:9091/livres/"+id+"/stock";
	    RestTemplate restTemplate = new RestTemplate();
	    int result = restTemplate.getForObject(uri, int.class);
	    return result;
	}
	public int getPrixLivre(long id)
	{
	    final String uri = "http://localhost:9091/livres/"+id+"/prix";
	    RestTemplate restTemplate = new RestTemplate();
	    int result = restTemplate.getForObject(uri, int.class);
	    return result;
	}
	public CartItem AddItem(CartItem item) {
		if (getStockLivre(item.getProduct_id())>0 ) {
			if (cartItemRepo.existsById(item.getId())) {
				item.setPrixtotal(item.getPrixtotal()+getPrixLivre(item.getProduct_id()));
				item.setQuantity(item.getQuantity()+1);			
			}else {
				item.setPrixtotal(getPrixLivre(item.getProduct_id()));
				item.setQuantity(1);			

			}
			//int stockValue=getStockLivre(item.getProduct_id())-1;
			
		} 
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
