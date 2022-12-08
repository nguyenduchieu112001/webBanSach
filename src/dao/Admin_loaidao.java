package dao;

import java.sql.PreparedStatement;

public class Admin_loaidao {

	public int addLoai(String ml, String tl) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into loai values(?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setString(2, tl);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int editLoai(String ml, String tl) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update loai set tenloai = ? where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tl);
			cmd.setString(2, ml);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteLoai(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from loai where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
