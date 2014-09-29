package com.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.test.bean.Person;

public class PersonDBTest {

	private static PersonDB personDB = null;
	
	@BeforeClass
	public static void init(){
		personDB = new PersonDB();
	}
	@Test
	public void testInsert(){
		
		Person person = new Person();
		person.setUsername("lisi");
		person.setPassword("654321");
		person.setAge(11);
		personDB.insert(person);
		Person person2 = this.getByMaxId();
		Assert.assertEquals(person.getUsername(), person2.getUsername());
		Assert.assertEquals(person.getPassword(), person2.getPassword());
		Assert.assertEquals(person.getAge(), person2.getAge());
	}
	
	private Person getByMaxId(){
		Connection conn = null;
		Person person = null;
		try{
			conn = Conn.getConnection();
			String sql = "select max(id) as maxId from person";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int maxId = 0;
			if(rs.next()){
				maxId = rs.getInt("maxId"); 
			}
			String sql2 = "select * from person where id = " + maxId;
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()){
				person = new Person();
				person.setAge(rs.getInt("age"));
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return person;
	}
}
