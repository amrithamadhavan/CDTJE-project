package com.amritha.shoppingcart.dao;
import com.amritha.shoppingcart.model.User;
public interface UserDao {
	
User saveUser(User user);
void saveUserwithaddress(User user);
User getuserbyid(int id);
User getuserbyname(String uname);
}
