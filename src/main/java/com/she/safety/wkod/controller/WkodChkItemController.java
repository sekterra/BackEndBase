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
package com.she.safety.wkod.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.safety.model.WkodChkItem;
import com.she.safety.wkod.service.WkodChkItemService;
import com.she.utils.RequestMapper;

/**
 * 작업허가서 항목
 *
 */
@RestController
public class WkodChkItemController 
{
	// TODO : queryString 변환을 위한 mapper 선언
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private WkodChkItemService wkodChkItemService;

	/**
	 * 작업허가서 항목 조회
	 * @param parameter (점검부서구분 코드, 항목명)
	 * @return 작업허가서 항목 목록
	 * @throws Exception
	 */
	@GetMapping("/api/saf/wkod/wkodChkItems")
	public ResponseEntity<List<WkodChkItem>> getWkodChkItems(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		String wkodKindCd = map.containsKey("wkodKindCd")? map.get("wkodKindCd").toString():"";
		String wkodDutyCd = map.containsKey("wkodDutyCd")? map.get("wkodDutyCd").toString():"";
		String chkItemNm = map.containsKey("chkItemNm")? map.get("chkItemNm").toString():"";
		
		List<WkodChkItem> wkodChkItem = wkodChkItemService.getWkodChkItems(wkodKindCd, wkodDutyCd, chkItemNm);
		return ResponseEntity.ok().body(wkodChkItem);
	}
	
	/**
	 * 작업허가서 항목 상세 조회
	 * @param chkItemNo 작업허가서 항목 코드
	 * @return 작업허가서 항목
	 * @throws Exception
	 */
	@GetMapping("/api/saf/wkod/wkodChkItem/{chkItemNo}")
	public ResponseEntity<WkodChkItem> getWkodChkItem(@PathVariable("chkItemNo") String chkItemNo) throws Exception 
	{
		WkodChkItem wkodChkItem = wkodChkItemService.getWkodChkItem(chkItemNo);
		return ResponseEntity.ok().body(wkodChkItem);
	}
	
	/**
	 * 작업허가서 항목 생성
	 * @param wkodChkItem 작업허가서 항목
	 * @return 작업허가서 항목 Key값
	 * @throws Exception
	 */
	@PostMapping("/api/saf/wkod/wkodChkItem")
	public ResponseEntity<String> createDisease(@RequestBody WkodChkItem wkodChkItem) throws Exception 
	{
		return ResponseEntity.ok().body(wkodChkItemService.createWkodChkItem(wkodChkItem));
	}
	
	/**
	 * 작업허가서 항목 수정
	 * @param wkodChkItem 작업허가서 항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PutMapping("/api/saf/wkod/wkodChkItem")
    public ResponseEntity<Integer> updateDisease(@RequestBody WkodChkItem wkodChkItem) throws Exception 
	{
        return ResponseEntity.ok().body(wkodChkItemService.updateWkodChkItem(wkodChkItem));
    }
}
