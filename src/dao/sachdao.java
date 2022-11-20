package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;

public class sachdao {

	//get all sach
	public ArrayList<sachbean> getsach() {
		try {
			ArrayList<sachbean> dssach = new ArrayList<sachbean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				dssach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			cs.cn.close();
			return dssach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Cout all sach
	public int getTotalBooks() {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//count sach by maloai
	public int countBooksByMaLoai(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//count sach by search value
	public int countBooksBySearchValue(String giaTriTimKiem) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach where tensach like CONCAT('%', ? , '%')";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, giaTriTimKiem);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			cs.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//get sach using pagination by masach
	public ArrayList<sachbean> pagingBooksByMaSach(int offset, String ml) {
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " where maloai = ? "
					+ " order by masach offset ? rows fetch next 12 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setInt(2, (offset - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			cs.cn.close();
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get sach using pagination with search value
	public ArrayList<sachbean> pagingBooksBySearchValue(int offset, String giaTriTimKiem){
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " where tensach like CONCAT('%', ? , '%') "
					+ " order by masach offset ? rows fetch next 12 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, giaTriTimKiem);
			cmd.setInt(2, (offset - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			cs.cn.close();
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get all sach using pagination
	public ArrayList<sachbean> pagingBooks(int offset){
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " order by masach offset ? rows fetch next 12 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, (offset - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			cs.cn.close();
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
