package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.sachbo;

/**
 * Servlet implementation class deleteSach
 */
@WebServlet("/deleteSach")
public class deleteSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sachbo sbo = new sachbo();
		String masach = request.getParameter("ms");
		//Lấy ảnh từ db với masach = masach
		String image = sbo.getImagePath(masach);
		String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
		String fileImg = dirUrl + File.separator + image;
		try {
			Files.delete(Paths.get(fileImg));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sbo.deleteSach(masach);
		response.sendRedirect("Sach");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
