
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadonbean;

public class lichsudao {

	public ArrayList<chitiethoadonbean> getChiTietHoaDon(int mkh) {
		try {
			ArrayList<chitiethoadonbean> ds = new ArrayList<chitiethoadonbean>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from VLichSu where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, mkh);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int makh = rs.getInt("makh");
				long soluong = rs.getLong("SoLuongMua");
				Date ngaymua = rs.getDate("NgayMua");
				String anh = rs.getString("anh");
				String tensach = rs.getString("tensach");
				long gia = rs.getLong("gia");
				boolean damua = rs.getBoolean("damua");
				ds.add(new chitiethoadonbean(makh, soluong, ngaymua, anh, tensach, gia, damua));
			}
			rs.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public int addHoaDon(int mkh) { try { CoSodao cs = new CoSodao();
	 * cs.KetNoi(); String sql = "insert into hoadon values (?, ?, ?)";
	 * PreparedStatement cmd = cs.cn.prepareStatement(sql); cmd.setInt(1, mkh); long
	 * millis = System.currentTimeMillis(); Date ngaymua = new Date(millis);
	 * cmd.setDate(2, ngaymua); cmd.setBoolean(3, true); int rs =
	 * cmd.executeUpdate(); cs.cn.close(); return rs; } catch (Exception e) {
	 * e.printStackTrace(); return 0; } }
	 * 
	 * public ArrayList<Integer> getMaHoaDon(int mkh) { try { ArrayList<Integer> ds
	 * = new ArrayList<Integer>(); CoSodao cs = new CoSodao(); cs.KetNoi(); String
	 * getMahd = "select MaHoaDon from hoadon where makh = ?"; PreparedStatement cmd
	 * = cs.cn.prepareStatement(getMahd); cmd.setInt(1, mkh); ResultSet rs2 =
	 * cmd.executeQuery(); while (rs2.next()) { ds.add(rs2.getInt("MaHoaDon")); }
	 * rs2.close(); cs.cn.close(); return ds; } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 * 
	 * public int addChiTietHoaDon(String ms, long sl, int mhd) { try { CoSodao cs =
	 * new CoSodao(); cs.KetNoi(); String sql1 =
	 * "insert into ChiTietHoaDon values (?, ?, ?)";
	 * 
	 * PreparedStatement cmd1 = cs.cn.prepareStatement(sql1); cmd1.setString(1, ms);
	 * cmd1.setLong(2, sl); cmd1.setInt(3, mhd); int rs1 = cmd1.executeUpdate();
	 * cs.cn.close(); return rs1; } catch (Exception e) { e.printStackTrace();
	 * return 0; } }
	 */

}
