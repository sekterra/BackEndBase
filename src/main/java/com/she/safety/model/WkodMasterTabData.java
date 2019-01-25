/** 
 * Copyright (C) 2019, 2019 All Right Reserved, http://www.yullin.com/
 * 
 * SHE Business can not be copied and/or distributed without the express
 * permission of Yullin Technologies
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 
 */

package com.she.safety.model;

import java.util.List;

public class WkodMasterTabData
{
	private List<String> wkodSpeCds;
	
	private List<WkodChkItem> wkodDeptRequest;
	
	private List<WkodChkItem> wkodDeptWork;
	
	private List<WkodChkItem> selectedRequestRow;
	
	private List<WkodChkItem> selectedWorkRow;
	
	private List<WkodMatMst> selectHandleChemContentRow;

	public List<String> getWkodSpeCds() {
		return wkodSpeCds;
	}

	public void setWkodSpeCds(List<String> wkodSpeCds) {
		this.wkodSpeCds = wkodSpeCds;
	}

	public List<WkodChkItem> getWkodDeptRequest() {
		return wkodDeptRequest;
	}

	public void setWkodDeptRequest(List<WkodChkItem> wkodDeptRequest) {
		this.wkodDeptRequest = wkodDeptRequest;
	}

	public List<WkodChkItem> getWkodDeptWork() {
		return wkodDeptWork;
	}

	public void setWkodDeptWork(List<WkodChkItem> wkodDeptWork) {
		this.wkodDeptWork = wkodDeptWork;
	}

	public List<WkodChkItem> getSelectedRequestRow() {
		return selectedRequestRow;
	}

	public void setSelectedRequestRow(List<WkodChkItem> selectedRequestRow) {
		this.selectedRequestRow = selectedRequestRow;
	}

	public List<WkodChkItem> getSelectedWorkRow() {
		return selectedWorkRow;
	}

	public void setSelectedWorkRow(List<WkodChkItem> selectedWorkRow) {
		this.selectedWorkRow = selectedWorkRow;
	}

	public List<WkodMatMst> getSelectHandleChemContentRow() {
		return selectHandleChemContentRow;
	}

	public void setSelectHandleChemContentRow(List<WkodMatMst> selectHandleChemContentRow) {
		this.selectHandleChemContentRow = selectHandleChemContentRow;
	}
}