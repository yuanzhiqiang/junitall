package com.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.bean.Person;

public class PersonDB {

	
	
	public void insert(Person person){
		Connection conn = null;
		try{
			conn = Conn.getConnection();
			
			String sql = "insert into person(username,password,age) values (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, person.getUsername());
			ps.setString(2, person.getPassword());
			ps.setInt(3, person.getAge());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null != conn){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
