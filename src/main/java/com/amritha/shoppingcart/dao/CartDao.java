package com.amritha.shoppingcart.dao;

import java.util.List;

import com.amritha.shoppingcart.model.Cart;
import com.amritha.shoppingcart.model.CartItems;

public interface CartDao {
	List<CartItems> listcartitems(int id);

	Cart saveintocart(Cart cart);

	void saveorupdatecart(Cart cart);

	Cart getcartbyuserid(int uid);

	
}
