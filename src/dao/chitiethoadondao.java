package dao;

import java.sql.PreparedStatement;

public class chitiethoadondao {

	public int addChiTietHoaDon(String ms, long sl, int mhd) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql1 = "insert into ChiTietHoaDon values (?, ?, ?, ?)";

			PreparedStatement cmd1 = cs.cn.prepareStatement(sql1);
			cmd1.setString(1, ms);
			cmd1.setLong(2, sl);
			cmd1.setInt(3, mhd);
			cmd1.setBoolean(4, false);
			int rs1 = cmd1.executeUpdate();
			cs.cn.close();
			return rs1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
