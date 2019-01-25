package com.she.manage.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.manage.mapper.CodeMasterMapper;
import com.she.manage.model.CodeMaster;

@Service
public class CodeMasterService
{
	
	@Autowired
	CodeMasterMapper codeMasterMapper;
	
	public List<CodeMaster> getSelect(String codeGroupCd) throws Exception 
	{
		return codeMasterMapper.getSelect(codeGroupCd);
	}

}
