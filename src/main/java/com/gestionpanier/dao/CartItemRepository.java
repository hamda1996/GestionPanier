package com.gestionpanier.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionpanier.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	public boolean existsById(long id);
	
	@Query("SELECT * FROM cart_item WHERE cart_item.user_id=user_id")
	public  List<CartItem> findByUserId(long user_id);
	
	@Query("SELECT * FROM cart_item WHERE cart_item.user_id=user_id and cart_item.product_id=product_id")
	public  CartItem findByUserIdAndProductId(long user_id,long product_id);
	
	@Query("SELECT * FROM cart_item WHERE cart_item.user_id=user_id")
	public  CartItem findQuantityByUserId(long user_id);
}
