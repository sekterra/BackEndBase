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
package com.she.health.baseInfo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.health.baseInfo.service.TestItemService;
import com.she.health.model.CheckupTestItem;
import com.she.health.model.TestItem;
import com.she.utils.ConstVal;
import com.she.utils.RequestMapper;

/**
 * 건강검진항목
 *
 */
@RestController
public class TestItemController 
{
	// TODO : queryString 변환을 위한 mapper 선언
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private TestItemService testItemService;
	
	/**
	 * 건강검진항목 조회
	 * @param parameter (검사 분류 코드, 건강검진기관 번호, 검진년도, 종합건강검진유형, 사용 유무, 공통 선택 유무, 검사항목명)
	 * @return 건강검진항목 목록
	 * @throws Exception
	 */
	@GetMapping("/api/hea/baseinfo/testitems")
	public ResponseEntity<List<TestItem>> getTestItems(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> map = requestMapper.convertAsParameter(parameter);
		
		// 검사 분류 코드
		String heaTestClassCd = map.containsKey("heaTestClassCd") ? map.get("heaTestClassCd").toString() : "";
		// 건강검진기관 번호
		int heaCheckupOrgNo = map.containsKey("heaCheckupOrgNo") ? Integer.parseInt(map.get("heaCheckupOrgNo").toString()) : 0;
		// 검진년도
		String year = map.containsKey("year") ? map.get("year").toString() : "";
		// 종합건강검진유형
		String heaCheckupTypeCd = map.containsKey("heaCheckupTypeCd") ? map.get("heaCheckupTypeCd").toString() : "";
		// 사용 유무
		String useYn = map.containsKey("useYn") ? map.get("useYn").toString() : "";
		// 공통 선택 유무
		String optionalYn = map.containsKey("optionalYn") ? map.get("optionalYn").toString() : "";
		// 검사항목명
		String heaTestItemNm = map.containsKey("heaTestItemNm") ? map.get("heaTestItemNm").toString() : "";
		
		List<TestItem> testItem = testItemService.getTestItems(heaTestClassCd, heaCheckupOrgNo, year, heaCheckupTypeCd, useYn, optionalYn, heaTestItemNm);
		return ResponseEntity.ok().body(testItem);
	}
	
	/**
	 * 건강검진항목 상세 조회
	 * @param heaTestClassCd
	 * @return 건강검진항목
	 * @throws Exception
	 */
	@GetMapping("/api/hea/baseinfo/testitem/{heaTestItemCd}")
	public ResponseEntity<TestItem> getTestItem(@PathVariable("heaTestItemCd") String heaTestItemCd) throws Exception 
	{		
		TestItem testItem = testItemService.getTestItem(heaTestItemCd);
		return ResponseEntity.ok().body(testItem);
	}
	
	/**
	 * 건강검진항목 생성
	 * @param testItem 건강검진항목
	 * @return heaTestItemCd
	 * @throws Exception
	 */
	@PostMapping("/api/hea/baseinfo/testitem")
	public ResponseEntity<String> createTestItem(@RequestBody TestItem testItem) throws Exception 
	{
		testItem.setCreateUserId("dev");
		int resultNo = testItemService.createTestItem(testItem);
		return ResponseEntity.ok().body(testItem.getHeaTestItemCd());
	}
	
	/**
	 * 건강검진항목 수정
	 * @param testItem 건강검진항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PutMapping("/api/hea/baseinfo/testitem")
    public ResponseEntity<Integer> updateTestItem(@RequestBody TestItem testItem) throws Exception 
	{
		testItem.setUpdateUserId("dev");
        return ResponseEntity.ok().body(testItemService.updateTestItem(testItem));
    }
	
	/**
	 * 건강검진 분류별 검사항목 조회
	 * @param parameter (검사 분류 코드, 건강검진유형 코드)
	 * @return 건강검진 분류별 검사항목 목록
	 * @throws Exception
	 */
	@GetMapping("/api/hea/baseinfo/checkuptestitems")
	public ResponseEntity<List<CheckupTestItem>> getCheckupTestItems(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> map = requestMapper.convertAsParameter(parameter);
		
		// 검진 분류 코드
		String heaCheckupClassCd = map.containsKey("heaCheckupClassCd") ? parameter.get("heaCheckupClassCd").toString() : "";
		// 건강검진유형 코드
		String heaCheckupTypeCd = map.containsKey("heaCheckupTypeCd") ? parameter.get("heaCheckupTypeCd").toString() : ConstVal.CODE_MASTER_HEA_CHECKUP_TYPE_NON;
		
		List<CheckupTestItem> checkupTestItems = testItemService.getCheckupTestItems(heaCheckupClassCd, heaCheckupTypeCd);
		return ResponseEntity.ok().body(checkupTestItems);
	}
	
	/**
	 * 건강검진 분류별 검사항목 생성
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return CheckupTestItem
	 * @throws Exception
	 */
	@PostMapping("/api/hea/baseinfo/checkuptestitem")
	public ResponseEntity<CheckupTestItem> createCheckupTestItem(@RequestBody CheckupTestItem checkupTestItem) throws Exception 
	{
		checkupTestItem.setCreateUserId("dev");
		checkupTestItem.setHeaCheckupTypeCd(ConstVal.CODE_MASTER_HEA_CHECKUP_TYPE_NON);
		testItemService.createCheckupTestItem(checkupTestItem);
		
		return ResponseEntity.ok().body(checkupTestItem);
	}
	
	/**
	 * 건강검진 분류별 검사항목 수정
	 * @param checkupTestItem 건강검진 분류별 검사항목
	 * @return CheckupTestItem
	 * @throws Exception
	 */
	@PutMapping("/api/hea/baseinfo/checkuptestitem")
    public ResponseEntity<CheckupTestItem> updateCheckupTestItem(@RequestBody CheckupTestItem checkupTestItem) throws Exception 
	{
		checkupTestItem.setUpdateUserId("dev");
		checkupTestItem.setHeaCheckupTypeCd(ConstVal.CODE_MASTER_HEA_CHECKUP_TYPE_NON);
		testItemService.updateCheckupTestItem(checkupTestItem);
        return ResponseEntity.ok().body(checkupTestItem);
    }    
	
	/**
	 * 건강검진 분류별 검사항목 삭제
	 * @param List<CheckupTestItem> 건강검진 분류별 검사항목 삭제 리스트
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@DeleteMapping("/api/hea/baseinfo/checkuptestitem")
	public ResponseEntity<Integer> deleteCheckupTestItem(@RequestBody List<CheckupTestItem> checkupTestItems) throws Exception 
	{
		return ResponseEntity.ok().body(testItemService.deleteCheckupTestItem(checkupTestItems));
	}

}
