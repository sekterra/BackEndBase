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

package com.she.health.checkup.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.she.health.baseInfo.mapper.CheckupOrgMapper;
import com.she.health.checkup.mapper.CheckupPlanMapper;
import com.she.health.checkup.mapper.CheckupResultMapper;
import com.she.health.model.CheckupOrgTestItem;
import com.she.health.model.CheckupPlan;
import com.she.health.model.CheckupPlanOrg;
import com.she.health.model.CheckupResult;
import com.she.health.model.CheckupStatus;
import com.she.health.model.CheckupUser;
import com.she.health.model.TestItemResult;
import com.she.utils.ConstVal;
import com.she.utils.Methods;

/**
 * 건강검진계획 기능정의
 *
 */
@Service
public class CheckupPlanService
{
	@Autowired
	private CheckupResultMapper checkupResultMapper;
	
	@Autowired
	private CheckupPlanMapper checkupPlanMapper;
	
	@Autowired
	private CheckupOrgMapper checkupOrgMapper;
	
	/**
	 * 건강검진계획 조회
	 * @param checkupYear 검진년도
	 * @param startYmd 검진기간시작일
	 * @param endYmd 검진기간종료일
	 * @return 건강검진계획 목록
	 * @throws Exception
	 */
	public List<CheckupPlan> getCheckupPlans(String checkupYear, String startYmd, String endYmd) throws Exception
	{
		return this.checkupPlanMapper.getCheckupPlans(checkupYear, startYmd, endYmd);
	}
	
	/**
	 * 건강검진계획 상세 조회
	 * @param heaCheckupPlanNo
	 * @return 건강검진계획
	 * @throws Exception
	 */
	public CheckupPlan getCheckupPlan(int heaCheckupPlanNo) throws Exception
	{
		return this.checkupPlanMapper.getCheckupPlan(heaCheckupPlanNo);
	}
	
	/**
	 * 건강검진계획 생성
	 * @param checkupPlan 건강검진계획
	 * @return 건강검진계획번호
	 * @throws Exception
	 */
	@Transactional
	public int createCheckupPlan(CheckupPlan checkupPlan) throws Exception
	{
		int resultNo = 0;
		resultNo = this.checkupPlanMapper.createCheckupPlan(checkupPlan) > 0? checkupPlan.getHeaCheckupPlanNo():0;
		
		CheckupPlanOrg checkupPlanOrg = new CheckupPlanOrg();
		checkupPlanOrg.setHeaCheckupPlanNo(checkupPlan.getHeaCheckupPlanNo());
		checkupPlanOrg.setCreateUserId(checkupPlan.getCreateUserId());
		checkupPlanOrg.setStartYmd(checkupPlan.getStartYmd());
		checkupPlanOrg.setEndYmd(checkupPlan.getEndYmd());
		
		int[] heaCheckupOrgNos = checkupPlan.getSelectedHeaCheckupOrgNos();
		for(int i=0; i<heaCheckupOrgNos.length; i++) 
		{
			checkupPlanOrg.setHeaCheckupOrgNo(heaCheckupOrgNos[i]);
			this.checkupPlanMapper.createCheckupPlanOrg(checkupPlanOrg);
		}
		
		return resultNo;
	}
	
	/**
	 * 건강검진계획 수정
	 * @param checkupPlan 건강검진계획
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupPlan(CheckupPlan checkupPlan) throws Exception
	{
		int resultNo = 0;
		resultNo += this.checkupPlanMapper.updateCheckupPlan(checkupPlan);
		
		// 계획별 기관 테이블에 계획번호에 따른 모든 기관 데이터들을 삭제
		this.checkupPlanMapper.deleteCheckupPlanOrg(checkupPlan.getHeaCheckupPlanNo(), 0);
		
		CheckupPlanOrg checkupPlanOrg = new CheckupPlanOrg();
		checkupPlanOrg.setHeaCheckupPlanNo(checkupPlan.getHeaCheckupPlanNo());
		checkupPlanOrg.setCreateUserId(checkupPlan.getCreateUserId());
		checkupPlanOrg.setStartYmd(checkupPlan.getStartYmd());
		checkupPlanOrg.setEndYmd(checkupPlan.getEndYmd());
		
		int[] heaCheckupOrgNos = checkupPlan.getSelectedHeaCheckupOrgNos();
		for(int i=0; i<heaCheckupOrgNos.length; i++) 
		{
			checkupPlanOrg.setHeaCheckupOrgNo(heaCheckupOrgNos[i]);
			resultNo += this.checkupPlanMapper.createCheckupPlanOrg(checkupPlanOrg);
		}
		return resultNo;
	}
	
	/**
	 * 건강검진계획 삭제
	 * @param List<CheckupPlan> 건강검진계획 삭제 리스트 
	 * @return 삭제 행 수
	 * @throws Exception
	 */
	@Transactional
	public int deleteCheckupPlan(List<CheckupPlan> checkupPlans) throws Exception
	{
		int resultNo = 0;
		for(CheckupPlan checkupPlan : checkupPlans)
		{
			resultNo += this.checkupPlanMapper.deleteCheckupPlan(checkupPlan);
			resultNo += this.checkupPlanMapper.deleteCheckupPlanOrg(checkupPlan.getHeaCheckupPlanNo(), 0);
		}
		return resultNo;
	}
	
