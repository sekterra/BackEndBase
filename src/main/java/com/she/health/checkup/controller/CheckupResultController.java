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

package com.she.health.checkup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.she.health.checkup.service.CheckupResultService;
import com.she.health.model.CheckupResult;
import com.she.health.model.CheckupResultDiag;
import com.she.health.model.CheckupUser;
import com.she.health.model.TestItemResult;
import com.she.utils.RequestMapper;

/**
 * 건강검진 결과 검색
 * 
 */
@RestController
@RequestMapping("api/hea/checkup")
public class CheckupResultController
{
	@Autowired
	private CheckupResultService checkupResultService;
	
	@Autowired
	private RequestMapper requestMapper;
	
	/**
	 * 건강검진결과 조회
	 * @param parameter 검색조건
	 * @return 건강검진결과목록
	 * @throws Exception 예외
	 */
	@GetMapping("/checkupresults")
	public ResponseEntity<List<CheckupResult>> getCheckupResults(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		String userId = map.containsKey("userId")? map.get("userId").toString():"";
		String checkupYear = map.containsKey("checkupYear")? map.get("checkupYear").toString():"";
		int heaCheckupPlanNo = map.containsKey("heaCheckupPlanNo")? Integer.parseInt(map.get("heaCheckupPlanNo").toString()):0; 
		String retirementYn = map.containsKey("retirementYn")? map.get("retirementYn").toString():"";
		String[] heaDiagnoseCds = this.requestMapper.convertObjectListAsStringArray(map.get("heaDiagnoseCds"));
		String heaDiseaseClassCd = map.containsKey("heaDiseaseClassCd")? map.get("heaDiseaseClassCd").toString():"";
		String heaDiseaseCd = map.containsKey("heaDiseaseCd")? map.get("heaDiseaseCd").toString():"";
		int[] heaCheckedOrgNos = this.requestMapper.convertObjectListAsIntArray(map.get("heaCheckedOrgNos"));
		String userNm = map.containsKey("userNm")? map.get("userNm").toString():"";
		
		List<CheckupResult> checkupResults = this.checkupResultService.getCheckupResults(
				userId,
				checkupYear, 
				heaCheckupPlanNo, 
				retirementYn, 
				heaDiagnoseCds, 
				heaDiseaseClassCd, 
				heaDiseaseCd, 
				heaCheckedOrgNos, 
				userNm);
		
		return ResponseEntity.ok().body(checkupResults);
	}
	
	/**
	 * 건강검진결과 상세 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param userId 사용자아이디
	 * @return 검진정보
	 * @throws Exception
	 */
	@GetMapping("/checkupresult/{heaCheckupPlanNo}/{userId}")
	public ResponseEntity<CheckupResult> getCheckupResult(@PathVariable int heaCheckupPlanNo, @PathVariable String userId) throws Exception
	{	
		CheckupResult checkupResult = this.checkupResultService.getCheckupResult(heaCheckupPlanNo, userId);
		
		return ResponseEntity.ok().body(checkupResult);
	}
	
	/**
	 * 건강검진진단결과 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param userId 사용자아이디
	 * @return 소견및판정정보
	 * @throws Exception
	 */
	@GetMapping("/checkupresultdiags")
	public ResponseEntity<List<CheckupResultDiag>> getCheckupResultDiags(@RequestParam HashMap<String, Object> parameter) throws Exception
	{		
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		int heaCheckupPlanNo = map.containsKey("heaCheckupPlanNo")? Integer.parseInt(map.get("heaCheckupPlanNo").toString()):0;
		String userId = map.containsKey("userId")? map.get("userId").toString():"";
		
		List<CheckupResultDiag> checkupResultDiags = this.checkupResultService.getCheckupResultDiags(heaCheckupPlanNo, userId);
		
		return ResponseEntity.ok().body(checkupResultDiags);
	}
	
	/**
	 * 건강검진항목별 결과 조회
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param userId 사용자아이디
	 * @param optionalYn 선택항목여부
	 * @return 검진항목 목록
	 * @throws Exception
	 */
	@GetMapping("/testitemresults")
	public ResponseEntity<List<TestItemResult>> getTestItemResults(@RequestParam HashMap<String, Object> parameter) throws Exception
	{		
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		int heaCheckupPlanNo = map.containsKey("heaCheckupPlanNo")? Integer.parseInt(map.get("heaCheckupPlanNo").toString()):0;
		String userId = map.containsKey("userId")? map.get("userId").toString():"";
		String optionalYn = map.containsKey("optionalYn")? map.get("optionalYn").toString():"";
		
		List<TestItemResult> testItemResults = this.checkupResultService.getTestItemResults(heaCheckupPlanNo, userId, optionalYn);
		
		return ResponseEntity.ok().body(testItemResults);
	}
	
