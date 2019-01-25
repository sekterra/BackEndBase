package com.she.health.infirmary.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.health.infirmary.service.InfirmaryService;
import com.she.health.model.CheckupResult;
import com.she.health.model.Consult;
import com.she.health.model.InfirmaryUsage;
import com.she.health.model.Prescribe;
import com.she.health.model.Suspect;
import com.she.utils.Methods;
import com.she.utils.RequestMapper;

/**
 * 건강관리실메뉴
 * 
 */
@RestController
@RequestMapping("/api/hea/infirmary")
public class InfirmaryController
{
	@Autowired
	private InfirmaryService infirmaryService;
	
	@Autowired
	private RequestMapper requestMapper;
	
	/**
	 * 건강관리실 방문이력 조회
	 * @param parameter 검색조건
	 * @return 건강관리실 방문이력 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/infirmaryusagehistorys")
	public ResponseEntity<List<InfirmaryUsage>> getInfirmaryUsageHistorys(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		String userNm = convertedParameter.containsKey("userNm") ? convertedParameter.get("userNm").toString() : "";
		String deptCd = convertedParameter.containsKey("deptCd") ? convertedParameter.get("deptCd").toString() : "";
		String[] duration = this.requestMapper.convertObjectListAsStringArray(convertedParameter.get("duration"));
		String startDt = "";
		String endDt = "";
		
		if(duration != null && duration.length == 2)
		{
			startDt = duration[0];
			endDt = duration[1];
		}
		
		List<InfirmaryUsage> infirmaryUsageList = infirmaryService.getInfirmaryUsageHistorys(userNm, deptCd, startDt, endDt);
		return ResponseEntity.ok().body(infirmaryUsageList);
	}
	
	/**
	 * 약품 처방이력 조회
	 * @param parameter 검색조건
	 * @return 약품 처방이력 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/prescribehistorys")
	public ResponseEntity<List<Prescribe>> getPrescribeHistorys(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		String userNm = convertedParameter.containsKey("userNm") ? convertedParameter.get("userNm").toString() : "";
		String deptCd = convertedParameter.containsKey("deptCd") ? convertedParameter.get("deptCd").toString() : "";
		List<Prescribe> prescribeList = infirmaryService.getPrescribeHistorys(userNm, deptCd);
		return ResponseEntity.ok().body(prescribeList);
	}
	
	/**
	 * 건강검진이력 조회
	 * @param parameter 검색조건
	 * @return 건강검진이력 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/checkuphistorys")
	public ResponseEntity<List<CheckupResult>> getCheckupHistorys(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		String userNm = convertedParameter.containsKey("userNm") ? convertedParameter.get("userNm").toString() : "";
		String deptCd = convertedParameter.containsKey("deptCd") ? convertedParameter.get("deptCd").toString() : "";
		
		//보건 홈>건강검진 이력
		String[] heaCheckedPeriod = this.requestMapper.convertObjectListAsStringArray(convertedParameter.get("heaCheckedPeriod"));
		String startYmd = "";
		String endYmd = "";
		if(heaCheckedPeriod != null && heaCheckedPeriod.length == 2)
		{
			startYmd = heaCheckedPeriod[0];
			endYmd = heaCheckedPeriod[1];
		}
		String heaCheckupClassCd = convertedParameter.containsKey("heaCheckupClassCd") ? convertedParameter.get("heaCheckupClassCd").toString() : "";
		List<CheckupResult> checkupResultList = infirmaryService.getCheckupHistorys(userNm, deptCd, startYmd, endYmd, heaCheckupClassCd);
		return ResponseEntity.ok().body(checkupResultList);
	}
	
	/**
	 * 관리대상 유소견자 조회
	 * @param
	 * @return 관리대상 유소견자 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/suspectusers")
	public ResponseEntity<List<Suspect>> getSuspectUsers() throws Exception 
	{
		List<Suspect> suspectUserList = infirmaryService.getSuspectUsers();
		return ResponseEntity.ok().body(suspectUserList);
	}
	
	/**
	 * 관리대상 유소견자 지정 목록 조회
	 * @param 
	 * @return 관리대상 유소견자 지정 목록 조회
	 * @throws Exception 예외
	 */
	@GetMapping("/suspectuserpopups")
	public ResponseEntity<List<CheckupResult>> getSuspectUserPopups(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		String deptCd = convertedParameter.containsKey("deptCd") ? convertedParameter.get("deptCd").toString() : "";
		String userId = convertedParameter.containsKey("userId") ? convertedParameter.get("userId").toString() : "";
		String userNm = convertedParameter.containsKey("userNm") ? convertedParameter.get("userNm").toString() : "";
		String suspectYn = convertedParameter.containsKey("suspectYn") ? convertedParameter.get("suspectYn").toString() : "";
		List<CheckupResult> checkupResultList = infirmaryService.getSuspectUserPopups(deptCd, userId, userNm, suspectYn);
		return ResponseEntity.ok().body(checkupResultList);
	}
	
	/**
	 * 관리대상 유소견자 지정
	 * @param List<CheckupResult>
	 * @return 오류여부
	 * @throws Exception 예외
	 */
	@DeleteMapping("/createsuspectuser")
	public ResponseEntity<Integer> createSuspectUser(@RequestBody List<CheckupResult> checkupResults) throws Exception
	{
		return ResponseEntity.ok().body(infirmaryService.createSuspectUser(checkupResults));
	}
	
