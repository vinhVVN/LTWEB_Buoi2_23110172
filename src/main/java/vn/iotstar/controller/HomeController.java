package vn.iotstar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/hi","/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setContentType("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		HttpSession session = req.getSession(false); // Chỉ lấy session chứ không tạo
		if (session != null) {
			String username = (String) session.getAttribute("username");
			if (username != null) {
				pw.print("Hello " + username + "!!!");
			}else {
				pw.print("Please login again");
				resp.sendRedirect("login.html");
			}
		}else {
			pw.print("Please login again");
			resp.sendRedirect("login.html");
		}
		pw.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
