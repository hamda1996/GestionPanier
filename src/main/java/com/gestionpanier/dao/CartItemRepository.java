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
	public  CartItem findByUserId(long user_id);
}
