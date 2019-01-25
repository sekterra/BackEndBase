package com.she.health.infirmary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.she.health.model.CheckupResult;
import com.she.health.model.Consult;
import com.she.health.model.Drug;
import com.she.health.model.InfirmaryUsage;
import com.she.health.model.Prescribe;
import com.she.health.model.Suspect;
import com.she.health.model.SuspectHist;

@Mapper
@Repository("com.she.health.infirmary.mapper.InfirmaryMapper")
public interface InfirmaryMapper
{
	/**
	 * 건강관리실 방문이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @param startDt 기간검색 시작일
	 * @param endDt 기간검색 종료일
	 * @return 건강관리실 방문이력 목록
	 * @throws Exception
	 */
	public List<InfirmaryUsage> getInfirmaryUsageHistorys(String userNm, String deptCd, String startDt, String endDt) throws Exception;
	
	/**
	 * 약품 처방이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @return 약품 처방이력 목록
	 * @throws Exception
	 */
	public List<Prescribe> getPrescribeHistorys(String userNm, String deptCd) throws Exception;
	
	/**
	 * 건강검진이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @return 건강검진이력목록
	 * @throws Exception
	 */
	public List<CheckupResult> getCheckupHistorys(String userNm, String deptCd, String startYmd, String endYmd, String heaCheckupClassCd) throws Exception;
	
	/**
	 * 관리대상 유소견자 조회
	 * @param 
	 * @return 관리대상 유소견자 목록
	 * @throws Exception
	 */
	public List<Suspect> getSuspectUsers() throws Exception;
	
	/**
	 * 관리대상 유소견자 상세조회
	 * @param userId 사용자명
	 * @return 유소견자 상세조회
	 * @throws Exception
	 */
	public Suspect getSuspectUser(String userId) throws Exception;
	
	/**
	 * 관리대상 유소견자 추가
	 * @param Suspect
	 * @return 추가행수
	 * @throws Exception
	 */
	public Integer createSuspectUser(Suspect suspect) throws Exception;
	
	/**
	 * 관리대상 유소견자 수정
	 * @param Suspect
	 * @return 수정행수
	 * @throws Exception
	 */
	public Integer updateSuspectUser(Suspect suspect) throws Exception;
	
	/**
	 * 관리대상 유소견자팝업 조회(검진결과 목록)
	 * @param deptCd 부서코드
	 * @param userId 사번
	 * @param userNm 사용자명
	 * @param suspectYn 유소견자여부
	 * @return 관리대상 유소견자팝업 목록(검진결과 목록)
	 * @throws Exception
	 */
	public List<CheckupResult> getSuspectUserPopups(String deptCd, String userId, String userNm, String suspectYn) throws Exception;
	
	/**
	 * 관리대상 유소견자 이력 추가
	 * @param SuspectHist
	 * @return 추가행수
	 * @throws Exception
	 */
	public Integer createSuspectUserHist(SuspectHist suspectHist) throws Exception;
	
	/**
	 * 유소견자 건강상담이력 조회
	 * @param userId 사용자명
	 * @param startYmd 기간
	 * @param endYmd 기간
	 * @return 유소견자 건강상담이력 목록
	 * @throws Exception
	 */
	public List<Consult> getConsults(String userId, String startYmd, String endYmd) throws Exception;
	
	/**
	 * 유소견자 건강상담이력 상세 조회
	 * @param heaConsultNo 건강상담번호
	 * @return Consult
	 * @throws Exception
	 */
	public Consult getConsult(int heaConsultNo) throws Exception;
	
	/**
	 * 유소견자 건강상담이력 신규 등록
	 * @param consult (유소견자)건강 상담
	 * @return heaConsultNo 건강상담번호
	 * @throws Exception 예외
	 */
	public int createConsult(Consult consult) throws Exception;
	
	/**
	 * 유소견자 건강상담이력 수정
	 * @param consult (유소견자)건강 상담
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	public int updateConsult(Consult consult) throws Exception;
	
	/**
	 * 유소견자 건강상담 이력 삭제
	 * @param List<Consult>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	public int deleteConsult(Consult consult) throws Exception;
	
	/**
	 * 건강관리실 이용현황 등록(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	public int createInfirmaryUsage(InfirmaryUsage infirmaryUsage) throws Exception;
	
	/**
	 * 건강관리실 이용현황 수정(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	public int updateInfirmaryUsage(InfirmaryUsage infirmaryUsage) throws Exception;
	
	/**
	 * 건강관리실 이용 상세조회
	 * @param heaInfirmaryUsageNo 건강관리실 이용번호
	 * @return InfirmaryUsage 건강관리실 이용
	 * @throws Exception 예외
	 */
	public InfirmaryUsage getHeaInfirmaryUsage(int heaInfirmaryUsageNo) throws Exception;
	
	/**
	 * 건강관리실 이용 삭제
	 * @param List<InfirmaryUsage>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	public int deleteInfirmaryUsage(InfirmaryUsage infirmaryUsage) throws Exception;
}
