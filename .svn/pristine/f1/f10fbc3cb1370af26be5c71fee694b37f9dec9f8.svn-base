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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.she.manage.model.Process;
import com.she.manage.service.ProcessService;
import com.she.utils.RequestMapper;

/**
 * 작업공정 컨트롤러
 *
 */
@RestController
@RequestMapping("api/manage/process")
public class ProcessController
{
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private ProcessService processService;
	
	/**
	 * 작업공정 조회
	 * @param parameter 검색조건
	 * @return 작업공정목록
	 * @throws Exception
	 */
	@GetMapping("/processes")
	public ResponseEntity<List<Process>> getProcesses(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap<String, Object> map = requestMapper.convertAsParameter(parameter);
		// 사용여부
		String useYn = map.containsKey("useYn") ? map.get("useYn").toString() : "";
		// 유해인자 코드
		String heaHazardCd = map.containsKey("heaHazardCd") ? map.get("heaHazardCd").toString() : "";
		
		List<Process> processes = this.processService.getProcesses(useYn, heaHazardCd);
		
		return ResponseEntity.ok().body(processes);
	}
	
	/**
	 * 작업공정 상세 조회
	 * @param processNo 공정번호
	 * @return 작업공정
	 * @throws Exception
	 */
	@GetMapping("/process/{processNo}")
	public ResponseEntity<Process> getProcess(@PathVariable(name = "processNo") int processNo) throws Exception
	{
		Process process = this.processService.getProcess(processNo);
		
		return ResponseEntity.ok().body(process);
	}
	
	/**
	 * 작업공정 생성
	 * @param process 작업공정
	 * @return 공정번호
	 * @throws Exception
	 */
	@PostMapping("/process")
	public ResponseEntity<Integer> createProcess(@RequestBody Process process) throws Exception
	{
		process.setCreateUserId("dev");
		Integer processNo = this.processService.createProcess(process);

		return ResponseEntity.ok().body(processNo);
	}
	
	/**
	 * 작업공정 수정
	 * @param process 작업공정
	 * @return 변경적용 행 수
	 * @throws Exception
	 */
	@PutMapping("/process")
	public ResponseEntity<Integer> updateProcess(@RequestBody Process process) throws Exception
	{
		process.setUpdateUserId("dev");
		Integer count = this.processService.updateProcess(process);

		return ResponseEntity.ok().body(count);
	}
}
