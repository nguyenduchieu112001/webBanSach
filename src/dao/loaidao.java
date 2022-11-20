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
}
