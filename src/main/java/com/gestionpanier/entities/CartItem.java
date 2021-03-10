package com.gestionpanier.entities;

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
	private long product_id;
	private long user_id;
	
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
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public CartItem(long id, int quantity, float prixtotal, long product_id, long user_id) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.prixtotal = prixtotal;
		this.product_id = product_id;
		this.user_id = user_id;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", quantity=" + quantity + ", prixtotal=" + prixtotal + ", product_id="
				+ product_id + ", user_id=" + user_id + "]";
	}
	
	
	

}
