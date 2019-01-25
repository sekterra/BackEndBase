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

package com.she.health.checkup.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.CheckupOrgTestItem;
import com.she.health.model.CheckupPlan;
import com.she.health.model.CheckupPlanOrg;
import com.she.health.model.CheckupResult;
import com.she.health.model.CheckupStatus;
import com.she.health.model.CheckupUser;

/**
 * 건강검진 계획 맵퍼
 *
 */
@Mapper
@Repository("com.she.health.checkup.mapper.CheckupPlanMapper")
public interface CheckupPlanMapper
{
	/**
	 * 건강검진계획 조회
	 * @param checkupYear 검진년도
	 * @param startYmd 검진기간시작일
	 * @param endYmd 검진기간종료일
	 * @return 건강검진계획 목록
	 * @throws Exception
	 */
	public List<CheckupPlan> getCheckupPlans(
			@Param("checkupYear") String checkupYear,
			@Param("startYmd") String startYmd,
			@Param("endYmd") String endYmd) throws Exception;
	
	/**
	 * 건강검진계획 상세 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @return 건강검진계획
	 * @throws Exception
	 */
	public CheckupPlan getCheckupPlan(@Param("heaCheckupPlanNo") int heaCheckupPlanNo) throws Exception;
	
	/**
	 * 건강검진계획 생성
	 * @param checkupPlan 건강검진계획
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createCheckupPlan(CheckupPlan checkupPlan) throws Exception;
	
	/**
	 * 건강검진계획별 기관 생성
	 * @param checkupPlanOrg 건강검진계획별 기관
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createCheckupPlanOrg(CheckupPlanOrg checkupPlanOrg) throws Exception;
	
	/**
	 * 건강검진계획 수정
	 * @param checkupPlan 건강검진계획
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupPlan(CheckupPlan checkupPlan) throws Exception;
	
	/**
	 * 건강검진계획 삭제
	 * @param List<CheckupPlan> 건강검진계획 삭제 리스트 
	 * @return 삭제 행 수
	 * @throws Exception
	 */
	public int deleteCheckupPlan(CheckupPlan checkupPlan) throws Exception;
	
	/**
	 * 건강검진계획별 기관 삭제
	 * @param heaCheckupPlanNo
	 * @param heaCheckupOrgNo
	 * @return 삭제 행 수
	 * @throws Exception
	 */
	public int deleteCheckupPlanOrg(@Param("heaCheckupPlanNo")int heaCheckupPlanNo, @Param("heaCheckupOrgNo")int heaCheckupOrgNo) throws Exception;
	
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
			@Param("heaCheckupPlanNo") int heaCheckupPlanNo,
			@Param("processNo") int processNo,
			@Param("deptCd") String deptCd,
			@Param("userId") String userId,
			@Param("userNm") String userNm,
			@Param("notifyPlanYn") String notifyPlanYn,
			@Param("reserveYn") String reserveYn,
			@Param("reserveYmdStart") String reserveYmdStart,
			@Param("reserveYmdEnd") String reserveYmdEnd,
			@Param("heaCheckedOrgNos") int[] heaCheckedOrgNos,
			@Param("heaCheckupOrgNos") int[] heaCheckupOrgNos,
			@Param("statusYn") String statusYn) throws Exception;
	
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
			@Param("heaCheckupPlanNo") int heaCheckupPlanNo,
			@Param("processNo") int processNo,
			@Param("deptCd") String deptCd,
			@Param("userId") String userId,
			@Param("userNm") String userNm,
			@Param("prevYearCheckupUserYn") String prevYearCheckupUserYn,
			@Param("age") int age) throws Exception;
	
	/**
	 * 건강검진계획별 대상자 지정
	 * @param checkupUser 건강검진대상자
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createCheckupUser(CheckupUser checkupUser) throws Exception;
	
	/**
	 * 건강검진계획별 대상자 해제
	 * @param checkupUser 건강검진대상자
	 * @return 삭제 행 수
	 * @throws Exception
	 */
	public int deleteCheckupUser(CheckupUser checkupUser) throws Exception;
	
	/**
	 * 건강검진계획별 기관 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param standardYmd 기준날짜
	 * @return 건강검진계획별 기관 목록
	 * @throws Exception
	 */
	public List<CheckupPlanOrg> getCheckupPlanOrgs(
			@Param("heaCheckupPlanNo") int heaCheckupPlanNo,
			@Param("heaCheckupOrgNo") int heaCheckupOrgNo,
			@Param("standardYmd") String standardYmd) throws Exception;
	
	/**
	 * 건강검진계획별 기관일정 수정
	 * @param checkupPlanOrg 건강검진기관 일정
	 * @return 수정 행 수
	 * @throws Exception
	 */
	public int updateCheckupPlanOrg(CheckupPlanOrg checkupPlanOrg) throws Exception;
	
	/**
	 * 등록된 건강검진 계획별 사용자 예약 현황 목록 조회
	 * @param userId 사용자 ID
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @return 대상자목록
	 */
	public List<CheckupUser> getCheckupReserves(@Param("userId") String userId, @Param("heaCheckupPlanNo") int heaCheckupPlanNo) throws Exception;
	
	/**
	 * 월별 검진기관별 예약인원 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param heaCheckupOrgNo 건강검진기관번호
	 * @param yearMonth 기준년월
	 * @return 기관별예약현황
	 * @throws Exception
	 */
	public List<CheckupPlanOrg> getCheckupReserveOrgStatus(
			@Param("heaCheckupPlanNo") int heaCheckupPlanNo,
			@Param("heaCheckupOrgNo") int heaCheckupOrgNo, 
			@Param("yearMonth") String yearMonth) throws Exception;
	
	/**
	 * 건강검진계획별 기관별 항목 조회
	 * @param heaCheckupPlanNo 건강검진 계획 번호
	 * @param userId 사용자 ID
	 * @return 대상자목록
	 */
	public List<CheckupOrgTestItem> getCheckupPlanOrgTestItems(@Param("heaCheckupPlanNo") int heaCheckupPlanNo, @Param("heaCheckupOrgNo") int heaCheckupOrgNo, @Param("userId") String userId) throws Exception;
	
	/**
	 * 건강검진 사용자 예약
	 * @param CheckupResult
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupReserve(CheckupUser checkupUser) throws Exception;
	
	/**
	 * 수검현황 조회
	 * @param heaCheckupPlanNo 건강검진 계획
	 * @param reserveYmd 예약일
	 * @param heaCheckupOrgNo 건강검진 기관
	 * @param checkupStatus 수검여부
	 * @return 수검현황 목록
	 * @throws Exception
	 */
	public List<CheckupStatus> getCheckupStatuses(
			@Param("heaCheckupPlanNo") int heaCheckupPlanNo, @Param("reserveYmd") String reserveYmd,
			@Param("heaCheckupOrgNos") int[] heaCheckupOrgNos, @Param("checkupStatus") String checkupStatus) throws Exception;
}
