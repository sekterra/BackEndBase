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

package com.she.health.model;

import java.util.List;

public class InfirmaryUsage 
{
	private int heaInfirmaryUsageNo;
	
	private String userId;
	
	private String deptCd;
	
	private String visitYmd;
	
	private String heaTreatCd;
	
	private String heaTreatNm;
	
	private String symptom;
	
	private String consult;
	
	private String remark;
	
	private String createUserId;
	
	private String createDt;
	
	private String updateUserId;
	
	private String updateDt;
	
	private String deptNm;
	
	private String userNm;
	
	public String getHeaTreatNm()
	{
		return heaTreatNm;
	}

	public void setHeaTreatNm(String heaTreatNm)
	{
		this.heaTreatNm = heaTreatNm;
	}

	private List<Prescribe> prescribeList;
	
	public List<Prescribe> getPrescribeList()
	{
		return prescribeList;
	}

	public void setPrescribeList(List<Prescribe> prescribeList)
	{
		this.prescribeList = prescribeList;
	}

	public String getSymptom()
	{
		return symptom;
	}

	public void setSymptom(String symptom)
	{
		this.symptom = symptom;
	}

	public String getConsult()
	{
		return consult;
	}

	public void setConsult(String consult)
	{
		this.consult = consult;
	}
	
	public String getDeptNm()
	{
		return deptNm;
	}

	public void setDeptNm(String deptNm)
	{
		this.deptNm = deptNm;
	}

	public String getUserNm()
	{
		return userNm;
	}

	public void setUserNm(String userNm)
	{
		this.userNm = userNm;
	}

	public int getHeaInfirmaryUsageNo() {
		return heaInfirmaryUsageNo;
	}

	public void setHeaInfirmaryUsageNo(int heaInfirmaryUsageNo) {
		this.heaInfirmaryUsageNo = heaInfirmaryUsageNo;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getVisitYmd() {
		return visitYmd;
	}

	public void setVisitYmd(String visitYmd) {
		this.visitYmd = visitYmd;
	}

	public String getHeaTreatCd() {
		return heaTreatCd;
	}

	public void setHeaTreatCd(String heaTreatCd) {
		this.heaTreatCd = heaTreatCd;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public String getCreateDt()
	{
		return createDt;
	}

	public void setCreateDt(String createDt)
	{
		this.createDt = createDt;
	}

	public String getCreateUserId()
	{
		return createUserId;
	}

	public void setCreateUserId(String createUserId)
	{
		this.createUserId = createUserId;
	}

	public String getUpdateUserId()
	{
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId)
	{
		this.updateUserId = updateUserId;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
}
