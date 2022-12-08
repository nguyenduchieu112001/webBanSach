package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.khachhangbo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 12;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		khachhangbo kh = new khachhangbo();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		session.setAttribute("makh", kh.getMaKhachHang(username));
		
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		long count = ((Number) session.getAttribute("count")).longValue();
		
		if (answer == null) {
			
			if ((kh.checkKhachHang(username, password) == 1)) {
				if (session.getAttribute("DangNhap") != null)
					session.setAttribute("DangNhap", "");
				session.setAttribute("DangNhap", kh.getTenKhachHang(username, password));
				response.sendRedirect("ChuDeSach");
			} else {
				
				session.setAttribute("count", ++count);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} else {

			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			if ((kh.checkKhachHang(username, password) == 1) && captcha.isCorrect(answer)) {
				if (session.getAttribute("DangNhap") != null)
					session.setAttribute("DangNhap", "");
				session.setAttribute("DangNhap", kh.getTenKhachHang(username, password));
				response.sendRedirect("ChuDeSach");
			} else {
				session.setAttribute("count", ++count);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
