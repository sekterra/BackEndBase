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

import com.she.health.baseInfo.service.CheckupOrgService;
import com.she.health.model.CheckupOrg;
import com.she.health.model.CheckupOrgTestItem;
import com.she.utils.Methods;
import com.she.utils.RequestMapper;

/**
 * 건강검진기관
 *
 */
@RestController
public class CheckupOrgController 
{
	// TODO : queryString 변환을 위한 mapper 선언
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private CheckupOrgService checkupOrgService;
	
	/**
	 * 건강검진기관 조회
	 * @param parameter 검색조건
	 * @return 건강검진기관 목록
	 */
	@GetMapping("/api/hea/baseinfo/checkuporgs")
	public ResponseEntity<List<CheckupOrg>> getCheckupOrgs(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> map = this.requestMapper.convertAsParameter(parameter);		
		String useYn = map.containsKey("useYn")? map.get("useYn").toString():"";
		
		List<CheckupOrg> checkupOrgs = checkupOrgService.getCheckupOrgs(useYn);
		return ResponseEntity.ok().body(checkupOrgs);
	}
	
	/**
	 * 건강검진기관 상세 조회
	 * @param heaCheckupOrgNo
	 * @return 건강검진기관
	 * @throws Exception
	 */
	@GetMapping("/api/hea/baseinfo/checkuporg/{heaCheckupOrgNo}")
	public ResponseEntity<CheckupOrg> getCheckupOrgs(@PathVariable("heaCheckupOrgNo") String heaCheckupOrgNo) throws Exception 
	{
		CheckupOrg checkupOrg = checkupOrgService.getCheckupOrg(heaCheckupOrgNo);
		return ResponseEntity.ok().body(checkupOrg);
	}
	
	/**
	 * 건강검진기관 생성
	 * @param checkOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PostMapping("/api/hea/baseinfo/checkuporg")
	public ResponseEntity<Integer> createCheckupOrg(@RequestBody CheckupOrg checkupOrg) throws Exception 
	{
		checkupOrg.setCreateUserId("dev");
		return ResponseEntity.ok().body(checkupOrgService.createCheckupOrg(checkupOrg) > 0 ? checkupOrg.getHeaCheckupOrgNo() : 0);
	}
	
	/**
	 * 건강검진기관 수정
	 * @param checkOrg 건강검진기관
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PutMapping("/api/hea/baseinfo/checkuporg")
    public ResponseEntity<Integer> updateCheckupOrg(@RequestBody CheckupOrg checkupOrg) throws Exception 
	{
		checkupOrg.setUpdateUserId("dev");
        return ResponseEntity.ok().body(checkupOrgService.updateCheckupOrg(checkupOrg));
    }    
	
	/**
	 * 기관별 검사항목 조회
	 * @param parameter 검색조건
	 * @return 기관별 검사항목 목록
	 * @throws Exception
	 */
	@GetMapping("/api/hea/baseinfo/checkuporgtestitems")
	public ResponseEntity<List<CheckupOrgTestItem>> getCheckupOrgTestItems(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> map = requestMapper.convertAsParameter(parameter);
		
		// 선택 항목 여부
		String optionalYn = map.containsKey("optionalYn") ? map.get("optionalYn").toString() : "";		
		int heaCheckupOrgNo = map.containsKey("heaCheckupOrgNo") ? Integer.parseInt(map.get("heaCheckupOrgNo").toString()) : 0;
		String year = map.containsKey("year") ? map.get("year").toString() : "";
		year = (year.length() > 4 ? year.substring(0, 3) : year);
		String heaCheckupTypeCd = map.containsKey("heaCheckupTypeCd") ? map.get("heaCheckupTypeCd").toString() : "";
		String heaTestClassCd = map.containsKey("heaTestClassCd") ? map.get("heaTestClassCd").toString() : "";
		
		List<CheckupOrgTestItem> checkupTestItems = checkupOrgService.getCheckupOrgTestItems(optionalYn, heaCheckupOrgNo, year, heaCheckupTypeCd, heaTestClassCd);
		return ResponseEntity.ok().body(checkupTestItems);
	}
	
	/**
	 * 기관별 검사항목 생성
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PostMapping("/api/hea/baseinfo/checkuporgtestitem")
	public ResponseEntity<Integer> createCheckupOrgTestItem(@RequestBody CheckupOrgTestItem checkupOrgTestItem) throws Exception 
	{
		checkupOrgTestItem.setCreateUserId("dev");
		return ResponseEntity.ok().body(checkupOrgService.createCheckupOrgTestItem(checkupOrgTestItem));
	}
	
	/**
	 * 기관별 검사항목 수정
	 * @param checkupOrgTestItem 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PutMapping("/api/hea/baseinfo/checkuporgtestitem")
    public ResponseEntity<Integer> updateCheckupOrgTestItem(@RequestBody CheckupOrgTestItem checkupOrgTestItem) throws Exception 
	{
		checkupOrgTestItem.setUpdateUserId("dev");
        return ResponseEntity.ok().body(checkupOrgService.updateCheckupOrgTestItem(checkupOrgTestItem) > 0 ? checkupOrgTestItem.getHeaCheckupOrgTestItemNo() : 0);
    }    
	
	/**
	 * 기관별 검사항목 삭제
	 * @param List<CheckupOrgTestItem> 기관별 검사항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@DeleteMapping("/api/hea/baseinfo/checkuporgtestitem")
	public ResponseEntity<Integer> deleteCheckupOrgTestItem(@RequestBody List<CheckupOrgTestItem> CheckupOrgTestItems) throws Exception 
	{
		return ResponseEntity.ok().body(checkupOrgService.deleteCheckupOrgTestItem(CheckupOrgTestItems));
	}

}
