package dao;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class hoadondao {

	public int addHoaDon(int mkh) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into hoadon values (?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, mkh);
//			long millis = System.currentTimeMillis();
//			Date ngaymua = new Date(millis);
			long millis=System.currentTimeMillis();  
	        java.sql.Date ngaymua=new java.sql.Date(millis);  
			cmd.setDate(2, ngaymua);
			cmd.setBoolean(3, false);
			int rs = cmd.executeUpdate();
			cs.cn.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Integer> getMaHoaDon(int mkh) {
		try {
			ArrayList<Integer> ds = new ArrayList<Integer>();
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String getMahd = "select MaHoaDon from hoadon where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(getMahd);
			cmd.setInt(1, mkh);
			ResultSet rs2 = cmd.executeQuery();
			while (rs2.next()) {
				ds.add(rs2.getInt("MaHoaDon"));
			}
			rs2.close();
			cs.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
