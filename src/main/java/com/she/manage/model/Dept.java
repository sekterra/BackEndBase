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

package com.she.manage.model;

public class Dept 
{
	private String deptCd;
	
	private String deptNm;
	
	private String createUserId;

	private String createUserNm;
	
	private String createDt;
	
	private String updateUserId;
	
	private String updateUserNm;
	
	private String updateDt;
	
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

	public String getCreateUserId()
	{
		return createUserId;
	}

	public void setCreateUserId(String createUserId)
	{
		this.createUserId = createUserId;
	}

	public String getCreateUserNm()
	{
		return createUserNm;
	}

	public void setCreateUserNm(String createUserNm)
	{
		this.createUserNm = createUserNm;
	}

	public String getCreateDt()
	{
		return createDt;
	}

	public void setCreateDt(String createDt)
	{
		this.createDt = createDt;
	}

	public String getUpdateUserId()
	{
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId)
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserNm()
	{
		return updateUserNm;
	}

	public void setUpdateUserNm(String updateUserNm)
	{
		this.updateUserNm = updateUserNm;
	}

	public String getUpdateDt()
	{
		return updateDt;
	}

	public void setUpdateDt(String updateDt)
	{
		this.updateDt = updateDt;
	}
}
