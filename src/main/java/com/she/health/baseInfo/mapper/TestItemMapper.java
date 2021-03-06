package com.she.health.baseInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.CheckupTestItem;
import com.she.health.model.TestItem;

@Mapper
@Repository("com.she.health.baseInfo.mapper.TestItemMapper")
public interface TestItemMapper 
{
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
	public List<TestItem> getTestItems(
			@Param("heaTestClassCd") String heaTestClassCd, 
			@Param("heaCheckupOrgNo") int heaCheckupOrgNo, 
			@Param("year") String year, 
			@Param("heaCheckupTypeCd") String heaCheckupTypeCd,
			@Param("useYn") String useYn,
			@Param("optionalYn") String optionalYn,
			@Param("heaTestItemNm") String heaTestItemNm
			) throws Exception;
	
	/**
	 * 건강검진항목 상세 조회
	 * @param heaTestClassCd
	 * @return 건강검진항목
	 * @throws Exception
	 */
	public TestItem getTestItem(@Param("heaTestItemCd") String heaTestItemCd) throws Exception;
	
	/**
	 * 건강검진항목 생성
	 * @param testItem 건강검진항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createTestItem(TestItem testItem) throws Exception;
	
	/**
	 * 건강검진항목 수정
	 * @param testItem 건강검진항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateTestItem(TestItem testItem) throws Exception;
	
	/**
	 * 건강검진 분류별 검사항목 조회
	 * @param heaCheckupClassCd 검사 분류 코드
	 * @param heaCheckupTypeCd 건강검진유형 코드
	 * @return 건강검진 분류별 검사항목 목록
	 * @throws Exception
	 */
	public List<CheckupTestItem> getCheckupTestItems(@Param("heaCheckupClassCd") String heaCheckupClassCd, @Param("heaCheckupTypeCd")String heaCheckupTypeCd) throws Exception;
	
	/**
	 * 건강검진 분류별 검사항목 수(count) 조회
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return (건강검진분류코드, 건강검진유형, 검사항목코드)에 따른 건강검진 분류별 검사항목 데이터 수
	 * @throws Exception
	 */
	public int getCheckupTestItemCount(CheckupTestItem checkupTestItem) throws Exception;
	
	/**
	 * 건강검진 분류별 검사항목 생성
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createCheckupTestItem(CheckupTestItem checkupTestItem) throws Exception;
	
	/**
	 * 건강검진 분류별 검사항목 수정
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateCheckupTestItem(CheckupTestItem checkupTestItem) throws Exception;
	
	/**
	 * 건강검진 분류별 검사항목 삭제
	 * @param List<CheckupTestItem> 건강검진 분류별 검사항목 삭제 리스트
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int deleteCheckupTestItem(CheckupTestItem checkupTestItem) throws Exception;

}