	/**
	 * 건강검진결과 수정
	 * @param checkupResult 건강검진결과
	 * @return 수정행수
	 * @throws Exception
	 */
	@PutMapping("/checkupresult")
	public ResponseEntity<Integer> updateCheckupResult(@RequestBody CheckupResult checkupResult) throws Exception
	{
		checkupResult.setUpdateUserId("dev");
		Integer count = this.checkupResultService.updateCheckupResult(checkupResult);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진진단결과 등록
	 * @param checkupResultDiag 건강검진진단결과
	 * @return 등록행수
	 * @throws Exception
	 */
	@PostMapping("/checkupresultdiag")
	public ResponseEntity<Integer> createCheckupResultDiag(@RequestBody CheckupResultDiag checkupResultDiag) throws Exception
	{
		checkupResultDiag.setCreateUserId("dev");
		Integer count = this.checkupResultService.createCheckupResultDiag(checkupResultDiag);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진진단결과 삭제
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param userId 사용자아이디
	 * @param heaDiseaseCd 질환코드
	 * @return 삭제행수
	 * @throws Exception
	 */
	@DeleteMapping("/checkupresultdiag/{heaCheckupPlanNo}/{userId}/{heaDiseaseCd}")
	public ResponseEntity<Integer> deleteCheckupResultDiag(
			@PathVariable int heaCheckupPlanNo, 
			@PathVariable String userId, 
			@PathVariable String heaDiseaseCd) throws Exception
	{
		Integer count = this.checkupResultService.deleteCheckupResultDiag(heaCheckupPlanNo, userId, heaDiseaseCd);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진진단결과 삭제
	 * @param checkupResultDiags 삭제목록
	 * @return 삭제행수
	 * @throws Exception
	 */
	@DeleteMapping("/checkupresultdiags")
	public ResponseEntity<Integer> deleteCheckupResultDiags(@RequestBody List<CheckupResultDiag> checkupResultDiags) throws Exception
	{
		Integer count = this.checkupResultService.deleteCheckupResultDiags(checkupResultDiags);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진항목별 결과 등록
	 * @param testItemResult 건강검진항목별 결과
	 * @return 등록행수
	 * @throws Exception
	 */
	@PostMapping("/testitemresult")
	public ResponseEntity<Integer> createTestItemResult(@RequestBody TestItemResult testItemResult) throws Exception
	{
		testItemResult.setCreateUserId("dev");
		Integer count = this.checkupResultService.createTestItemResult(testItemResult);
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진항목별 결과 삭제
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param userId 사용자아이디
	 * @param heaCheckupOrgTestItemNo 기관별검사항목번호
	 * @return 삭제행수
	 * @throws Exception
	 */
	@DeleteMapping("/testitemresult/{heaCheckupPlanNo}/{userId}/{heaCheckupOrgTestItemNo}")
	public ResponseEntity<Integer> deleteTestItemResult(
			@PathVariable int heaCheckupPlanNo, 
			@PathVariable String userId, 
			@PathVariable int heaCheckupOrgTestItemNo) throws Exception
	{
		Integer count = this.checkupResultService.deleteTestItemResult(heaCheckupPlanNo, userId, heaCheckupOrgTestItemNo);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진항목별 결과 삭제
	 * @param testItemResults 삭제목록
	 * @return 삭제행수
	 * @throws Exception
	 */
	@DeleteMapping("/testitemresults")
	public ResponseEntity<Integer> deleteTestItemResults(@RequestBody List<TestItemResult> testItemResults) throws Exception
	{
		Integer count = this.checkupResultService.deleteTestItemResults(testItemResults);
		
		return ResponseEntity.ok().body(count); 
	}
	
	/**
	 * 건강검진결과 엑셀업로드
	 * @param heaCheckupPlanNo 건강검진계획번호
	 * @param upfile 업로드엑셀파일
	 * @return 업로드결과
	 * @throws Exception
	 */
	@PostMapping(path="/uploadexcelcheckupresult")
	public ResponseEntity<Map<String, Object>> uploadExcelCheckupResult(
			@RequestParam("file") MultipartFile upfile,
			@RequestParam("heaCheckupPlanNo") int heaCheckupPlanNo) throws Exception
	{		
		Map<String, Object> resultMap = this.checkupResultService.uploadExcelCheckupResult(heaCheckupPlanNo, upfile);
		
		return ResponseEntity.ok().body(resultMap);
	}
	
}
