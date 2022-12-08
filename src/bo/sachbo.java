package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {

	sachdao sdao = new sachdao();

	public int getTotalBook() {
		return sdao.getTotalBooks();
	}

	public int countBooksByMaLoai(String ml) {
		return sdao.countBooksByMaLoai(ml);
	}

	public int countBooksBySearchValue(String giaTriTimKiem) {
		return sdao.countBooksBySearchValue(giaTriTimKiem);
	}

	public ArrayList<sachbean> pagingBooksByMaSach(int offset, String ml) {
		return sdao.pagingBooksByMaSach(offset, ml);
	}

	public ArrayList<sachbean> pagingBooksBySearchValue(int offset, String giaTriTimKiem) {
		return sdao.pagingBooksBySearchValue(offset, giaTriTimKiem);
	}

	public ArrayList<sachbean> pagingBooks(int offset) {
		return sdao.pagingBooks(offset);
	}

	public void addSach(String ms, String ts, long sl, long g, String ml, int st, String anh, Date nn, String tg) {
		sdao.addSach(ms, ts, sl, g, ml, st, anh, nn, tg);
	}

	public void deleteSach(String ms) {
		sdao.deleteSach(ms);
	}

	public void editSach(String ms, String ts, long sl, long g, String ml, long st, String anh, Date nn, String tg,
			String masachmoi) {
		sdao.editSach(ms, ts, sl, g, ml, st, anh, nn, tg, masachmoi);
	}

	public String getImagePath(String ms) {
		String[] arr = sdao.getImagePath(ms).split("\\/");
		return arr[arr.length-1];
	}

	public ArrayList<sachbean> getSach(String ms){
		return sdao.getsach(ms);
	}
	
//	public static void main(String[] ts) {
//		sachbo s = new sachbo();
//		System.out.println(s.getSach("b1").toString());
//	}
}
