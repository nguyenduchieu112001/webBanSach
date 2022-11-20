package bo;

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
	
	public ArrayList<sachbean> pagingBooksByMaSach(int offset, String ml){
		return sdao.pagingBooksByMaSach(offset, ml);
	}
	
	public ArrayList<sachbean> pagingBooksBySearchValue(int offset, String giaTriTimKiem){
		return sdao.pagingBooksBySearchValue(offset, giaTriTimKiem);
	}
	
	public ArrayList<sachbean> pagingBooks(int offset){
		return sdao.pagingBooks(offset);
	}
}
