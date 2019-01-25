package com.she.health.drug.controller;

import java.util.Calendar;
import java.util.Date;
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

import com.she.health.drug.service.DrugService;
import com.she.health.model.Drug;
import com.she.health.model.Prescribe;
import com.she.utils.Methods;
import com.she.utils.RequestMapper;

@RestController
public class DrugController 
{
	@Autowired
	private DrugService drugService;
	
	@Autowired
	private RequestMapper requestMapper;
	
	/**
	 * 약품관리 조회
	 * @param 
	 * @return 약품관리 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/api/hea/drug/drugmanages")
	public ResponseEntity<List<Drug>> getDrugs(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap <String, Object> map = this.requestMapper.convertAsParameter(parameter);
		String useYn = map.containsKey("useYn")? map.get("useYn").toString():"";
		String drugNm = "";
		List<Drug> drugList = drugService.getDrugs(useYn, drugNm);
		return ResponseEntity.ok().body(drugList);
	}
	
	/**
	 * 약품관리 상세조회
	 * @param heaDrugNo 약품번호
	 * @return Drug 약품
	 * @throws Exception 예외
	 */
	@GetMapping("/api/hea/drug/drugmanage/{heaDrugNo}")
	public ResponseEntity<Drug> getDrug(@PathVariable("heaDrugNo") int heaDrugNo) throws Exception 
	{
		Drug drug = drugService.getDrug(heaDrugNo);
		return ResponseEntity.ok().body(drug);
	}
	
	/**
	 * 약품관리 신규등록
	 * @param Drug 약품
	 * @return heaDrugNo 약품번호
	 * @throws Exception 예외
	 */
	@PostMapping("/api/hea/drug/drugmanage")
	public ResponseEntity<Integer> createDrug(@RequestBody Drug drug) throws Exception 
	{
		return ResponseEntity.ok().body(drugService.createDrug(drug));
	}
	
	/**
	 * 약품관리 수정
	 * @param Drug 약품
	 * @return 수정행수
	 * @throws Exception 예외
	 */
	@PutMapping("/api/hea/drug/drugmanage")
	public ResponseEntity<Integer> updateDrug(@RequestBody Drug drug) throws Exception 
	{
		return ResponseEntity.ok().body(drugService.updateDrug(drug));
	}
	
	/**
	 * 약품 처방이력 조회
	 * @param parameter 검색조건
	 * @return 약품 처방이력 목록
	 * @throws Exception 예외
	 */
	@GetMapping("/api/hea/infirmary/infirmaryprescribes")
	public ResponseEntity<List<Prescribe>> getDrugPrescribes(@RequestParam HashMap<String, Object> parameter) throws Exception 
	{
		HashMap<String, Object> convertedParameter = requestMapper.convertAsParameter(parameter);
		int heaDrugNo = convertedParameter.containsKey("heaDrugNo") ? Integer.parseInt(convertedParameter.get("heaDrugNo").toString()) : 0;
		String[] duration = this.requestMapper.convertObjectListAsStringArray(convertedParameter.get("duration"));
		String startDt = "";
		String endDt = "";
		
		if(duration != null && duration.length == 2)
		{
			startDt = duration[0];
			endDt = duration[1];
		}
		
		List<Prescribe> prescribeList = drugService.getDrugPrescribes(heaDrugNo, startDt, endDt);
		return ResponseEntity.ok().body(prescribeList);
	}
}
