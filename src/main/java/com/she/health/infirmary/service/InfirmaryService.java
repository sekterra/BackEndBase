package com.she.health.infirmary.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.she.health.drug.mapper.DrugMapper;
import com.she.health.infirmary.mapper.InfirmaryMapper;
import com.she.health.model.CheckupResult;
import com.she.health.model.Consult;
import com.she.health.model.InfirmaryUsage;
import com.she.health.model.Prescribe;
import com.she.health.model.Suspect;
import com.she.health.model.SuspectHist;
import com.she.utils.Methods;

/**
 * 건강관리실 기능 정의
 *
 */
@Service
public class InfirmaryService 
{
	@Autowired
	private InfirmaryMapper infirmaryMapper;
	
	@Autowired
	private DrugMapper drugMapper;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	/**
	 * 건강관리실 방문이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @return 건강관리실 방문이력 목록
	 * @throws Exception
	 */
	public List<InfirmaryUsage> getInfirmaryUsageHistorys(String userNm, String deptCd, String startDt, String endDt) throws Exception 
	{
		return infirmaryMapper.getInfirmaryUsageHistorys(userNm, deptCd, startDt, endDt);
	}
	
	/**
	 * 약품 처방이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @return 약품 처방이력 목록
	 * @throws Exception
	 */
	public List<Prescribe> getPrescribeHistorys(String userNm, String deptCd) throws Exception 
	{
		return infirmaryMapper.getPrescribeHistorys(userNm, deptCd);
	}
	
	/**
	 * 건강검진이력 조회
	 * @param userNm 사용자명
	 * @param deptCd 부서코드
	 * @return 건강검진이력목록
	 * @throws Exception
	 */
	public List<CheckupResult> getCheckupHistorys(String userNm, String deptCd, String startYmd, String endYmd, String heaCheckupClassCd) throws Exception 
	{
		return infirmaryMapper.getCheckupHistorys(userNm, deptCd, startYmd, endYmd, heaCheckupClassCd);
	}
	
	/**
	 * 관리대상 유소견자 조회
	 * @param 
	 * @return 관리대상 유소견자 목록
	 * @throws Exception
	 */
	public List<Suspect> getSuspectUsers() throws Exception 
	{
		return infirmaryMapper.getSuspectUsers();
	}
	
	/**
	 * 관리대상 유소견자팝업 조회(검진결과 목록)
	 * @param deptCd 부서코드
	 * @param userId 사번
	 * @param userNm 사용자명
	 * @param suspectYn 유소견자여부
	 * @return 관리대상 유소견자팝업 목록(검진결과 목록)
	 * @throws Exception
	 */
	public List<CheckupResult> getSuspectUserPopups(String deptCd, String userId, String userNm, String suspectYn) throws Exception 
	{
		return infirmaryMapper.getSuspectUserPopups(deptCd, userId, userNm, suspectYn);
	}
	
	/**
	 * 관리대상 유소견자 지정
	 * @param List<CheckupResult>
	 * @return Integer(수정행수)
	 * @throws Exception 예외
	 */
	@Transactional
	public Integer createSuspectUser(List<CheckupResult> checkupResults) throws Exception
	{
		int resultNo = 0;
		
		for(CheckupResult checkupResult : checkupResults)
		{
			SuspectHist suspectHist = new SuspectHist();
			suspectHist.setHeaCheckupPlanNo(checkupResult.getHeaCheckupPlanNo());
			suspectHist.setUserId(checkupResult.getUserId());
			suspectHist.setDeptCd(checkupResult.getDeptCd());
			suspectHist.setSuspectYn("Y");
			
			String userId = suspectHist.getUserId();
			
			Suspect suspect = new Suspect();
			suspect.setUserId(userId);
			suspect.setSuspectYn("Y");
			
			// 임시 로그인id
			suspectHist.setCreateUserId(Methods.getLoginUser().getUserId());
			// 유소견자 이력에 create
			resultNo += infirmaryMapper.createSuspectUserHist(suspectHist);
			// 유소견자 상세조회
			Suspect suspectTemp = infirmaryMapper.getSuspectUser(userId);
			// suspect가 없으면
			if(suspectTemp == null)
			{
				// 임시 로그인id
				suspect.setCreateUserId(Methods.getLoginUser().getUserId());
				infirmaryMapper.createSuspectUser(suspect);
			}
			else if(suspectTemp.getSuspectYn().equals("N"))
			{
				// 임시 로그인id
				suspect.setUpdateUserId(Methods.getLoginUser().getUserId());
				infirmaryMapper.updateSuspectUser(suspect);
			}
			
		}
		
		return resultNo;
	}
	
