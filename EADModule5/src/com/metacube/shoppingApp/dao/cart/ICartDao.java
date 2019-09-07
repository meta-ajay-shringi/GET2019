package com.metacube.shoppingApp.dao.cart;
import com.metacube.shoppingApp.dao.BaseDao;
import com.metacube.shoppingApp.model.CartItem;

public interface ICartDao extends BaseDao<CartItem> {
	
	
      public CartItem getCartByOrderIdandProductCode();
     
}
