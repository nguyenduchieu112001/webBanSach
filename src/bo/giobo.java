package bo;

import java.util.ArrayList;

import bean.giohangbean;
import dao.giodao;

public class giobo {

	giodao g = new giodao();
	public ArrayList<giohangbean> getGio(int mkh){
		return g.getGio(mkh);
	}
	
	public void addGio(String ms, int mkh, long soluong) {
		g.addGio(ms, mkh, soluong);
	}
	
	public void UpdateSoLuongGio(String ms, int mkh, long soluong) {
		g.UpdateSoLuongGio(ms, mkh, soluong);
	}
	
	public long TongTien(int mkh) {
		return g.TongTien(mkh);
	}
	
	public void deleteGio(String ms, int mkh) {
		g.deleteGio(ms, mkh);
	}
	
	public void deleteAllGio(int mkh) {
		g.deleteAllGio(mkh);
	}
}
