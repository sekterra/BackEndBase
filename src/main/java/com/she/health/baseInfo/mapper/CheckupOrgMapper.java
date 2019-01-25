package com.she.health.baseInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.CheckupOrg;
import com.she.health.model.CheckupOrgTestItem;

@Mapper
@Repository("com.she.health.baseInfo.mapper.CheckupOrgMapper")
public interface CheckupOrgMapper 
{
	/**
	 * 건강검진기관 조회
	 * @param heaCheckupOrgNo 사용여부
	 * @return 건강검진기관 목록
	 * @throws Exception
	 */
	public List<CheckupOrg> getCheckupOrgs(@Param("useYn") String useYn) throws Exception;
	
	/**
	 * 건강검진기관 상세 조회
	 * @param heaCheckupOrgNo 건강검진기관번호
	 * @return 건강검진기관
	 * @throws Exception
	 */
	public CheckupOrg getCheckupOrg(@Param("heaCheckupOrgNo") String heaCheckupOrgNo) throws Exception;
	
	/**
	 * 건강검진기관 생성
	 * @param checkupOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createCheckupOrg(CheckupOrg checkupOrg) throws Exception;
	
	/**
	 * 건강검진기관 수정
	 * @param checkupOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupOrg(CheckupOrg checkupOrg) throws Exception;
	
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
			@Param("optionalYn") String optionalYn,
			@Param("heaCheckupOrgNo") int heaCheckupOrgNo,
			@Param("year") String year,
			@Param("heaCheckupTypeCd") String heaCheckupTypeCd,
			@Param("heaTestClassCd") String heaTestClassCd) throws Exception;
	
	/**
	 * 기관별 검사항목 수(count) 조회
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return (기관번호, 항목코드, 검진년도, 종합건강검진유형)에 따른 기관별 검사항목 데이터 수
	 * @throws Exception
	 */
	public int getCheckupOrgTestItemCount(CheckupOrgTestItem checkupOrgTestItem) throws Exception;
	
	/**
	 * 기관별 검사항목 생성
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createCheckupOrgTestItem(CheckupOrgTestItem checkupOrgTestItem) throws Exception;
	
	/**
	 * 기관별 검사항목 수정
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupOrgTestItem(CheckupOrgTestItem checkupOrgTestItem) throws Exception;

	/**
	 * 기관별 검사항목 삭제
	 * @param List<CheckupOrgTestItem> 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int deleteCheckupOrgTestItem(CheckupOrgTestItem checkupOrgTestItem) throws Exception;

}
