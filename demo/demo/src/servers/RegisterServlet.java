package servers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import db.test;
import entity.Users;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;cgarset=utf-8");
		//Connection conn = test.getConn("demo");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Users user = new Users(name,pass);
		UsersDao dao = new UsersDao();
		if(dao.addUsers(user))
		{
			request.getSession().setAttribute("errorMsg", "注册成功");
			response.sendRedirect("/demo/Login.jsp");
		}
	}

}