	/**
	 * 건강검진계획별 대상자 지정
	 * @param CheckupUsers 건강검진대상자 목록
	 * @return 생성행수
	 * @throws Exception
	 */
	@Transactional
	public int createCheckupUsers(List<CheckupUser> checkupUsers) throws Exception
	{
		int count = 0;
		for (CheckupUser checkupUser : checkupUsers)
		{
			checkupUser.setCreateUserId("dev");
			count += this.checkupPlanMapper.createCheckupUser(checkupUser);
		}
		
		return count;
	}
	
	/**
	 * 건강검진계획별 대상자 해제
	 * @param checkupUser 건강검진대상자 목록
	 * @return 삭제행수
	 * @throws Exception
	 */
	@Transactional
	public int deleteCheckupUsers(List<CheckupUser> checkupUsers) throws Exception
	{
		int count = 0;
		for (CheckupUser checkupUser : checkupUsers)
		{
			count += this.checkupPlanMapper.deleteCheckupUser(checkupUser);
		}
		
		return count;
	}
	
	/**
	 * 검색조건 해당 대상자 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param userId 사용자아이디
	 * @param userNm 사용자명
	 * @param notifyPlanYn 통보여부
	 * @param reserveYn 예약여부
	 * @param reserveYmdStart 예약일자검색 시작일
	 * @param reserveYmdEnd 예약일자검색 종료일
	 * @param heaCheckedOrgNos 예약검진기관
	 * @param statusYn 수검여부
	 * @return 대상자목록
	 * @throws Exception
	 */	
	public List<CheckupUser> getCheckupUsers(
			int heaCheckupPlanNo,
			int processNo,
			String deptCd,
			String userId,
			String userNm,
			String notifyPlanYn,
			String reserveYn,
			String reserveYmdStart,
			String reserveYmdEnd,
			int[] heaCheckedOrgNos,
			int[] heaCheckupOrgNos,
			String statusYn) throws Exception
	{
		return this.checkupPlanMapper.getCheckupUsers(
				heaCheckupPlanNo
				, processNo
				, deptCd
				, userId
				, userNm
				, notifyPlanYn
				, reserveYn
				, reserveYmdStart
				, reserveYmdEnd
				, heaCheckedOrgNos
				, heaCheckupOrgNos
				, statusYn);
	}
	
	/**
	 * 검색조건 해당 가능한 대상자 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param userId 사용자아이디
	 * @param userNm 사용자명
	 * @param prevYearCheckupUserYn 작년수검자제외여부
	 * @param age 나이대
	 * @return 지정가능 대상자목록
	 * @throws Exception
	 */
	public List<CheckupUser> getCheckupUsersNoTarget(
			int heaCheckupPlanNo,
			int processNo,
			String deptCd,
			String userId,
			String userNm,
			String prevYearCheckupUserYn,
			int age) throws Exception
	{
		return this.checkupPlanMapper.getCheckupUsersNoTarget(heaCheckupPlanNo, processNo, deptCd, userId, userNm, prevYearCheckupUserYn, age);
	}
	
	/**
	 * 건강검진계획별 기관 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param standardYmd 기준날짜
	 * @return 건강검진계획별 기관 목록
	 * @throws Exception
	 */
	public List<CheckupPlanOrg> getCheckupPlanOrgs(int heaCheckupPlanNo, int heaCheckupOrgNo, String standardYmd) throws Exception
	{
		return this.checkupPlanMapper.getCheckupPlanOrgs(heaCheckupPlanNo, heaCheckupOrgNo, standardYmd);
	}
	
