package db;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import dao.UsersDao;
import entity.Student;
import entity.Users;

public class Main {
	public static void main(String args[])
	{
		//Student s = new Student(3,"���",21);
//				StudentDao dao = new StudentDao();
//				List<Student> list = new ArrayList<Student>();
//				list=dao.queryAll();
////				if(dao.updateStudent(s)){
//				for(Student s:list)
//					System.out.print(s.getID()+s.getName()+s.getAge());
//				}
				/*
				try{
				Connection conn = test.getConn("demo");
				
				String sql="insert into Student(ID,name,age) values(04,'��֮��',22)";        
				             Statement stmt=conn.createStatement();//����һ��Statement����
				             stmt.executeUpdate(sql);//ִ��sql���
				             System.out.println("���뵽���ݿ�ɹ�");
				             conn.close();
				             System.out.println("�ر����ݿ�ɹ�");
				         } catch (SQLException e) {
				             // TODO Auto-generated catch block
				             e.printStackTrace();
				         }
				*/
				List<Users> list = new ArrayList<Users>();
				UsersDao dao =new UsersDao();
				list = dao.queryAll();
				boolean bool = false;
				for(Users s : list)
				{
					System.out.print(s.getUsername()+s.getPassword());
				}
	}

}
