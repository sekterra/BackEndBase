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

package com.she.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.manage.mapper.DeptMapper;
import com.she.manage.model.Dept;

/**
 * 부서 기능정의
 *
 */
@Service
public class DeptService
{
	@Autowired
	private DeptMapper deptMapper;
	
	/**
	 * 부서 조회
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param deptNm 부서명
	 * @return 부서목록
	 * @throws Exception
	 */
	public List<Dept> getDepts(int processNo, String deptCd, String deptNm) throws Exception
	{
		return this.deptMapper.getDepts(processNo, deptCd, deptNm);
	}
	
	/**
	 * 부서 상세 조회
	 * @param deptCd 부서코드
	 * @return 부서
	 * @throws Exception
	 */
	public Dept getDept(String deptCd) throws Exception
	{
		return this.deptMapper.getDept(deptCd);
	}
}
