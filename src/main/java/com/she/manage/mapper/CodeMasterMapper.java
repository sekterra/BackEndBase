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

package com.she.manage.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.she.manage.model.CodeMaster;

@Mapper
@Repository("com.she.manage.mapper.CodeMasterMapper")
public interface CodeMasterMapper
{
	public List<CodeMaster> getSelect(String codeGroupCd) throws Exception;
}
