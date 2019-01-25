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
package com.she.health.baseInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.she.health.baseInfo.mapper.CheckupOrgMapper;
import com.she.health.model.CheckupOrg;
import com.she.health.model.CheckupOrgTestItem;
import com.she.utils.ConstVal;

/**
 * 건강검진기관 기능정의
 *
 */
@Service
public class CheckupOrgService 
{
	
	@Autowired
	private CheckupOrgMapper checkupOrgMapper;
	
	/**
	 * 건강검진기관 조회
	 * @param heaCheckupOrgNo 사용여부
	 * @return 건강검진기관 목록
	 * @throws Exception
	 */
	public List<CheckupOrg> getCheckupOrgs(String useYn) throws Exception 
	{
		return checkupOrgMapper.getCheckupOrgs(useYn);
	}
	
	/**
	 * 건강검진기관 상세 조회
	 * @param heaCheckupOrgNo
	 * @return 건강검진기관
	 * @throws Exception
	 */
	public CheckupOrg getCheckupOrg(String heaCheckupOrgNo) throws Exception 
	{
		return checkupOrgMapper.getCheckupOrg(heaCheckupOrgNo);
	}

	/**
	 * 건강검진기관 생성
	 * @param checkOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createCheckupOrg(CheckupOrg checkupOrg) throws Exception 
	{
		return checkupOrgMapper.createCheckupOrg(checkupOrg);
	}
	
	/**
	 * 건강검진기관 수정
	 * @param checkOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupOrg(CheckupOrg checkupOrg) throws Exception 
	{
		return checkupOrgMapper.updateCheckupOrg(checkupOrg);
	}
	
	/**
	 * 건강검진기관별 항목 조회
	 * @param optionalYn 선택항목여부
	 * @param heaCheckupOrgNo 검진기관번호
	 * @param year 해당년도
	 * @param heaCheckupTypeCd 검진유형코드
	 * @param heaTestClassCd 항목분류코드
	 * @return 건강검진기관별 항목
	 * @throws Exception
	 */
	public List<CheckupOrgTestItem> getCheckupOrgTestItems(
			String optionalYn, 
			int heaCheckupOrgNo, 
			String year, 
			String heaCheckupTypeCd,
			String heaTestClassCd) throws Exception 
	{
		return checkupOrgMapper.getCheckupOrgTestItems(optionalYn, heaCheckupOrgNo, year, heaCheckupTypeCd, heaTestClassCd);
	}

	/**
	 * 기관별 검사항목 생성
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int createCheckupOrgTestItem(CheckupOrgTestItem checkupOrgTestItem) throws Exception 
	{
		int resultNo = 0;
		String heaTestItemCd = checkupOrgTestItem.getHeaTestItemCd();
		String[] heaTestItemCds = heaTestItemCd != null ? heaTestItemCd.split(",") : null;
		
		//검사항목이 빈 상태로 들어오게 되면 0을 return
		if (heaTestItemCds == null) return resultNo;
		
		// 삭제 처리하고 난 후 값을 새로 집어넣는다.
		for(int i=0; i<heaTestItemCds.length; i++) 
		{
			checkupOrgTestItem.setHeaTestItemCd(heaTestItemCds[i]);
			if("".equals(checkupOrgTestItem.getHeaCheckupTypeCd())) checkupOrgTestItem.setHeaCheckupTypeCd(ConstVal.CODE_MASTER_HEA_CHECKUP_TYPE_NON);
			
			if(checkupOrgMapper.getCheckupOrgTestItemCount(checkupOrgTestItem) == 0)
			{
				resultNo += checkupOrgMapper.createCheckupOrgTestItem(checkupOrgTestItem);
			}
		}
		
		return resultNo;
	}
	
	/**
	 * 기관별 검사항목 수정
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupOrgTestItem(CheckupOrgTestItem checkupOrgTestItem) throws Exception 
	{
		int resultNo = 0;
//		String heaTestItemCd = checkupOrgTestItem.getHeaTestItemCd();
//		String[] heaTestItemCds = heaTestItemCd != null ? heaTestItemCd.split(",") : null;
		
		//검사항목이 빈 상태로 들어오게 되면 0을 return
//		if (heaTestItemCds == null) return resultNo;
		
		// 종합건강검진유형의 값이 비어 있다면 건강검진 유형 아닌 값을 넣어준다. ("01")
		if("".equals(checkupOrgTestItem.getHeaCheckupTypeCd())) checkupOrgTestItem.setHeaCheckupTypeCd(ConstVal.CODE_MASTER_HEA_CHECKUP_TYPE_NON);
		
		// 삭제할 데이터 처리
		for(int i=0; i<checkupOrgTestItem.getDeleteHeaCheckupTestItems().length; i++) {
			checkupOrgTestItem.setHeaTestItemCd(checkupOrgTestItem.getDeleteHeaCheckupTestItems()[i]); 
			checkupOrgMapper.deleteCheckupOrgTestItem(checkupOrgTestItem);
		}
		// 항목만 변경 됨으로 검진 분류 코드와 종합건강검진 유형으로 이루어진 값들은 다 삭제 처리한다.
		
		// 삭제 처리하고 난 후 값을 새로 집어넣는다.
		for(int i=0; i<checkupOrgTestItem.getInsertHeaCheckupTestItems().length; i++) 
		{
			checkupOrgTestItem.setHeaTestItemCd(checkupOrgTestItem.getInsertHeaCheckupTestItems()[i]);
			resultNo += checkupOrgMapper.createCheckupOrgTestItem(checkupOrgTestItem);
		}
		
		return resultNo;
	}
	
	/**
	 * 기관별 검사항목 삭제
	 * @param List<CheckupOrgTestItem> 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int deleteCheckupOrgTestItem(List<CheckupOrgTestItem> CheckupOrgTestItems) throws Exception 
	{
		int resultNo = 0;
		for(CheckupOrgTestItem CheckupOrgTestItem : CheckupOrgTestItems)
		{
			resultNo += checkupOrgMapper.deleteCheckupOrgTestItem(CheckupOrgTestItem);
		}
		return resultNo;
	}

}
