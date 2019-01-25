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

package com.she.manage.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.manage.model.Dept;
import com.she.manage.service.DeptService;
import com.she.utils.RequestMapper;

/**
 * 부서 컨트롤러
 *
 */
@RestController
@RequestMapping("api/manage/user")
public class DeptController
{
	@Autowired
	private DeptService deptService;
	
	private RequestMapper requestMapper = new RequestMapper();
	
	/**
	 * 부서 조회
	 * @param parameter 검색조건
	 * @return 부서목록
	 * @throws Exception
	 */
	@GetMapping("/depts")
	public ResponseEntity<List<Dept>> getDepts(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		int processNo = map.containsKey("processNo")? Integer.parseInt(map.get("processNo").toString()):0;
		String deptCd = map.containsKey("deptCd")? map.get("deptCd").toString():"";
		String deptNm = map.containsKey("deptNm")? map.get("deptNm").toString():"";
		
		List<Dept> depts = this.deptService.getDepts(processNo, deptCd, deptNm);
		
		return ResponseEntity.ok().body(depts);
	}
	
	/**
	 * 부서 상세 조회
	 * @param deptCd 부서코드
	 * @return 부서
	 * @throws Exception
	 */
	@GetMapping("/dept/{deptCd}")
	public ResponseEntity<Dept> getDept(String deptCd) throws Exception
	{		
		Dept dept = this.deptService.getDept(deptCd);
		
		return ResponseEntity.ok().body(dept);
	}
}
