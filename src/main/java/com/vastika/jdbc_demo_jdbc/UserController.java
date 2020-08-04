package com.vastika.jdbc_demo_jdbc;

import java.util.Scanner;

import com.vastika.jdbc_demo_jdbc.dao.UserDao;
import com.vastika.jdbc_demo_jdbc.dao.UserDaoImpl;
import com.vastika.jdbc_demo_jdbc.model.User;

/**
 * Hello world!
 *
 */
public class UserController {
    public static void main( String[] args )
    {
        UserDao userDao = new UserDaoImpl();
        Scanner reader = new Scanner (System.in);
        User user = new User();
        System.out.println("enter username");
        String username = reader.next();
        System.out.println("enter password");
        String password = reader.next();
        System.out.println("enter mobile no");
        Long mobileNo = reader.nextLong();
        System.out.println("enter address");
        String address = reader.next();
        
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setMobileNo(mobileNo);
        int saved = userDao.saveUserInfo(user);
        if (saved>=1) {
        	System.out.println("User info is saved successfully!!!");
        }else {
        	System.out.println("Error in db.");
        }
        
    }
}
