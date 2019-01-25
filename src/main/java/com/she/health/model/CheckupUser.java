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

public class CheckupUser
{
	private int heaCheckupPlanNo;
	
	private String heaCheckupClassCd;
	
	private String heaCheckupClassNm;
	
	private String heaCheckupPlanNm;
	
	private String heaCheckupTypeCd;
	
	private String heaCheckupTypeNm;
	
	private String processNm;
	
	private String deptCd;
	
	private String deptNm;
	
	private String userId;
	
	private String userNm;
	
	private String entryYmd;
	
	private String phoneNo;
	
	private String officeTel;
	
	private String email;
	
	private String notifyPlanYn;
	
	private String notifyPlanYmd;
	
	private String reserveYn;
	
	private String reserveBatchYn;
	
	private String reserveYmd;
	
	private int heaCheckupOrgNo;
	
	private int heaCheckedOrgNo;
	
	private String heaCheckupOrgNm;
	
	private String heaCheckedYmd;
	
	private String heaCheckupPlanPeriod;

	private String createUserId;
	
	private String updateUserId;
	
	private String reserveManage;
	
	private String checkupYear;
	
	private String consentYn;
	
	private String statusYn;
	
	private String requiredOptYn;
	
	private String selectOptCount;
	
	private String startYmd;
	
	private String endYmd;

	private String[] selectedTestItemCd;

	public String getStartYmd()
	{
		return startYmd;
	}

	public void setStartYmd(String startYmd)
	{
		this.startYmd = startYmd;
	}

	public String getEndYmd()
	{
		return endYmd;
	}

	public void setEndYmd(String endYmd)
	{
		this.endYmd = endYmd;
	}

	public String getRequiredOptYn()
	{
		return requiredOptYn;
	}

	public void setRequiredOptYn(String requiredOptYn)
	{
		this.requiredOptYn = requiredOptYn;
	}

	public String getSelectOptCount()
	{
		return selectOptCount;
	}

	public void setSelectOptCount(String selectOptCount)
	{
		this.selectOptCount = selectOptCount;
	}

	public String getReserveBatchYn()
	{
		return reserveBatchYn;
	}

	public void setReserveBatchYn(String reserveBatchYn)
	{
		this.reserveBatchYn = reserveBatchYn;
	}

	public String getUpdateUserId()
	{
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId)
	{
		this.updateUserId = updateUserId;
	}

	public String getConsentYn()
	{
		return consentYn;
	}

	public void setConsentYn(String consentYn)
	{
		this.consentYn = consentYn;
	}

	public int getHeaCheckedOrgNo()
	{
		return heaCheckedOrgNo;
	}

	public void setHeaCheckedOrgNo(int heaCheckedOrgNo)
	{
		this.heaCheckedOrgNo = heaCheckedOrgNo;
	}

	public String[] getSelectedTestItemCd()
	{
		return selectedTestItemCd;
	}

	public void setSelectedTestItemCd(String[] selectedTestItemCd)
	{
		this.selectedTestItemCd = selectedTestItemCd;
	}
	
	public String getCheckupYear()
	{
		return checkupYear;
	}

	public void setCheckupYear(String checkupYear)
	{
		this.checkupYear = checkupYear;
	}

	public String getReserveManage()
	{
		return reserveManage;
	}

	public void setReserveManage(String reserveManage)
	{
		this.reserveManage = reserveManage;
	}

	public int getHeaCheckupOrgNo()
	{
		return heaCheckupOrgNo;
	}

	public void setHeaCheckupOrgNo(int heaCheckupOrgNo)
	{
		this.heaCheckupOrgNo = heaCheckupOrgNo;
	}

	public String getHeaCheckupOrgNm()
	{
		return heaCheckupOrgNm;
	}

	public void setHeaCheckupOrgNm(String heaCheckupOrgNm)
	{
		this.heaCheckupOrgNm = heaCheckupOrgNm;
	}

	public String getHeaCheckedYmd()
	{
		return heaCheckedYmd;
	}

