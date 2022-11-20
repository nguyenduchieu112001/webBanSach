package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.lichsubo;

/**
 * Servlet implementation class LichSu
 */
@WebServlet("/LichSu")
public class LichSu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LichSu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		giohangbo g;
		String makh = request.getParameter("mkh");
		String act = request.getParameter("act");
		lichsubo ls = new lichsubo();
		hoadonbo hd = new hoadonbo();
		chitiethoadonbo ct = new chitiethoadonbo();
		int mkh;
		if (makh == null || makh.equals("")) {
			response.sendRedirect("login.jsp");
		} else {
			if (act != null) {
				if (act.equals("thanhtoan")) {
					mkh = Integer.parseInt(makh);
					g = (giohangbo) session.getAttribute("gio");
					hd.addHoaDon(mkh);
					for (giohangbean gh : g.ds) {
						String ms = gh.getMaSach();
						long sl = gh.getSoluong();
						for (int i : hd.getMaHoaDon(mkh)) {
							ct.addChiTietHoaDon(ms, sl, i);
							break;
						}
					}
					g.TraLaiTatCa();
				}
			}
			mkh = Integer.parseInt(makh);
			session.setAttribute("ls", ls.getChiTietHoaDon(mkh));
			response.sendRedirect("htlichsu");
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
