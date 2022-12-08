package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.xacnhanbean;

public class xacnhandao {

	public ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
	public ArrayList<xacnhanbean> getXacNhan(){
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VXacNhan";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int makh = rs.getInt("makh");
				String hoten = rs.getString("hoten");
				String tensach = rs.getString("tensach");
				long soluongmua = rs.getLong("SoLuongMua");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("ThanhTien");
				Date ngaymua = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				int mahd = rs.getInt("MaHoaDon");
				int macthd = rs.getInt("MaChiTietHD");
				ds.add(new xacnhanbean(makh, hoten, tensach, soluongmua, gia, thanhtien, ngaymua, damua, mahd, macthd));
			}
			rs.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int Confirm(long macthd) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update VXacNhan set damua = 1 where MaChiTietHD = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, macthd);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
