package com.she.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.she.manage.model.CodeMaster;
import com.she.manage.service.CodeMasterService;
import com.she.utils.RequestMapper;

@RestController
public class CodeMasterController
{
	
	// TODO : queryString 변환을 위한 mapper 선언
	@Autowired
	private RequestMapper requestMapper;

	@Autowired
	private CodeMasterService codeMasterService;
	
	@GetMapping("/api/manage/codemaster/getselect/{codeGroupCd}")
	public ResponseEntity<List<CodeMaster>> getSelect(@PathVariable String codeGroupCd) throws Exception 
	{		
		List<CodeMaster> codeMasters = this.codeMasterService.getSelect(codeGroupCd);
		return ResponseEntity.ok().body(codeMasters);
	}

}
