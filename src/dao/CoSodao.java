package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CoSodao {
	public Connection cn;

	public void KetNoi() {
		try {
			// b1: xac dinh he qtcsdl
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://DUCHIEU:1433;databaseName=QlSach;user=sa;password=123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] ts) { CoSodao cs = new CoSodao();
	 * cs.KetNoi(); }
	 */
}