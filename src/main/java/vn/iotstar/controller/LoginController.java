package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setContentType("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("vinhdeptrai") && password.equals("12345")) {
			HttpSession session = req.getSession(); // tạo đối tượng HttpSession
			
			session.setAttribute("username", username);
			
			resp.sendRedirect(req.getContextPath() + "/home");
		}else {
			pw.print("Mật khẩu chưa đúng");
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
		
	}
	
}