	/**
	 * 건강검진계획별 기관일정 수정
	 * @param checkupPlanOrgs 건강검진기관 일정 목록
	 * @return 수정 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupPlanOrgs(List<CheckupPlanOrg> checkupPlanOrgs) throws Exception
	{
		int count = 0;
		for (CheckupPlanOrg checkupPlanOrg : checkupPlanOrgs)
		{
			checkupPlanOrg.setUpdateUserId("dev");
			count += this.checkupPlanMapper.updateCheckupPlanOrg(checkupPlanOrg);
		}
		
		return count;
	}
	
	/**
	 * 등록된 건강검진 계획별 사용자 예약 현황 목록 조회
	 * @param userId 사용자 ID
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @return 대상자목록
	 */
	public List<CheckupUser> getCheckupReserves(String userId, int heaCheckupPlanNo) throws Exception
	{
		return this.checkupPlanMapper.getCheckupReserves(userId, heaCheckupPlanNo);
	}
	
	/**
	 * 월별 검진기관별 예약인원 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param heaCheckupOrgNo 건강검진기관번호
	 * @param yearMonth 기준년월
	 * @return 기관별예약현황
	 * @throws Exception
	 */
	public List<CheckupPlanOrg> getCheckupReserveOrgStatus(int heaCheckupPlanNo, int heaCheckupOrgNo, String yearMonth) throws Exception
	{
		return this.checkupPlanMapper.getCheckupReserveOrgStatus(heaCheckupPlanNo, heaCheckupOrgNo, yearMonth);
	}
	
