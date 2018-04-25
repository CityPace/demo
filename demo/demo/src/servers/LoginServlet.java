package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import db.test;
import entity.Users;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;cgarset=utf-8");
        request.setCharacterEncoding("utf-8");
		//Connection conn = test.getConn("demo");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String randomCode = request.getParameter("randomCode");
		List<Users>list = new ArrayList<Users>();
		UsersDao dao = new UsersDao();
		list = dao.queryAll();
		//验证码验证
		String randomCodeInSession = (String)request.getSession().getAttribute("RANDOMCODE_IN_SeSSION");
		if(!randomCodeInSession.equals(randomCode))
		{
			request.getSession().setAttribute("errorMsg", "验证码错误");
			response.sendRedirect("/demo/Login.jsp");
		}
		//
		boolean bool=true;
		if(name==null)
			response.sendRedirect("/demo/Login.jsp");
		try{
		for(Users users : list)
		{
			if(name.equals(users.getUsername())&&pass.equals(users.getPassword()))
			{
				request.getSession().setAttribute("USER_NAME",name);
//				String rootPath = request.getSession().getServletContext().getContextPath();
//				response.sendRedirect(rootPath+"/WEB-INF/List.jsp");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/List.jsp");
				dispatcher.forward(request, response);
				//System.out.print("ok");
			    bool = false;
			}
		}
		if(bool)
		{
			request.getSession().setAttribute("errorMsg", "密码或账号错误");
			response.sendRedirect("/demo/Login.jsp");
		}
		
			//conn.close();
		}catch(Exception e){
			
		}
	}

}
