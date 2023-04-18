package com.shopNestApp.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;
	
	public Cart()
	{
		items=new ArrayList<>();
	}
	
	public void addItem(Product product)
	{
		items.add(product);
	}
	public List<Product> getItems()
	{
		return items;
	}
	public double getTotal()
	{
		double total=0.0;
		for(Product product:items)
			total+=product.getPprice();
		return total;
	}
}
