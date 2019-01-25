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

import com.she.manage.mapper.UserMapper;
import com.she.manage.model.User;

/**
 * 사용자 기능정의
 *
 */
@Service
public class UserService
{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 사용자 조회
	 * @param processNo 공정번호
	 * @param deptCd 부서코드
	 * @param userId 사용자아이디
	 * @param userNm 사용자명
	 * @return 사용자 목록
	 * @throws Exception
	 */
	public List<User> getUsers(int processNo, String deptCd, String userId, String userNm) throws Exception
	{
		return this.userMapper.getUsers(processNo, deptCd, userId, userNm);
	}
	
	/**
	 * 사용자 상세 조회
	 * @param userId 사용자아이디
	 * @return 사용자
	 * @throws Exception
	 */
	public User getUser(String userId) throws Exception
	{
		return this.userMapper.getUser(userId);
	}
}
