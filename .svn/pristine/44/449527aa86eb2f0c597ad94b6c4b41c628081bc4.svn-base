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

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.manage.model.Dept;

/**
 * 부서 맵퍼
 *
 */
@Mapper
@Repository("com.she.manage.mapper.DeptMapper")
public interface DeptMapper
{
	/**
	 * 부서 조회
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param deptNm 부서명
	 * @return 부서목록
	 * @throws Exception
	 */
	public List<Dept> getDepts(
			@Param("processNo") int processNo,
			@Param("deptCd") String deptCd, 
			@Param("deptNm") String deptNm) throws Exception;
	
	/**
	 * 부서 상세 조회
	 * @param deptCd 부서코드
	 * @return 부서
	 * @throws Exception
	 */
	public Dept getDept(@Param("deptCd") String deptCd) throws Exception;
}
