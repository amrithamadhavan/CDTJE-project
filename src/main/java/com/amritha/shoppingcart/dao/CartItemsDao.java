package com.amritha.shoppingcart.dao;

import com.amritha.shoppingcart.model.CartItems;

public interface CartItemsDao {
        void savecartitems(CartItems cartitems);

		CartItems getcartitembyproductid(int id);
}
