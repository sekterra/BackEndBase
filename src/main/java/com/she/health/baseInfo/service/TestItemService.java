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

import com.she.health.baseInfo.mapper.TestItemMapper;
import com.she.health.model.CheckupTestItem;
import com.she.health.model.TestItem;

/**
 * 건강검진항목 기능정의
 *
 */
@Service
public class TestItemService 
{
	
	@Autowired
	private TestItemMapper testItemMapper;
	
	/**
	 * 건강검진항목 조회
	 * @param heaTestClassCd 검사 분류 코드
	 * @param heaCheckupOrgNo 건강검진기관
	 * @param year 검진년도
	 * @param heaCheckupTypeCd 종합건강검진유형
	 * @param useYn 사용유무
	 * @param heaTestItemNm 검사항목명
	 * @return 건강검진항목 목록
	 * @throws Exception
	 */
	public List<TestItem> getTestItems(String heaTestClassCd, int heaCheckupOrgNo, String year, String heaCheckupTypeCd, String useYn, String optionalYn, String heaTestItemNm) throws Exception 
	{
		return testItemMapper.getTestItems(heaTestClassCd, heaCheckupOrgNo, year, heaCheckupTypeCd, useYn, optionalYn, heaTestItemNm);
	}
	
	/**
	 * 건강검진항목 상세 조회
	 * @param heaTestClassCd
	 * @return 건강검진항목
	 * @throws Exception
	 */
	public TestItem getTestItem(String heaTestItemCd) throws Exception 
	{
		return testItemMapper.getTestItem(heaTestItemCd);
	}

	/**
	 * 건강검진항목 생성
	 * @param testItem 건강검진항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createTestItem(TestItem testItem) throws Exception 
	{
		return testItemMapper.createTestItem(testItem);
	}
	
	/**
	 * 건강검진항목 수정
	 * @param testItem 건강검진항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateTestItem(TestItem testItem) throws Exception 
	{
		return testItemMapper.updateTestItem(testItem);
	}
	
	/**
	 * 건강검진 분류별 검사항목 조회
	 * @param heaCheckupClassCd 검사 분류 코드
	 * @param heaCheckupTypeCd 건강검진유형 코드
	 * @return 건강검진 분류별 검사항목 목록
	 * @throws Exception
	 */
	public List<CheckupTestItem> getCheckupTestItems(String heaCheckupClassCd, String heaCheckupTypeCd) throws Exception 
	{
		return testItemMapper.getCheckupTestItems(heaCheckupClassCd, heaCheckupTypeCd);
	}

	/**
	 * 건강검진 분류별 검사항목 생성
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int createCheckupTestItem(CheckupTestItem checkupTestItem) throws Exception 
	{
		int resultNo = 0;
		String heaTestItemCd = checkupTestItem.getHeaTestItemCd();
		String[] heaTestItemCds = heaTestItemCd != null ? heaTestItemCd.split(",") : null;
		
		//검사항목이 빈 상태로 들어오게 되면 0을 return
		if (heaTestItemCds == null) return resultNo;

		// 검사항목값이 없어야 검진분류코드와 검진유형으로 이루어진 데이터들이 일괄 삭제됨으로 빈값을 매핑한다. (*기존에 들어 있던값은 저장해 둔다.)
		checkupTestItem.setHeaTestItemCd(""); 
		// 항목만 변경 됨으로 검진 분류 코드와 종합건강검진 유형으로 이루어진 값들은 다 삭제 처리한다.
		testItemMapper.deleteCheckupTestItem(checkupTestItem);
		
		// 삭제 처리하고 난 후 값을 새로 집어넣는다.
		for(int i=0; i<heaTestItemCds.length; i++) 
		{
			checkupTestItem.setHeaTestItemCd(heaTestItemCds[i]);
			
			if(testItemMapper.getCheckupTestItemCount(checkupTestItem) == 0)
			{
				resultNo += testItemMapper.createCheckupTestItem(checkupTestItem);
			}
			
		}
		
		return resultNo;
	}
	
	/**
	 * 건강검진 분류별 검사항목 수정
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupTestItem(CheckupTestItem checkupTestItem) throws Exception 
	{
		int resultNo = 0;
		String heaTestItemCd = checkupTestItem.getHeaTestItemCd();
		String[] heaTestItemCds = heaTestItemCd != null ? heaTestItemCd.split(",") : null;
		
		//검사항목이 빈 상태로 들어오게 되면 0을 return
		if (heaTestItemCds == null) return resultNo;
		
		// 검사항목값이 없어야 검진분류코드와 검진유형으로 이루어진 데이터들이 일괄 삭제됨으로 빈값을 매핑한다. (*기존에 들어 있던값은 저장해 둔다.)
		checkupTestItem.setHeaTestItemCd(""); 
		// 항목만 변경 됨으로 검진 분류 코드와 종합건강검진 유형으로 이루어진 값들은 다 삭제 처리한다.
		testItemMapper.deleteCheckupTestItem(checkupTestItem);
		
		// 삭제 처리하고 난 후 값을 새로 집어넣는다.
		for(int i=0; i<heaTestItemCds.length; i++) 
		{
			checkupTestItem.setHeaTestItemCd(heaTestItemCds[i]);
			resultNo += testItemMapper.createCheckupTestItem(checkupTestItem);
		}
		
		return resultNo;
	}
	
	/**
	 * 건강검진 분류별 검사항목 삭제
	 * @param List<CheckupTestItem> 건강검진 분류별 검사항목 삭제 리스트
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int deleteCheckupTestItem(List<CheckupTestItem> checkupTestItems) throws Exception 
	{
		int resultNo = 0;
		for(CheckupTestItem checkupTestItem : checkupTestItems)
		{
			resultNo += testItemMapper.deleteCheckupTestItem(checkupTestItem);
		}
		return resultNo;
	}

}