	/**
	 * 건강검진계획별 예약자 변경
	 * @param checkupUsers 대상자변경목록
	 * @return 변경행수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupReserveChange(List<CheckupUser> checkupUsers) throws Exception
	{
		int count = 0;
		for (CheckupUser checkupUser : checkupUsers)
		{
			checkupUser.setUpdateUserId(Methods.getLoginUser().getUserId());
			count += this.checkupPlanMapper.updateCheckupReserve(checkupUser);
		}
		
		return count;
	}
	
	/**
	 * 건강검진계획별 일괄 예약 등록
	 * @param checkupUsers 대상자변경목록
	 * @return 변경행수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupReserveBatch(List<CheckupUser> checkupUsers) throws Exception
	{
		int count = 0;
		for (CheckupUser checkupUser : checkupUsers)
		{
			checkupUser.setUpdateUserId(Methods.getLoginUser().getUserId());
			// 일괄예약값 설정
			checkupUser.setReserveBatchYn("Y");
			count += this.checkupPlanMapper.updateCheckupReserve(checkupUser);
		}
		
		return count;
	}
	
	/**
	 * 건강검진 사용자 예약
	 * @param CheckupResult
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupReserve(CheckupUser checkupUser) throws Exception 
	{		
		int resultNo = 0;
		TestItemResult testItemResult = new TestItemResult(); 
		
		// 결과값을 제외한 데이터 (건강검진계획번호, 사용자ID)
		testItemResult.setHeaCheckupPlanNo(checkupUser.getHeaCheckupPlanNo());
		testItemResult.setUserId(checkupUser.getUserId());
		testItemResult.setUpdateUserId(checkupUser.getUserId());
		
		// hea_checkup_org_test_item_no 가져오기 위한 데이터 (기관번호, 검진년도, 건강검진유형, 항목번호)
		testItemResult.setHeaCheckupOrgNo(checkupUser.getHeaCheckupOrgNo());
		testItemResult.setYear(checkupUser.getCheckupYear());
		testItemResult.setHeaCheckupTypeCd(checkupUser.getHeaCheckupTypeCd());
		
		this.checkupResultMapper.deleteTestItemResult(testItemResult.getHeaCheckupPlanNo(), testItemResult.getUserId(), 0);
		
		// 선택 건강검진 검사항목 
		for(int i=0; i<checkupUser.getSelectedTestItemCd().length; i++)
		{
			testItemResult.setHeaTestItemCd(checkupUser.getSelectedTestItemCd()[i]);
			resultNo += this.checkupResultMapper.createTestItemResult(testItemResult);
		}
		
		List<CheckupOrgTestItem> checkupOrgTestItems = checkupOrgMapper.getCheckupOrgTestItems(
				ConstVal.CHECKUP_ORG_TEST_ITEM_OPTIONAL_YN_COMMON, 
				testItemResult.getHeaCheckupOrgNo(),
				testItemResult.getYear(),
				testItemResult.getHeaCheckupTypeCd(),
				"");
		// 공통 건강검진 검사항목 
		for(CheckupOrgTestItem checkupOrgTestItem : checkupOrgTestItems)
		{
			testItemResult.setHeaTestItemCd(checkupOrgTestItem.getHeaTestItemCd());
			resultNo += this.checkupResultMapper.createTestItemResult(testItemResult);
		}
		
		resultNo += this.checkupPlanMapper.updateCheckupReserve(checkupUser);
		return resultNo;
	}
	
	/**
	 * 건강검진 사용자 예약 변경
	 * @param CheckupResult 
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateCheckupReserveChange(CheckupUser checkupUser) throws Exception
	{
		int resultNo = 0;
		TestItemResult testItemResult = new TestItemResult(); 
		
		// 결과값을 제외한 데이터 (건강검진계획번호, 사용자ID)
		testItemResult.setHeaCheckupPlanNo(checkupUser.getHeaCheckupPlanNo());
		testItemResult.setUserId(checkupUser.getUserId());
		testItemResult.setUpdateUserId(checkupUser.getUserId());
		
		// hea_checkup_org_test_item_no 가져오기 위한 데이터 (기관번호, 검진년도, 건강검진유형, 항목번호)
		testItemResult.setHeaCheckupOrgNo(checkupUser.getHeaCheckupOrgNo());
		testItemResult.setYear(checkupUser.getCheckupYear());
		testItemResult.setHeaCheckupTypeCd(checkupUser.getHeaCheckupTypeCd());
		
		// 건강검진계획번호와 사용자ID에 해당하는 데이터들을 삭제한다. (기관별 검사항목번호는 항목과 1대1 매칭이기에 제외)
		// 넣을려는 항목들을 알고 있기에 다 지우고 다시 넣는다.
		this.checkupResultMapper.deleteTestItemResult(testItemResult.getHeaCheckupPlanNo(), testItemResult.getUserId(), 0);
		
		// 선택 건강검진 검사항목 
		for(int i=0; i<checkupUser.getSelectedTestItemCd().length; i++)
		{
			testItemResult.setHeaTestItemCd(checkupUser.getSelectedTestItemCd()[i]);
			resultNo += this.checkupResultMapper.createTestItemResult(testItemResult);
		}
		
		List<CheckupOrgTestItem> checkupOrgTestItems = checkupOrgMapper.getCheckupOrgTestItems(
				ConstVal.CHECKUP_ORG_TEST_ITEM_OPTIONAL_YN_COMMON, 
				testItemResult.getHeaCheckupOrgNo(),
				testItemResult.getYear(),
				testItemResult.getHeaCheckupTypeCd(),
				"");
		// 공통 건강검진 검사항목 
		for(CheckupOrgTestItem checkupOrgTestItem : checkupOrgTestItems)
		{
		testItemResult.setHeaTestItemCd(checkupOrgTestItem.getHeaTestItemCd());
		resultNo += this.checkupResultMapper.createTestItemResult(testItemResult);
		}
		
		resultNo += this.checkupPlanMapper.updateCheckupReserve(checkupUser);
		return resultNo;
	}
	
	/**
	 * 건강검진계획별 기관별 항목 조회
	 * @param heaCheckupPlanNo 건강검진 계획 번호
	 * @param userId 사용자 ID
	 * @return 대상자목록
	 */
	public List<CheckupOrgTestItem> getCheckupPlanOrgTestItems(int heaCheckupPlanNo, int heaCheckupOrgNo, String userId) throws Exception
	{
		return this.checkupPlanMapper.getCheckupPlanOrgTestItems(heaCheckupPlanNo, heaCheckupOrgNo, userId);
	}
	
	/**
	 * 수검현황 조회
	 * @param heaCheckupPlanNo 건강검진 계획
	 * @param reserveYmd 예약일
	 * @param heaCheckupOrgNo 건강검진 기관
	 * @param checkupStatus 수검여부
	 * @return 수검현황 목록
	 * @throws Exception
	 */
	public List<CheckupStatus> getCheckupStatuses(int heaCheckupPlanNo, String reserveYmd, int[] heaCheckupOrgNos, String checkupStatus) throws Exception
	{
		return this.checkupPlanMapper.getCheckupStatuses(heaCheckupPlanNo, reserveYmd, heaCheckupOrgNos, checkupStatus);
	}
	
}
