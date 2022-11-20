package bo;

import dao.khachhangdao;
import java.math.BigInteger;
import java.security.MessageDigest;

public class khachhangbo {

	khachhangdao kh = new khachhangdao();

	public int checkKhachHang(String tdn, String mk) {
		return kh.checkKhachHang(tdn, ecrypt(mk));
	}

	public String getTenKhachHang(String tdn, String mk) {
		return kh.getTenKhachHang(tdn, ecrypt(mk));
	}

	public void addKhachHang(String ht, String dc, String sdt, String email, String tdn, String mk){
		kh.addKhachHang(ht, dc, sdt, email, tdn, ecrypt(mk));
	}

	public String getMaKhachHang(String tdn) {
		return kh.getMaKhachHang(tdn);
	}

	public static String ecrypt(String text){
		try {
			String enrtext;
			MessageDigest msd = MessageDigest.getInstance("MD5");
			byte[] srctextbyte = text.getBytes("UTF-8");
			byte[] enrtextbyte = msd.digest(srctextbyte);
			BigInteger big = new BigInteger(1, enrtextbyte);
			enrtext = big.toString(16);
			return enrtext;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return text;
		
	}
//	public static void main(String[] ts) {
//		System.out.println(ecrypt("123"));
//	}
}
