package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;

public class giodao {

	public int addGio(String ms, int mkh, long soluong) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into gio values (?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setInt(2, mkh);
			cmd.setLong(3, soluong);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@SuppressWarnings("unused")
	public ArrayList<giohangbean> getGio(int mkh){
		try {
			ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select *, (soluong*gia) as thanhtien from VGio\r\n"
					+ "where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, mkh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				long thanhtien = rs.getLong("thanhtien");
				String anh = rs.getString("anh");
				ds.add(new giohangbean(maSach, tenSach, soluong, gia, anh));
			}
			rs.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteGio(String ms, int mkh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from gio where masach = ? and makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setInt(2, mkh);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteAllGio(int mkh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from gio where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, mkh);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int UpdateSoLuongGio(String ms, int mkh, long soluong) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update gio set soluong = ? where masach = ? and makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setLong(1, soluong);
			cmd.setString(2, ms);
			cmd.setInt(3, mkh);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public long TongTien(int mkh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select sum(soluong*gia) from VGio where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, mkh);
			ResultSet rs = cmd.executeQuery();
			return rs.getLong(1);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
