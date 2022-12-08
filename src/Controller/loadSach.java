package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class loadSach
 */
@WebServlet("/loadSach")
public class loadSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		sachbo s =  new sachbo();
		HttpSession session = request.getSession();
		String masach = request.getParameter("ms");
		session.setAttribute("masachcu", masach);
		String image_cu = s.getImagePath(masach);
		session.setAttribute("anhcu", image_cu);
		request.setAttribute("listSach", s.getSach(masach));
		loaibo l = new loaibo();
		request.setAttribute("listLoai", l.getloai());
		RequestDispatcher rd = request.getRequestDispatcher("editSach.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
