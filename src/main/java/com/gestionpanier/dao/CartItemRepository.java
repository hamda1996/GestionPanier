package com.gestionpanier.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestionlivres.entities.Books;
import com.gestionpanier.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	

}
