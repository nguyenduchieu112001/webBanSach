package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class Sach
 */
@WebServlet("/Sach")
public class Sach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sachbo s = new sachbo();
		loaibo l = new loaibo();
		request.setAttribute("listLoai", l.getloai());
		int count =0;
		int endPage=0;
		String indexPage = request.getParameter("page");
		String giaTriTimKiem = request.getParameter("timkiem");
		
		int page=1;
		if(indexPage!=null)
			page = Integer.parseInt(indexPage);
		ArrayList<sachbean> ds = null;
		if(giaTriTimKiem==null) {
			ds = s.pagingBooks(page);
			count = s.getTotalBook();
			endPage = count/12;
			if(count % 12 != 0)
				endPage++;
		}else {
			ds = s.pagingBooksBySearchValue(page, giaTriTimKiem);
			count = s.countBooksBySearchValue(giaTriTimKiem);
			endPage = count/12;
			if(count % 12 != 0)
				endPage++;
		}
		request.setAttribute("l", ds);
		request.setAttribute("endPage", endPage);
		request.setAttribute("tag", page);
		RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
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
