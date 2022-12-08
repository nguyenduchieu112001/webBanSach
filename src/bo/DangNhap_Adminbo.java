package bo;

import java.math.BigInteger;
import java.security.MessageDigest;

import dao.DangNhap_Admindao;

public class DangNhap_Adminbo {

	DangNhap_Admindao tk = new DangNhap_Admindao();

	public int checkKhachHang(String tdn, String mk) {
		return tk.checkDangNhap(tdn, ecrypt(mk));
	}

	public static String ecrypt(String text) {
		try {
			String enrtext;
			MessageDigest msd = MessageDigest.getInstance("MD5");
			byte[] srctextbyte = text.getBytes("UTF-8");
			byte[] enrtextbyte = msd.digest(srctextbyte);
			BigInteger big = new BigInteger(1, enrtextbyte);
			enrtext = big.toString(16);
			return enrtext;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}

}
