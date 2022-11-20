
package bo;

import java.util.ArrayList;

import bean.chitiethoadonbean;
import dao.lichsudao;

public class lichsubo {

	lichsudao ls = new lichsudao();

	public ArrayList<chitiethoadonbean> getChiTietHoaDon(int makh) {
		return ls.getChiTietHoaDon(makh);
	}

	/*
	 * public void addHoaDon(int mkh) { ls.addHoaDon(mkh); }
	 * 
	 * public ArrayList<Integer> getMaHoaDon(int mkh) { return ls.getMaHoaDon(mkh);
	 * }
	 * 
	 * public void addChiTietHoaDon(String ms, long sl, int mhd) {
	 * ls.addChiTietHoaDon(ms, sl, mhd); ; }
	 */

	/*
	 * public static void main(String[] ts) throws NoSuchAlgorithmException,
	 * UnsupportedEncodingException { String enrtext; String text = "123";
	 * MessageDigest msd = MessageDigest.getInstance("MD5"); byte[] srctextbyte =
	 * text.getBytes("UTF-8"); byte[] enrtextbyte = msd.digest(srctextbyte);
	 * BigInteger big = new BigInteger(1, enrtextbyte); enrtext = big.toString(16);
	 * System.out.println(enrtext);; }
	 */

}
