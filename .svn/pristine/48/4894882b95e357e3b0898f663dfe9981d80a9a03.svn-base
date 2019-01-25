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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.health.baseInfo.service.InterviewItemService;
import com.she.health.model.InterviewItem;
import com.she.utils.ConstVal;
import com.she.utils.Methods;
import com.she.utils.RequestMapper;

/**
 * 문진항목
 *
 */
@RestController
@RequestMapping("api/hea/baseinfo")
public class InterviewItemController
{
	@Autowired
	private InterviewItemService interviewItemService;
	
	@Autowired
	private RequestMapper requestMapper;
	
	/**
	 * 문진항목 조회
	 * @param parameter 검색조건
	 * @return 문진항목 목록
	 * @throws Exception
	 */
	@GetMapping("/interviewitems")
	public ResponseEntity<List<InterviewItem>> getInterviewItems(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		String useYn = map.containsKey("useYn")? map.get("useYn").toString():"";
		
		List<InterviewItem> interviewItems = this.interviewItemService.getInterviewItems(useYn);
		
		return ResponseEntity.ok().body(interviewItems);
	}
	
	/**
	 * 문진항목 상제 조회
	 * @param heaInteItemCd 문진항목코드
	 * @return 문진항목
	 * @throws Exception
	 */
	@GetMapping("/interviewitem/{heaInteItemCd}")
	public ResponseEntity<InterviewItem> getInterviewItem(@PathVariable String heaInteItemCd) throws Exception
	{
		return ResponseEntity.ok().body(this.interviewItemService.getInterviewItem(heaInteItemCd));
	}
	
	/**
	 * 문진항목 생성
	 * @param interviewItem 문진항목
	 * @return 문진항목코드
	 * @throws Exception
	 */
	@PostMapping("/interviewitem")
	public ResponseEntity<String> createInterviewItem(@RequestBody InterviewItem interviewItem) throws Exception
	{
		interviewItem.setCreateUserId(Methods.getLoginUser().getUserId());
		return ResponseEntity.ok().body(this.interviewItemService.createInterviewItem(interviewItem));
	}
	
	/**
	 * 문진항목 수정
	 * @param interviewItem 문진항목
	 * @return 수정행수
	 * @throws Exception
	 */
	@PutMapping("/interviewitem")
	public ResponseEntity<Integer> updateInterviewItem(@RequestBody InterviewItem interviewItem) throws Exception
	{
		interviewItem.setUpdateUserId(Methods.getLoginUser().getUserId());
		return ResponseEntity.ok().body(this.interviewItemService.updateInterviewItem(interviewItem));
	}
}
