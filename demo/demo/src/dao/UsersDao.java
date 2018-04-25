package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.test;
import entity.Student;
import entity.Users;

public class UsersDao {
	//增
	public boolean addUsers(Users u)
	{
		Connection conn = test.getConn("demo");
		String sql = "insert into Users(username,password) value(?,?)";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, u.getUsername());
			psmt.setString(2, u.getPassword());
			psmt.executeUpdate();
			psmt.close();
		}catch(Exception e){}
		return true;
	}
	public List<Users> queryAll()
	{
		Connection conn = test.getConn("demo");
		List<Users> list = new ArrayList<Users>();
		String sql = "select*from Users";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet re = psmt.executeQuery(sql);
			while(re.next()){
			Users s = new Users(re.getString(1),re.getString(2));
			list.add(s);
			}
			return list;
		}catch(SQLException e){
		}
		return null;
	}

}
