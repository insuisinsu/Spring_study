package com.mybatis.join.VO;

public class SJoinVO {

	private SEmployeeVO sempJ;
	private SDepartmentVO sdeptJ;
	
	public SJoinVO() {}

	public SEmployeeVO getSempJ() {
		return sempJ;
	}

	public void setSempJ(SEmployeeVO sempJ) {
		this.sempJ = sempJ;
	}

	public SDepartmentVO getSdeptJ() {
		return sdeptJ;
	}

	public void setSdeptJ(SDepartmentVO sdeptJ) {
		this.sdeptJ = sdeptJ;
	}

	@Override
	public String toString() {
		return "SJoinVO [sempJ=" + sempJ + ", sdeptJ=" + sdeptJ + "]";
	}
	
	
	
	
}
