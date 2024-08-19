package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {
    
	public void save(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("insert into user (name,age,mobile,email,password) values (?,?,?,?,?)");
			
			pst.setString(1,user.getName());
			pst.setInt(2, user.getAge());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPassword());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public int login(String email, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=?");
			
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()) {
				return rst.getInt("id");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public User fetchById(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("select * from user where id=?");
			
			pst.setInt(1, id);
			
			ResultSet rst = pst.executeQuery();
			
			
			if(rst.next()) {
				int id1 = rst.getInt("id");
				String name = rst.getString("name");
				int age = rst.getInt("age");
			    Long mobile = rst.getLong("mobile");
			    String email = rst.getString("email");
			    String password = rst.getString("password");
			    
			    User user = new User();
			    user.setName(name);
			    user.setId(id1);
			    user.setAge(age);
			    user.setMobile(mobile);
			    user.setEmail(email);
			    user.setPassword(password);
			    
			    return user;
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> fetchAll(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("select * from user");
			
			ResultSet rst = pst.executeQuery();
			
			List<User> list = new ArrayList<>();
			
			
			while(rst.next()) {
				int id1 = rst.getInt("id");
				String name = rst.getString("name");
				int age = rst.getInt("age");
			    Long mobile = rst.getLong("mobile");
			    String email = rst.getString("email");
			    String password = rst.getString("password");
			    
			    User user = new User();
			    user.setName(name);
			    user.setId(id1);
			    user.setAge(age);
			    user.setMobile(mobile);
			    user.setEmail(email);
			    user.setPassword(password);
			    
			    list.add(user);
			}
			
			return list;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateUserById(int id, User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("update user set name=?, age=?, mobile=?, email=? where id=?");
			
			pst.setString(1,user.getName());
			pst.setInt(2, user.getAge());
			pst.setLong(3, user.getMobile());
			pst.setString(4, user.getEmail());
			
			pst.setInt(5, id);
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteById(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","Rama@5517");
			
			PreparedStatement pst = con.prepareStatement("delete from user where id=?");
			
			pst.setInt(1, id);
			
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
