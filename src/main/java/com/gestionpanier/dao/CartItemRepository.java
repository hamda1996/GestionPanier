package com.gestionpanier.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestionlivres.entities.Books;
import com.gestionpanier.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	@Query("SELECT * FROM cart_item WHERE cart_item.user_id=user_id")
	public  List<CartItem> findByUserId(long user_id);
}
