package bo;

import java.util.ArrayList;

import dao.hoadondao;

public class hoadonbo {

	hoadondao hd = new hoadondao();
	public void addHoaDon(int mkh) {
		hd.addHoaDon(mkh);
	}
	
	public ArrayList<Integer> getMaHoaDon(int mkh){
		return hd.getMaHoaDon(mkh);
	}
}
