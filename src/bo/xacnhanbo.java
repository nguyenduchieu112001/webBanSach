package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.xacnhandao;


public class xacnhanbo {

	xacnhandao xn = new xacnhandao();
	public ArrayList<xacnhanbean> getXacNhan(){
		return xn.getXacNhan();
	}
	
	public void Confirm(long macthd) {
		xn.Confirm(macthd);
	}
}
