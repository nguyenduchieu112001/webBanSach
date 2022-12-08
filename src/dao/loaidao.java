package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {

	public ArrayList<loaibean> getloai() {
		try {
			ArrayList<loaibean> dsloai = new ArrayList<loaibean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from loai";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				dsloai.add(new loaibean(maloai, tenloai));
			}

			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
			return dsloai;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTenLoai(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select tenloai from loai where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while(rs.next())
				return rs.getString(1);
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int addLoai(String ml, String tl) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into loai values (?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setString(2, tl);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int editLoai(String ml, String tl, String maloaimoi) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update loai set maloai = ?, tenloai = ? where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloaimoi);
			cmd.setString(2, tl);
			cmd.setString(3, ml);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
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
			return 0;
		}
	}
}
