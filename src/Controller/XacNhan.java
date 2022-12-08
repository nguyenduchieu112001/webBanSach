package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.xacnhanbo;

/**
 * Servlet implementation class XacNhan
 */
@WebServlet("/XacNhan")
public class XacNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XacNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		xacnhanbo xn = new xacnhanbo();
		HttpSession session = request.getSession();
		String act = request.getParameter("act");
		String macthd = request.getParameter("macthd");
		if (act != null) {
			if (act.equals("confirm")) {
				long mcthd = Long.parseLong(macthd);
				xn.Confirm(mcthd);
				session.setAttribute("xn", xn.getXacNhan());
			}
		} else {
			session.setAttribute("xn", xn.getXacNhan());
			
		}
//		session.setAttribute("xn", xn.getXacNhan());
		RequestDispatcher rd = request.getRequestDispatcher("XacNhan.jsp");
		rd.forward(request, response);

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
