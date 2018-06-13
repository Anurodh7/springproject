package com.boa.studentproject.daos;

import com.boa.studentproject.models.User;

public interface UserDao {
	public void signup( User u);
	public boolean login(String un, String psw);


}
