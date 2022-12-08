package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.sachbo;

/**
 * Servlet implementation class addSach
 */
@WebServlet("/addSach")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class addSach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addSach() {
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
		response.setCharacterEncoding("UTF-8");
		if (request.getContentLength() <= 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Sach");
			rd.forward(request, response);
		}
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String nameimg = null;
		sachbo s = new sachbo();
		String ms = null;
		String ts = null;
		String st = null;
		String tg = null;
		String dg = null;
		String sl = null;
		String nn = null;
		String ml = null;
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					String dulieu = fileItem.getFieldName();
					if (dulieu.equals("ma-sach"))
						ms = fileItem.getString();
					if (dulieu.equals("ten-sach"))
						ts = fileItem.getString();
					if (dulieu.equals("so-tap"))
						st = fileItem.getString();
					if (dulieu.equals("tac-gia"))
						tg = fileItem.getString();
					if (dulieu.equals("don-gia"))
						dg = fileItem.getString();
					if (dulieu.equals("so-luong"))
						sl = fileItem.getString();
					if (dulieu.equals("ngay-nhap"))
						nn = fileItem.getString();
					if (dulieu.equals("loai-sach"))
						ml = fileItem.getString();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		s.addSach(ms, ts, Integer.parseInt(sl), Integer.parseInt(dg), ml, Integer.parseInt(st), "image_sach/" + nameimg,
				Date.valueOf(nn), tg);
		RequestDispatcher rd = request.getRequestDispatcher("Sach");
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
