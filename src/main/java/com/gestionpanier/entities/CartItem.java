package com.gestionpanier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int quantity;
	private float prixtotal;
	@Column(name = "product_id")
	private long productId;
	@Column(name = "user_id")
	private long userId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrixtotal() {
		return prixtotal;
	}
	public void setPrixtotal(float prixtotal) {
		this.prixtotal = prixtotal;
	}
	public long getProduct_id() {
		return productId;
	}
	public void setProduct_id(long product_id) {
		this.productId = product_id;
	}
	public long getUser_id() {
		return userId;
	}
	public void setUser_id(long user_id) {
		this.userId = user_id;
	}
	public CartItem(long id, int quantity, float prixtotal, long product_id, long user_id) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.prixtotal = prixtotal;
		this.productId = product_id;
		this.userId = user_id;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", quantity=" + quantity + ", prixtotal=" + prixtotal + ", product_id="
				+ productId + ", user_id=" + userId + "]";
	}
	

}
