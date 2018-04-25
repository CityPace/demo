package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import db.JdbcUtil;
import db.test;
import entity.Student;

public class StudentDao {
		
	//增
	public boolean addStudent(Student s)
	{
		Connection conn = test.getConn("demo");
		String sql = "insert into Student(ID,name,age)" + "values(?,?,?)";
		try{
			//预编译执行
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s.getID());
			psmt.setString(2, s.getName());
			psmt.setInt(3, s.getAge());
			
			psmt.executeUpdate();//执行sql
			conn.close();
		}catch(SQLException e){
		}
		return true;
	}
	//删
	public boolean deleteStudent(Student s)
	{
		Connection conn = test.getConn("demo");
		String sql = "delete from Student where ID=?";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s.getID());
			psmt.executeUpdate();
			conn.close();
		}catch(SQLException e){
			
		}
		return true;
	}
	//改
	public boolean updateStudent(Student s)
	{
		Connection conn = test.getConn("demo");
		String sql = "update Student set name = ?,age=? where ID=?";
		try{
		    PreparedStatement psmt = conn.prepareStatement(sql);
		    psmt.setInt(3, s.getID());
		    psmt.setString(1, s.getName());
		    psmt.setInt(2 , s.getAge());
		    psmt.executeUpdate();
		    conn.close();
		}catch(SQLException e){		
		}
		return true;
	}
	//查
	public List<Student> queryAll()
	{
		Connection conn = test.getConn("demo");
		List<Student> list = new ArrayList<Student>();
		String sql = "select*from Student";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet re = psmt.executeQuery(sql);
			while(re.next()){
			Student s = new Student(re.getInt(1),re.getString(2),re.getInt(3));
			list.add(s);
			}
			return list;
		}catch(SQLException e){
		}
		return null;
	}
}