	/**
	 * 관리대상 유소견자 해제
	 * @param List<CheckupResult>
	 * @return Integer(수정행수)
	 * @throws Exception 예외
	 */
	@Transactional
	public Integer deleteSuspectUser(List<CheckupResult> checkupResults) throws Exception
	{
		int resultNo = 0;
		
		for(CheckupResult checkupResult : checkupResults)
		{
			
			SuspectHist suspectHist = new SuspectHist();
			suspectHist.setHeaCheckupPlanNo(checkupResult.getHeaCheckupPlanNo());
			suspectHist.setUserId(checkupResult.getUserId());
			suspectHist.setDeptCd(checkupResult.getDeptCd());
			suspectHist.setSuspectYn("N");
			
			String userId = suspectHist.getUserId();
			
			Suspect suspect = new Suspect();
			suspect.setUserId(userId);
			suspect.setSuspectYn("N");
			
			// 임시 로그인id
			suspectHist.setCreateUserId(Methods.getLoginUser().getUserId());
			// 유소견자 이력에 create
			resultNo += infirmaryMapper.createSuspectUserHist(suspectHist);
			// 유소견자 상세조회
			Suspect suspectTemp = infirmaryMapper.getSuspectUser(userId);
			// suspect가 Y로 있을때 update
			if(suspectTemp.getSuspectYn().equals("Y"))
			{
				// 임시 로그인id
				suspect.setUpdateUserId(Methods.getLoginUser().getUserId());
				infirmaryMapper.updateSuspectUser(suspect);
			}
		}
		
		return resultNo;
	}
	
	/**
	 * 유소견자 건강상담이력 조회
	 * @param userId 사번
	 * @param startYmd 기간
	 * @param endYmd 기간
	 * @return 건강상담이력 목록
	 * @throws Exception 예외
	 */
	public List<Consult> getConsults(String userId, String startYmd, String endYmd) throws Exception
	{
		return infirmaryMapper.getConsults(userId, startYmd, endYmd);
	}
	
	/**
	 * 유소견자 건강상담이력 상세 조회
	 * @param userId 사번
	 * @return 유소견자 건강상담이력 상세 조회
	 * @throws Exception 예외
	 */
	public Consult getConsult(int heaConsultNo) throws Exception
	{
		return infirmaryMapper.getConsult(heaConsultNo);
	}
	
	/**
	 * 유소견자 건강상담이력 신규 등록
	 * @param consult (유소견자)건강 상담
	 * @return heaConsultNo 건강상담번호
	 * @throws Exception 예외
	 */
	public int createConsult(Consult consult) throws Exception
	{
		// 임시 로그인id
		consult.setCreateUserId(Methods.getLoginUser().getUserId());
		this.infirmaryMapper.createConsult(consult);
		return consult.getHeaConsultNo();
	}
	