	/**
	 * 관리대상 유소견자 해제
	 * @param List<CheckupResult>
	 * @return 오류여부
	 * @throws Exception 예외
	 */
	@DeleteMapping("/deletesuspectuser")
	public ResponseEntity<Integer> deleteSuspectUser(@RequestBody List<CheckupResult> checkupResults) throws Exception
	{
		return ResponseEntity.ok().body(infirmaryService.deleteSuspectUser(checkupResults));
	}
	
	/**
	 * 유소견자 건강상담이력 조회
	 * @param userId 사용자아이디
	 * @return 유소견자 건강상담이력 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/consults")
	public ResponseEntity<List<Consult>> getConsults(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		String userId = convertedParameter.containsKey("userId") ? convertedParameter.get("userId").toString() : "";
		String[] visitPeriod = this.requestMapper.convertObjectListAsStringArray(convertedParameter.get("visitPeriod"));
		String startYmd = "";
		String endYmd = "";
		if(visitPeriod != null && visitPeriod.length == 2)
		{
			startYmd = visitPeriod[0];
			endYmd = visitPeriod[1];
		}
		List<Consult> consultList = infirmaryService.getConsults(userId, startYmd, endYmd);
		return ResponseEntity.ok().body(consultList);
	}
	
	/**
	 * 유소견자 건강상담이력 상세 조회
	 * @param heaConsultNo 건강상담번호
	 * @return 유소견자 건강상담이력 상세 조회
	 * @throws Exception 예외
	 */
	@GetMapping("/consult/{heaConsultNo}")
	public ResponseEntity<Consult> getConsult(@PathVariable("heaConsultNo") int heaConsultNo) throws Exception 
	{
		Consult consult = infirmaryService.getConsult(heaConsultNo);
		return ResponseEntity.ok().body(consult);
	}
	
	/**
	 * 유소견자 건강상담이력 신규 등록
	 * @param consult (유소견자)건강 상담
	 * @return heaConsultNo 건강상담번호
	 * @throws Exception 예외
	 */
	@PostMapping("/consult")
	public ResponseEntity<Integer> createConsult(@RequestBody Consult consult) throws Exception 
	{
		return ResponseEntity.ok().body(infirmaryService.createConsult(consult));
	}
	
	/**
	 * 유소견자 건강상담이력 수정
	 * @param consult (유소견자)건강 상담
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	@PutMapping("/consult")
	public ResponseEntity<Integer> updateConsult(@RequestBody Consult consult) throws Exception 
	{
		return ResponseEntity.ok().body(infirmaryService.updateConsult(consult));
	}
	
	/**
	 * 유소견자 건강상담 이력 삭제
	 * @param List<Consult>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	@DeleteMapping("/consult")
	public ResponseEntity<Integer> deleteConsult(@RequestBody List<Consult> consults) throws Exception 
	{
		return ResponseEntity.ok().body(infirmaryService.deleteConsult(consults));
	}
	
	/**
	 * 건강관리실 이용현황 등록(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	@PostMapping("/infirmaryusage")
	public ResponseEntity<Integer> createInfirmaryUsage(@RequestBody InfirmaryUsage infirmaryUsage) throws Exception
	{
		return ResponseEntity.ok().body(infirmaryService.createInfirmaryUsage(infirmaryUsage));
	}
	
	/**
	 * 건강관리실 이용현황 등록(건강관리실 일반업무)
	 * @param infirmaryUsage
	 * @return 건강관리실 이용현황번호
	 * @throws Exception 예외
	 */
	@PutMapping("/infirmaryusage")
	public ResponseEntity<Integer> updateInfirmaryUsage(@RequestBody InfirmaryUsage infirmaryUsage) throws Exception
	{
		return ResponseEntity.ok().body(infirmaryService.updateInfirmaryUsage(infirmaryUsage));
	}
	
	/**
	 * 건강관리실 이용 상세조회
	 * @param heaInfirmaryUsageNo 건강관리실 이용번호
	 * @return InfirmaryUsage 건강관리실 이용
	 * @throws Exception 예외
	 */
	@GetMapping("/infirmaryusage/{heaInfirmaryUsageNo}")
	public ResponseEntity<InfirmaryUsage> getHeaInfirmaryUsage(@PathVariable("heaInfirmaryUsageNo") int heaInfirmaryUsageNo) throws Exception 
	{
		InfirmaryUsage infirmaryUsage = infirmaryService.getHeaInfirmaryUsage(heaInfirmaryUsageNo);
		return ResponseEntity.ok().body(infirmaryUsage);
	}
	
	/**
	 * 건강관리실 이용 삭제
	 * @param List<InfirmaryUsage>
	 * @return 삭제행수
	 * @throws Exception 예외
	 */
	@DeleteMapping("/infirmaryusage")
	public ResponseEntity<Integer> deleteInfirmaryUsage(@RequestBody List<InfirmaryUsage> infirmaryUsages) throws Exception 
	{
		return ResponseEntity.ok().body(infirmaryService.deleteInfirmaryUsage(infirmaryUsages));
	}
}
