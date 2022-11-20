package bo;

import dao.chitiethoadondao;

public class chitiethoadonbo {

	chitiethoadondao ct = new chitiethoadondao();
	public void addChiTietHoaDon(String ms, long sl, int mhd) {
		ct.addChiTietHoaDon(ms, sl, mhd);;
	}
}