	/**
	 * 유소견자 건강상담이력 수정
	 * @param consult (유소견자)건강 상담
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	public int updateConsult(Consult consult) throws Exception
	{
		// 임시 로그인id
		consult.setUpdateUserId(Methods.getLoginUser().getUserId());
		return infirmaryMapper.updateConsult(consult);
	}
	
	/**
	 * 유소견자 건강상담 이력 삭제
	 * @param List<Consult>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	@Transactional
	public int deleteConsult(List<Consult> consults) throws Exception
	{
		int resultNo = 0;
		for(Consult consult : consults)
		{
			resultNo += infirmaryMapper.deleteConsult(consult);
		}
		return resultNo;
	}
	
	/**
	 * 건강관리실 이용현황 등록(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	@Transactional
	public int createInfirmaryUsage(InfirmaryUsage infirmaryUsage) throws Exception
	{
		List<Prescribe> prescribeList = infirmaryUsage.getPrescribeList();
		
		// 임시 로그인id
		infirmaryUsage.setCreateUserId(Methods.getLoginUser().getUserId());
		infirmaryMapper.createInfirmaryUsage(infirmaryUsage);
		int heaInfirmaryUsageNo = infirmaryUsage.getHeaInfirmaryUsageNo();
		
		for(Prescribe prescribe : prescribeList)
		{
			if(prescribe.getAmount() != 0)
			{
				prescribe.setHeaInfirmaryUsageNo(heaInfirmaryUsageNo);
				
				//임시로그인id
				prescribe.setCreateUserId(Methods.getLoginUser().getUserId());
				//약품처방 create
				drugMapper.createPrescribe(prescribe);
				
				//처방후, 현 재고량 update
				drugMapper.updateDrugAmountCurr(prescribe.getHeaDrugNo(), prescribe.getAmount());
			}
			
		}
		
		
		return heaInfirmaryUsageNo;
	}
	
	/**
	 * 건강관리실 이용현황 수정(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	@Transactional
	public int updateInfirmaryUsage(InfirmaryUsage infirmaryUsage) throws Exception
	{
		List<Prescribe> prescribeList = infirmaryUsage.getPrescribeList();
		
		// 임시 로그인id
		infirmaryUsage.setUpdateUserId(Methods.getLoginUser().getUserId());
		infirmaryMapper.updateInfirmaryUsage(infirmaryUsage);
		int heaInfirmaryUsageNo = infirmaryUsage.getHeaInfirmaryUsageNo();
		
		for(Prescribe prescribe : prescribeList)
		{
			prescribe.setHeaInfirmaryUsageNo(heaInfirmaryUsageNo);
			
			int amount = drugMapper.getAmount(heaInfirmaryUsageNo, prescribe.getHeaDrugNo());
			
			//약품 사용량 롤백
			drugMapper.rollbackAmount(prescribe.getHeaDrugNo(), amount);
			
			//약품처방 삭제
			drugMapper.deletePrescribe(heaInfirmaryUsageNo, prescribe.getHeaDrugNo());
			
			if(prescribe.getAmount() != 0)
			{
				//임시로그인id
				prescribe.setCreateUserId(Methods.getLoginUser().getUserId());
				//약품처방 create
				drugMapper.createPrescribe(prescribe);
			}
			
			//처방후, 현 재고량 update
			drugMapper.updateDrugAmountCurr(prescribe.getHeaDrugNo(), prescribe.getAmount());
			
		}
		
		
		return heaInfirmaryUsageNo;
	}
	
	/**
	 * 건강관리실 이용 상세조회
	 * @param heaInfirmaryUsageNo 건강관리실 이용번호
	 * @return InfirmaryUsage 건강관리실 이용
	 * @throws Exception 예외
	 */
	public InfirmaryUsage getHeaInfirmaryUsage(int heaInfirmaryUsageNo) throws Exception 
	{
		InfirmaryUsage infirmaryUsage = infirmaryMapper.getHeaInfirmaryUsage(heaInfirmaryUsageNo);
		infirmaryUsage.setPrescribeList(drugMapper.getDrugAmounts(infirmaryUsage.getHeaInfirmaryUsageNo()));
		
		return infirmaryUsage;
	}
	
	/**
	 * 건강관리실 이용 삭제
	 * @param List<InfirmaryUsage>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	@Transactional
	public int deleteInfirmaryUsage(List<InfirmaryUsage> infirmaryUsages) throws Exception
	{
		int resultNo = 0;
		for(InfirmaryUsage infirmaryUsage : infirmaryUsages)
		{
			resultNo += infirmaryMapper.deleteInfirmaryUsage(infirmaryUsage);
		}
		return resultNo;
	}
}
