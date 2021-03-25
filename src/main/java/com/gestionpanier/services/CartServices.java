package com.gestionpanier.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gestionlivres.entities.Books;
import com.gestionlivres.entities.StockDto;
import com.gestionpanier.dao.CartItemRepository;
import com.gestionpanier.entities.CartItem;


@Service
public class CartServices {
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	public List<CartItem> getCartByUser(long user_id) {
		return cartItemRepo.findByUserId(user_id);
	}
	
	public CartItem getQuantityByUser(long user_id) {
		return cartItemRepo.findQuantityByUserId(user_id);
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
	
	private void manageLivreStock(StockDto stockDto) {
		final String uri = "http://localhost:9091/stock/livre";
	    RestTemplate restTemplate = new RestTemplate();
	    Object result = restTemplate.postForObject(uri, stockDto, Object.class); 
	}
	
	public List<CartItem> AddItem(@NonNull final CartItem basketItem) {
		boolean isAlReadyExists = cartItemRepo.
				findByUserIdAndProductId(basketItem.getUser_id(), basketItem.getProduct_id()) != null;
		List<CartItem> basket = new ArrayList<CartItem>();
		basket.addAll(cartItemRepo.findByUserId(basketItem.getUser_id()));
		if(!basket.isEmpty()) {
			basket.stream().forEach(it -> 
				{if(it.getProduct_id() == basketItem.getProduct_id()) {
					it.setQuantity(it.getQuantity() + basketItem.getQuantity());
					it.setPrixtotal(it.getQuantity() * getPrixLivre(it.getProduct_id()));
					cartItemRepo.save(it);
				} 
				});
		}
		if(!isAlReadyExists) {
			basket.add(basketItem);
			basketItem.setPrixtotal(basketItem.getQuantity() * getPrixLivre(basketItem.getProduct_id()));
			cartItemRepo.save(basketItem);
		}
		StockDto dto = new StockDto();
		dto.setProductId(basketItem.getProduct_id());
		dto.setQuantityToReduce(basketItem.getQuantity());
		manageLivreStock(dto);
		
		return basket;
	}
	
	public String deleteCartITem(long id) {
		cartItemRepo.deleteById(id);
		return "supprimé";
	}
	
	public CartItem UpdateItem(CartItem item) {
		return cartItemRepo.save(item);
	}
} 
