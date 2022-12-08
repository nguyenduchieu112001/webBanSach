package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.don_duyetdao;

public class donduyetbo {

	don_duyetdao d = new don_duyetdao();
	public ArrayList<xacnhanbean> getDonDuyet(){
		return d.getDonDuyet();
	}
}
