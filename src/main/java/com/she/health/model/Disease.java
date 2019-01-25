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

public class Disease
{
	private String heaDiseaseCd;
	
	private String heaDiseaseNm;
	
	private String heaDiseaseClassCd;
	
	private String heaDiseaseClassNm;
	
	private String remark;
	
	private int sortOrder;
	
	private String useYn;
	
	private String useYnNm;
	
	private String createUserId;

	private String createUserNm;
	
	private String createDt;
	
	private String updateUserId;
	
	private String updateUserNm;
	
	private String updateDt;
	
	public String getUseYnNm()
	{
		return useYnNm;
	}

	public void setUseYnNm(String useYnNm)
	{
		this.useYnNm = useYnNm;
	}

	public String getHeaDiseaseCd()
	{
		return heaDiseaseCd;
	}

	public void setHeaDiseaseCd(String heaDiseaseCd)
	{
		this.heaDiseaseCd = heaDiseaseCd;
	}

	public String getHeaDiseaseNm()
	{
		return heaDiseaseNm;
	}

	public void setHeaDiseaseNm(String heaDiseaseNm)
	{
		this.heaDiseaseNm = heaDiseaseNm;
	}

	public String getHeaDiseaseClassCd()
	{
		return heaDiseaseClassCd;
	}

	public void setHeaDiseaseClassCd(String heaDiseaseClassCd)
	{
		this.heaDiseaseClassCd = heaDiseaseClassCd;
	}

	public String getHeaDiseaseClassNm()
	{
		return heaDiseaseClassNm;
	}

	public void setHeaDiseaseClassNm(String heaDiseaseClassNm)
	{
		this.heaDiseaseClassNm = heaDiseaseClassNm;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public int getSortOrder()
	{
		return sortOrder;
	}

	public void setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	public String getUseYn()
	{
		return useYn;
	}

	public void setUseYn(String useYn)
	{
		this.useYn = useYn;
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
