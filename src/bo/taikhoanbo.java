package bo;

import dao.taikhoandao;

public class taikhoanbo {

	taikhoandao tk = new taikhoandao();
	public int getTaiKhoan(String tentk, String mk){
		return tk.getTaiKhoan(tentk, mk);
	}
}
