package com.she.health.drug.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.she.health.model.Drug;
import com.she.health.model.Prescribe;

@Mapper
@Repository("com.she.health.drug.mapper.DrugMapper")
public interface DrugMapper 
{
	
	/**
	 * 약품관리 조회
	 * @param 
	 * @return 약품관리 목록
	 * @throws Exception 예외
	 */
	public List<Drug> getDrugs(String useYn, String drugNm) throws Exception;
	
	/**
	 * 약품관리 상세조회
	 * @param heaDrugNo 약품번호
	 * @return Drug 약품
	 * @throws Exception 예외
	 */
	public Drug getDrug(int heaDrugNo) throws Exception;
	
	/**
	 * 약품관리 신규등록
	 * @param Drug 약품
	 * @return heaDrugNo 약품번호
	 * @throws Exception 예외
	 */
	public int createDrug(Drug drug) throws Exception;
	
	/**
	 * 약품관리 수정
	 * @param Drug 약품
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	public int updateDrug(Drug drug) throws Exception;
	
	/**
	 * 약품 처방이력 조회
	 * @param heaDrugNo 약품번호
	 * @param startDt 시작일
	 * @param endDt 종료일
	 * @return 약품 처방이력 목록
	 * @throws Exception 예외
	 */
	public List<Prescribe> getDrugPrescribes(int heaDrugNo, String startDt, String endDt) throws Exception;
	
	/**
	 * 약품처방 등록
	 * @param Prescribe 약품처방
	 * @return 등록행수
	 * @throws Exception 예외
	 */
	public int createPrescribe(Prescribe prescribe) throws Exception;
	
	/**
	 * 약품 현재 재고량 수정
	 * @param heaDrugNo 약품번호
	 * @param amount 사용량
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	public int updateDrugAmountCurr(int heaDrugNo, int amount) throws Exception;
	
	/**
	 * 특정 이용번호의 약품 전체 목록 + 사용량
	 * @param heaDrugNo 약품번호
	 * @return 처방현황 목록
	 * @throws Exception 예외
	 */
	public List<Prescribe> getDrugAmounts(int heaInfirmaryUsageNo) throws Exception;
	
	/**
	 * 약품 현재 재고량 롤백
	 * @param heaDrugNo 약품번호
	 * @param amount 사용량
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	public int rollbackAmount(int heaDrugNo, int amount) throws Exception;
	
	/**
	 * 약품 현재 재고량 조회
	 * @param heaDrugNo 약품번호
	 * @param amount 사용량
	 * @return amount 사용량
	 * @throws Exception 예외
	 */
	public int getAmount(int heaInfirmaryUsageNo, int heaDrugNo) throws Exception;
	
	/**
	 * 약품처방 삭제
	 * @param heaDrugNo 약품번호
	 * @param heaInfirmaryUsageNo 건강검진이용현황번호
	 * @param heaDrugNo 약품번호
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	public int deletePrescribe(int heaInfirmaryUsageNo, int heaDrugNo) throws Exception;
}
