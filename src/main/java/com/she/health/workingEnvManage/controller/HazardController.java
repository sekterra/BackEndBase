package com.she.health.workingEnvManage.controller;

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

import com.she.health.model.Hazard;
import com.she.health.workingEnvManage.service.HazardService;
import com.she.utils.RequestMapper;

/**
 * 유해인자 조회
 * @param parameter 검색조건
 * @return 유해인자 목록
 * @throws Exception 예외
 */
@RestController
@RequestMapping("api/hea/workingenvmanage")
public class HazardController
{
	@Autowired
	private HazardService hazardService;
	
	@Autowired
	private RequestMapper requestMapper;
	
	/**
	 * 유해인자 목록 조회
	 * @param parameter 검색조건
	 * @return 유해인자 목록
	 * @throws Exception
	 */
	@GetMapping("/hazards")
	public ResponseEntity<List<Hazard>> getHazards(@RequestParam HashMap<String, Object> parameter) throws Exception
	{
		HashMap<String, Object> map = this.requestMapper.convertAsParameter(parameter);
		
		String heaHazardClassCd = map.containsKey("heaHazardClassCd") ? map.get("heaHazardClassCd").toString() : "";
		String heaHazardNmKo = map.containsKey("heaHazardNmKo") ? map.get("heaHazardNmKo").toString() : "";
		String specialYn = map.containsKey("specialYn") ? map.get("specialYn").toString() : "N";
		String workEnvYn = map.containsKey("workEnvYn") ? map.get("workEnvYn").toString() : "N";
		
		List<Hazard> hazards = this.hazardService.getHazards(heaHazardClassCd, heaHazardNmKo, specialYn, workEnvYn);
		
		return ResponseEntity.ok().body(hazards);
	}
	
	/**
	 * 유해인자 상세 조회
	 * @param heaHazardCd 유해인자 코드
	 * @return 유해인자
	 * @throws Exception
	 */
	@GetMapping("/hazard/{heaHazardCd}")
	public ResponseEntity<Hazard> getHazard(@PathVariable(name = "heaHazardCd") String heaHazardCd) throws Exception
	{
		return ResponseEntity.ok().body(this.hazardService.getHazard(heaHazardCd));
	}
	
	/**
	 * 유해인자 신규등록
	 * @param hazard 유해인자
	 * @return 등록 행 수
	 * @throws Exception
	 */
	@PostMapping("/hazard")
	public ResponseEntity<String> createHazard(@RequestBody Hazard hazard) throws Exception
	{
		hazard.setCreateUserId("dev");
		return ResponseEntity.ok().body(this.hazardService.createHazard(hazard));
	}
	
	/**
	 * 유해인자 수정
	 * @param hazard 유해인자
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@PutMapping("/hazard")
	public ResponseEntity<Integer> updateHazard(@RequestBody Hazard hazard) throws Exception
	{
		hazard.setUpdateUserId("dev");
		return ResponseEntity.ok().body(this.hazardService.updateHazard(hazard));
	}

}