	public void setHeaCheckedYmd(String heaCheckedYmd)
	{
		this.heaCheckedYmd = heaCheckedYmd;
	}

	public String getHeaCheckupPlanPeriod()
	{
		return heaCheckupPlanPeriod;
	}

	public void setHeaCheckupPlanPeriod(String heaCheckupPlanPeriod)
	{
		this.heaCheckupPlanPeriod = heaCheckupPlanPeriod;
	}

	public int getHeaCheckupPlanNo()
	{
		return heaCheckupPlanNo;
	}

	public void setHeaCheckupPlanNo(int heaCheckupPlanNo)
	{
		this.heaCheckupPlanNo = heaCheckupPlanNo;
	}

	public String getHeaCheckupClassCd()
	{
		return heaCheckupClassCd;
	}

	public void setHeaCheckupClassCd(String heaCheckupClassCd)
	{
		this.heaCheckupClassCd = heaCheckupClassCd;
	}

	public String getHeaCheckupClassNm()
	{
		return heaCheckupClassNm;
	}

	public void setHeaCheckupClassNm(String heaCheckupClassNm)
	{
		this.heaCheckupClassNm = heaCheckupClassNm;
	}

	public String getHeaCheckupPlanNm()
	{
		return heaCheckupPlanNm;
	}

	public void setHeaCheckupPlanNm(String heaCheckupPlanNm)
	{
		this.heaCheckupPlanNm = heaCheckupPlanNm;
	}

	public String getHeaCheckupTypeCd()
	{
		return heaCheckupTypeCd;
	}

	public void setHeaCheckupTypeCd(String heaCheckupTypeCd)
	{
		this.heaCheckupTypeCd = heaCheckupTypeCd;
	}

	public String getHeaCheckupTypeNm()
	{
		return heaCheckupTypeNm;
	}

	public void setHeaCheckupTypeNm(String heaCheckupTypeNm)
	{
		this.heaCheckupTypeNm = heaCheckupTypeNm;
	}

	public String getProcessNm()
	{
		return processNm;
	}

	public void setProcessNm(String processNm)
	{
		this.processNm = processNm;
	}

	public String getDeptCd()
	{
		return deptCd;
	}

	public void setDeptCd(String deptCd)
	{
		this.deptCd = deptCd;
	}

	public String getDeptNm()
	{
		return deptNm;
	}

	public void setDeptNm(String deptNm)
	{
		this.deptNm = deptNm;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserNm()
	{
		return userNm;
	}

	public void setUserNm(String userNm)
	{
		this.userNm = userNm;
	}

	public String getEntryYmd()
	{
		return entryYmd;
	}

	public void setEntryYmd(String entryYmd)
	{
		this.entryYmd = entryYmd;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public String getOfficeTel()
	{
		return officeTel;
	}

	public void setOfficeTel(String officeTel)
	{
		this.officeTel = officeTel;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNotifyPlanYn()
	{
		return notifyPlanYn;
	}

	public void setNotifyPlanYn(String notifyPlanYn)
	{
		this.notifyPlanYn = notifyPlanYn;
	}

	public String getNotifyPlanYmd()
	{
		return notifyPlanYmd;
	}

	public void setNotifyPlanYmd(String notifyPlanYmd)
	{
		this.notifyPlanYmd = notifyPlanYmd;
	}

	public String getReserveYn()
	{
		return reserveYn;
	}

	public void setReserveYn(String reserveYn)
	{
		this.reserveYn = reserveYn;
	}

	public String getReserveYmd()
	{
		return reserveYmd;
	}

	public void setReserveYmd(String reserveYmd)
	{
		this.reserveYmd = reserveYmd;
	}

	public String getCreateUserId()
	{
		return createUserId;
	}

	public void setCreateUserId(String createUserId)
	{
		this.createUserId = createUserId;
	}

	public String getStatusYn()
	{
		return statusYn;
	}

	public void setStatusYn(String statusYn)
	{
		this.statusYn = statusYn;
	}
}
