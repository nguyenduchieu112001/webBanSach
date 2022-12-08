package bean;

import java.sql.Date;

public class xacnhanbean {

	private int makh;
	private String hoten;
	private String tensach;
	private long soluongmua;
	private long gia;
	private long thanhtien;
	private Date ngaymua;
	private boolean damua;
	private int mahd;
	private int macthd;
	public xacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public xacnhanbean(int makh, String hoten, String tensach, long soluongmua, long gia, long thanhtien, Date ngaymua,
			boolean damua, int mahd, int macthd) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tensach = tensach;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
		this.damua = damua;
		this.mahd = mahd;
		this.macthd = macthd;
	}

	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public int getMacthd() {
		return macthd;
	}

	public void setMacthd(int macthd) {
		this.macthd = macthd;
	}
	
	
}


