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

import com.she.manage.model.User;

/**
 * 사용자 맵퍼
 *
 */
@Mapper
@Repository("com.she.manage.mapper.UserMapper")
public interface UserMapper
{
	/**
	 * 사용자 조회
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param userId 사용자아이디
	 * @param userNm 사용자명
	 * @return 사용자 목록
	 * @throws Exception
	 */
	public List<User> getUsers(
			@Param("processNo") int processNo, 
			@Param("deptCd") String deptCd, 
			@Param("userId") String userId, 
			@Param("userNm") String userNm) throws Exception;
	
	/**
	 * 사용자 상세 조회
	 * @param userId 사용자아이디
	 * @return 사용자
	 * @throws Exception
	 */
	public User getUser(@Param("userId") String userId) throws Exception;
}
