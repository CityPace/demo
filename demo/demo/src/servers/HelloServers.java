package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServers")
public class HelloServers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServers() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("name");
		PrintWriter out = response.getWriter();
		System.out.println(username);
		out.print("<p>你的用户名是："+username+"</p>");
		out.print("<p>欢迎登入！"+"</p>");
		out.print("<p>");
		out.flush();
		out.close();
		
	}

}
