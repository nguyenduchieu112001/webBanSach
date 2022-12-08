package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {

	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai() {
		ds = ldao.getloai();
		return ds;
	}
	
	public void addLoai(String ml, String tl) {
		ldao.addLoai(ml, tl);
	}
	
	public void editLoai(String ml, String tl, String maloaimoi) {
		ldao.editLoai(ml, tl, maloaimoi);
	}
	
	public void deleteLoai(String ml) {
		ldao.deleteLoai(ml);
	}
	
	public String getTenLoai(String ml) {
		return ldao.getTenLoai(ml);
	}

	/*
	 * public static void main(String[] rs) { loaibo l = new loaibo();
	 * System.out.println(l.getloai().toString()); }
	 */
	 
	 
	 
}
